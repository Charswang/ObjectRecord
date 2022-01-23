package leetcode.competition.easy;

import java.util.*;

public class P5894 {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        Set<Integer> list1 = new TreeSet<>();
        Set<Integer> list2 = new TreeSet<>();
        Set<Integer> list3 = new TreeSet<>();
        Set<Integer> res = new TreeSet<>();
        for (int i = 0;i<nums1.length;i++){
            list1.add(nums1[i]);
        }
        for (int i = 0;i<nums2.length;i++){
            list2.add(nums2[i]);
        }
        for (int i = 0;i<nums3.length;i++){
            list3.add(nums3[i]);
        }
        for (Integer integer : list1) {
            if (list2.contains(integer) || list3.contains(integer)){
                res.add(integer);
            }
        }
        for (Integer integer : list2) {
            if (list3.contains(integer)){
                res.add(integer);
            }
        }
        return new ArrayList<>(res);
    }
}
