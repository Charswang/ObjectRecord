package ResearchProject.HotColdIdentify;

import java.util.HashMap;

public class UpdateLRUCache {
    public HashMap<Integer,Node> hashMap;
    public DoubleLinkList cache;
    public int cap;

    public UpdateLRUCache(int capacity){
        hashMap = new HashMap<>();
        cache = new DoubleLinkList();
        this.cap = capacity;
    }

    /**
     * 设置counter
     * @param key
     * @param counter
     */
    public void setCounter(int key,int counter){
        // 获取key对应节点
        Node node = cache.getNode(key);
        // 设置节点的counter
        node.counter = counter;
        // 设置hashmap中的node
        hashMap.put(key,node);
    }

    /**
     * 设置retency
     * 将某个key提升为最近使用的
     * @param key
     */
    public void makeRecently(int key){
        Node node = hashMap.get(key);
        // 先删除该节点
        cache.remove(node);
        // 将该节点添加到队头
        cache.addFirst(node);
    }

    /**
     * 添加最近使用的元素
     * @param key
     * @param counter
     * @param recency
     */
    public void addRecently(int key,int counter,int recency){
        Node newNode = new Node(key, counter, recency);
        // 在链表头部添加节点
        cache.addFirst(newNode);
        // 在map里添加该节点
        hashMap.put(key,newNode);
    }

    /**
     * 删除某一个key
     * @param key
     */
    public void deleteKey(int key){
        Node node = hashMap.get(key);
        cache.remove(node);
        hashMap.remove(key);
    }

    /**
     * 删除最久未使用的元素
     */
    public void removeLeastRecently(){
        // 链表的最后一个元素，就是最久未使用的
        Node node = cache.removeLast();
        hashMap.remove(node.key);
    }

    public int getCounter(int key){
        if (!hashMap.containsKey(key)){
            return -1;
        }
        makeRecently(key);
        return hashMap.get(key).counter;
    }

    public int getRecency(int key){
        if (!hashMap.containsKey(key)){
            return -1;
        }
        makeRecently(key);
        return hashMap.get(key).recency;
    }

    public void put(int key,int counter,int recency){
        // 若key存在
        if (hashMap.containsKey(key)){
            deleteKey(key);
            addRecently(key, counter, recency);
            return;
        }
        if (cap==cache.size()){
            removeLeastRecently();
        }
        // 有新数据插入时，要将其他节点的recency设为0
        Node p = cache.head.next;
        while (p.key!=0){
            p.recency = 0;
            hashMap.put(p.key,p);
            p=p.next;
        }
        addRecently(key, counter, recency);
    }
}
