package leetcode;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * 2022-1-23
 * 每日一题
 *
 * 自己首先想到的是按照value排序。。。
 */
public class P2034_UNFINISHED {
    int currentTime;
    // 存放时间点对应的price
    HashMap<Integer,Integer> map = new HashMap<>();
    // 每个price对应有多少个时间点
    TreeMap<Integer,Integer> treeMap = new TreeMap<>();

    public P2034_UNFINISHED() { }

    public void update(int timestamp, int price) {
        currentTime = Math.max(currentTime,timestamp);
        if (map.containsKey(timestamp)){
            int oldPrice = map.get(timestamp);
            int t_num = treeMap.get(oldPrice);
            if (t_num==1){
                treeMap.remove(oldPrice);
            }else{
                treeMap.put(oldPrice,t_num-1);
            }
        }
        map.put(timestamp,price);
        treeMap.put(price,treeMap.getOrDefault(price,0)+1);
    }

    public int current() {
        return map.get(currentTime);
    }

    public int maximum() {
        return treeMap.lastKey();
    }

    public int minimum() {
        return treeMap.firstKey();
    }
}
