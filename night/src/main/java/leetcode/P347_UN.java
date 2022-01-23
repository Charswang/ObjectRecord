package leetcode;

import java.util.*;

/**
 * 2021-12-02
 */
public class P347_UN {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        Map<Integer,Integer> map = new TreeMap<Integer,Integer>();
        for (int num : nums) {
            if (map.keySet().contains(num)){
                map.put(num,map.get(num)+1);
            }else {
                map.put(num,1);
            }
        }
        List<Map.Entry<Integer,Integer>> entrys = new ArrayList<>(map.entrySet());
        Collections.sort(entrys, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue()-o1.getValue();
            }
        });
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : entrys) {
            if (i>=res.length){
                break;
            }
            res[i] = entry.getKey();
            i++;
        }

        return res;
    }
}
