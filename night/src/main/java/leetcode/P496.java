package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 2021-10-26
 * 每日一题
 */
public class P496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0;i < nums2.length;i++){
            map.put(nums2[i],i);
        }
        for (int i = 0;i < nums1.length;i++){
            res[i] = -1;
            if (map.keySet().contains(nums1[i])){
                int index = map.get(nums1[i]);
                if (index<(nums2.length-1)){
                    for (int j = index+1;j<nums2.length;j++){
                        if (nums2[j]>nums1[i]){
                            res[i] = nums2[j];
                            break;
                        }
                    }
                }
            }
        }
        return res;
    }
}
