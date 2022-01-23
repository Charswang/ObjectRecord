package ResearchProject.HotColdIdentify;

import java.io.*;
import java.util.*;

public class TestIdentify {
    // 创建HotList
    static UpdateLRUCache hotList = new UpdateLRUCache(60);
    // 创建CandidateList
    static UpdateLRUCache candidateList = new UpdateLRUCache(60);
    // 引入阈值==怎么定义才合适
    static int threshold = 5;

    /**
     * 测试入口
     */
    public static void main(String[] args) throws IOException {
        // 读取访问数据
        List<Integer> lists = getAccessData();
        // 数据访问
        int a = 0;
        for (Integer list : lists) {
            // hotLisy未命中
            if (hotList.getCounter(list) == -1) {
                hotMiss(list);
            }
            // hotList命中
            if (hotList.getCounter(list) != -1) {
                a++;
                hotHit(list);
            }
        }
        // 查看10000条访问记录访问300条数据之后的热数据识别结果
        HashMap<Integer, Node> hashMap = hotList.hashMap;
        for (Map.Entry<Integer, Node> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey() + "=>" + entry.getValue().counter + "=>" + entry.getValue().recency);
        }
        System.out.println("============================================================");
        System.out.println("命中率为：" + a * 1.0 / lists.size());
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
        if (candidateList.cache.size() == 60) {
            Node screen_candidate = screen(candidateList);
            candidateList.deleteKey(screen_candidate.key);
        }
        // 如果要加入CandidateList队列的话，counter和recency置为1
        candidateList.put(list, 1, 1);
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
            if (hotList.cache.size() == 60) {
                // 筛选出来一个节点
                Node screen_hot = screen(hotList);
                // hotList删除节点
                hotList.deleteKey(screen_hot.key);
                //筛选出来的节点要放入candidateList中，并且counter要折半
                if (candidateList.cache.size() == 60) {
                    Node screen_candidate = screen(candidateList);
                    candidateList.deleteKey(screen_candidate.key);
                }
                candidateList.put(screen_hot.key, screen_hot.counter / 2, 1);
            }
            // 加入新数据到hotList
            hotList.put(list, candidateList.getCounter(list), 1);
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
}
