package ResearchProject.CompressChange;

import ResearchProject.HotColdIdentify.DoubleLinkList;
import ResearchProject.HotColdIdentify.Node;
import ResearchProject.HotColdIdentify.UpdateLRUCache;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;

public class CompressMiddleware {
    // 创建HotList
    // 注意更改温热队列的长度的时候，后面从热队列踢出和温队列踢出数据时队列长度也要进行更改
    static UpdateLRUCache hotList = new UpdateLRUCache(100);
    // 创建CandidateList
    static UpdateLRUCache candidateList = new UpdateLRUCache(200);
    //定义压缩算法的序号
    static String[] compressMethodSuffix = {".deflate", ".bz2", ".snappy", ".lz4", ".gzip"};
    // 引入阈值【候选队列迁入热队列的阈值】==怎么去定义合适？
    static int threshold = 4;
    // 元数据
    // 存放文件压缩元数据  greatAlgMap comSizeMap comTimeMap decomTimeMap originSizeMap
    static List<HashMap> meta;
    // 生成线程池：单个线程池的话是肯定会保证所有异步任务顺序执行的；但是时间会很慢
    static ExecutorService executor; // 还没用到
    // 查看访问过程中更改压缩算法的次数
    static int count=0;
    //放置目前访问序号文件在系统中的压缩算法<访问序号，对应算法序号>
    // 约定-1为None；  0为deflate； 1为bz2； 2为snappy； 3为lz4； 4为gzip；
    static Map<Integer,Integer> testMap = new HashMap<>();
    // 放置所有文件元数据信息的Map
    static HashMap<String,String[]> greatAlgMap = null;
    static HashMap<String,long[]> comSizeMap = null;
    static HashMap<String,long[]> comTimeMap = null;
    static HashMap<String,long[]> decomTimeMap = null;
    static HashMap<Integer,Long> originSizeMap = null;
    // 设置一个map存放每个文件从开始访问到目前的访问次数
    static HashMap<Integer,Integer> accessNum = new HashMap<>();
    // 设置一个map存放每个文件距离上次访问有多长时间【隔了几次访问】
    static HashMap<Integer,Integer> noaccessNum = new HashMap<>();
    // 下面啊这个没用到
    static Map<Integer,Integer> noChangeHot = new HashMap<>();

    /**
     * 测试入口
     * 1、读取zipf访问数据【访问任务】
     * 2、读取文件压缩元数据
     * 3、遍历访问任务
     * @param args
     */
    public static void main(String[] args) {

    }

    public static void checkChangeColdJob(Integer list){
        /**
         * 变冷的筛选能不能搞个未来访问概率啥的？
         */
        // 更新文件距离上次访问有多久没被访问
        for (Integer integer : testMap.keySet()) {
            if (integer==list){
                noaccessNum.put(integer,0);
            }else {
                // 实时的根据距离上次访问的距离进行更换成冷数据，总的访问时间会增加很多
                if (noaccessNum.keySet().contains(integer)){
                    noaccessNum.put(integer,noaccessNum.get(integer)+1);
                    if (!hotList.hashMap.keySet().contains(integer) && !candidateList.hashMap.keySet().contains(integer) && noaccessNum.get(integer)>2500){
                        String[] strings = greatAlgMap.get("hdfs://localhost:9010/sdgenTest/test_io_" + integer);
                        if (testMap.get(integer)!=Integer.parseInt(strings[0]) && testMap.get(integer)!=1){
                            if (noaccessNum.get(integer)>5000){
                                // 更换压缩算法
                                Thread t = new Thread(()->{
                                    // 新线程更换压缩算法 -- 注意这里弄得是每个压缩任务都是一个新的线程，后面可以考虑弄个线程池，在线程池固定的线程个数下进行更换压缩算法
                                    try{
                                        ChangeCompression.changeCompressionMethod("hdfs://localhost:9010/sdgenTest/test_io_" + integer,"1");
                                        testMap.put(integer,1);
                                        System.out.println(integer + "最冷");
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                });
                            }else {
                                // 更换压缩算法
                                Thread t = new Thread(()->{
                                    // 新线程更换压缩算法 -- 注意这里弄得是每个压缩任务都是一个新的线程，后面可以考虑弄个线程池，在线程池固定的线程个数下进行更换压缩算法
                                    try{
                                        ChangeCompression.changeCompressionMethod("hdfs://localhost:9010/sdgenTest/test_io_" + integer,strings[0]);
                                        testMap.put(integer,Integer.parseInt(strings[0]));//strings[0]存放的是变为冷数据的时候的压缩算法，不是绝对的bz2.因为bz2访问时间太多了
                                        System.out.println(integer + "次冷");
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                });
                            }
                            count++;
                            // accessNum.put(integer,0);
                        }
                    }
                }/*else {//距离开始访问时间有多久没被访问过
                    // 这里被注释掉了，就先不写上来了
                }*/
            }
        }
    }
    /**
     * 获取访问数据
     *
     * @return
     * @throws IOException
     */
    public static List<Integer> getAccessData() throws IOException {
        // 读入访问数据
        List<Integer> accessDatas = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("E:\\IdeaWork\\night\\src\\main\\java\\ResearchProject\\HotColdIdentify\\zipf_data.txt")));
        String line_text = null;
        while ((line_text = br.readLine()) != null) {
            // 【注意】文件序号要从1开始；
            accessDatas.add(Integer.parseInt(line_text));
        }
        br.close();
        return accessDatas;
    }
    /**
     * HotList没有命中的情况
     *
     * @param list
     */
    public static void hotMiss(Integer list) {
        // candidateList命中
        if (candidateList.getCounter(list) != -1) {
            candidateHit(list);
        } else {
            candidateMiss(list);
        }
    }
    /**
     * HotList命中
     *
     * @param list
     */
    public static void hotHit(Integer list) {
        if (hotList.getRecency(list) == 1) {
            hotList.put(list, hotList.getCounter(list) + 2, 1);
        } else {
            hotList.put(list, hotList.getCounter(list) + 1, 1);
        }
    }

    /**
     * 有个提交异步任务到线程池exector中
     * 因为被注释掉了，这里就暂时不写了
     */

    /**
     * CandidateList未命中
     *
     * @param list
     */
    public static void candidateMiss(Integer list) {
        /*Random random = new Random();
        int i = random.nextInt(2);
        if (i==0){
            return;
        }*/
        // 判断CandidateList是否已满，已满的话，则筛选;
        if (candidateList.cache.size() == 200) {
            Node screen_candidate = screen(candidateList);
            candidateList.deleteKey(screen_candidate.key);
            /**
             * 温变冷
             */
        }
        // 如果要加入CandidateList队列的话，counter和recency置为1
        candidateList.put(list, 1, 1);
        /**
         * 冷变温
         * 筛选是否满足更改条件
         */
        String[] strings = greatAlgMap.get("hdfs://localhost:9010/sdgenTest/test_io_" + list);
        boolean b = false;
        if (testMap.get(list)!=Integer.parseInt(strings[1])){
            b = needChangeHotCheck(accessNum.get(list),list,strings[1]);
        }
        if (b){
            // 更换压缩算法
            Thread t = new Thread(()->{
                // 新线程更换压缩算法 -- 注意这里弄得是每个压缩任务都是一个新的线程，后面可以考虑弄个线程池，在线程池固定的线程个数下进行更换压缩算法
                try{
                    ChangeCompression.changeCompressionMethod("hdfs://localhost:9010/sdgenTest/test_io_" + list,strings[1]);
                    /**
                     * 需要考虑一个问题：如果在更改的过程中，这个文件又触发了更改压缩算法的任务呢？这样应该会导致程序出错吧。。
                     */
                    testMap.put(list,Integer.parseInt(strings[1]));//strings[0]存放的是变为冷数据的时候的压缩算法，不是绝对的bz2.因为bz2访问时间太多了
                    count++;
                    System.out.println(list + "冷-温");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }
    /**
     * CandidateList命中
     *
     * @param list
     */
    public static void candidateHit(Integer list) {
        int recency_bit = candidateList.getRecency(list);
        if (recency_bit == 0) {
            candidateList.put(list, candidateList.getCounter(list) + 1, 1);
        } else {
            candidateList.put(list, candidateList.getCounter(list) + 2, 1);
        }
        // counter是否大于阈值，需要加上判断hotList满不满，如果满的话要筛选出一个放到candidateList中，否则的话就直接加上
        if (candidateList.getCounter(list) > threshold) {
            // 判断hotList是不是满的
            if (hotList.cache.size() == 100) {
                // 筛选出来一个节点
                Node screen_hot = screen(hotList);
                // hotList删除节点
                hotList.deleteKey(screen_hot.key);
                //筛选出来的节点要放入candidateList中，并且counter要折半
                if (candidateList.cache.size() == 200) {
                    Node screen_candidate = screen(candidateList);
                    candidateList.deleteKey(screen_candidate.key);
                    /**
                     * 温变冷
                     */
                }
                candidateList.put(screen_hot.key, screen_hot.counter / 2, 1);
                /**
                 * 热变温
                 */
                String[] strings = greatAlgMap.get("hdfs://localhost:9010/sdgenTest/test_io_" + screen_hot.key);
                // 更换压缩算法
                Thread t = new Thread(()->{
                    // 新线程更换压缩算法 -- 注意这里弄得是每个压缩任务都是一个新的线程，后面可以考虑弄个线程池，在线程池固定的线程个数下进行更换压缩算法
                    try{
                        ChangeCompression.changeCompressionMethod("hdfs://localhost:9010/sdgenTest/test_io_" + screen_hot.key,strings[1]);
                        testMap.put(screen_hot.key,Integer.parseInt(strings[1]));//strings[0]存放的是变为冷数据的时候的压缩算法，不是绝对的bz2.因为bz2访问时间太多了
                        count++;
                        System.out.println(list + "热-温");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            }
            // 加入新数据到hotList
            hotList.put(list, candidateList.getCounter(list), 1);
            /**
             * 温-热
             */
            String[] strings = greatAlgMap.get("hdfs://localhost:9010/sdgenTest/test_io_" + list);
            boolean b = false;
            if (testMap.get(list)!=Integer.parseInt(strings[2])){
                b = needChangeHotCheck(accessNum.get(list),list,strings[2]);
            }
            if (b){
                // 更换压缩算法
                Thread t = new Thread(()->{
                    // 新线程更换压缩算法 -- 注意这里弄得是每个压缩任务都是一个新的线程，后面可以考虑弄个线程池，在线程池固定的线程个数下进行更换压缩算法
                    try{
                        ChangeCompression.changeCompressionMethod("hdfs://localhost:9010/sdgenTest/test_io_" + list,strings[2]);
                        /**
                         * 需要考虑一个问题：如果在更改的过程中，这个文件又触发了更改压缩算法的任务呢？这样应该会导致程序出错吧。。
                         */
                        testMap.put(list,Integer.parseInt(strings[2]));
                        count++;
                        System.out.println(list + "温-热");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            }
            // 把候选队列中的元素删除
            candidateList.deleteKey(list);
        }
    }
    /**
     * 筛选机制
     *
     * @param updateLRUCache
     * @return
     */
    public static Node screen(UpdateLRUCache updateLRUCache) {
        // 1、先筛选出来recency=0中counter值小于阈值的，没有的话再找recency=1中counter值小于阈值的，但是如果两个都没有呢？
        // 2、先筛选出来recency=0中counter值最小的，没有recency=0的值的话再找recency=1中counter值最小的
        // 先使用2
        DoubleLinkList cache = updateLRUCache.cache;
        Node p = cache.tail.prev;
        int min_counter = Integer.MAX_VALUE;
        Node min_node = null;
        while (p != null) {
            if (p.recency == 0) {
                if (min_counter > p.counter) {
                    min_counter = p.counter;
                    min_node = p;
                }
                p = p.prev;
            } else {
                break;
            }
        }
        if (min_node == null) {
            while (p != null) {
                if (p.recency == 1) {
                    if (min_counter > p.counter) {
                        min_counter = p.counter;
                        min_node = p;
                    }
                    p = p.prev;
                }
            }
        }
        return min_node;
    }
    /**
     * 衰减机制，定周期进行衰减
     */
    public static void attenuation() {
        HashMap<Integer, Node> hashMap = hotList.hashMap;
        for (Map.Entry<Integer, Node> entry : hashMap.entrySet()) {
            int counter = entry.getValue().counter / 2;
            int key = entry.getKey();
            hotList.setCounter(key, counter);
        }
    }
    public static boolean needChangeHotCheck(int frequency,int accessIndex,String targetCodec){

        return false;
    }
}
