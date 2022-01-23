package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 2021-11-1
 * 每日一题
 */
public class P575 {
    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>();
        for (int i : candyType) {
            set.add(i);
        }
        int dif_num = set.size();
        int mid = candyType.length / 2;
        if (dif_num<=mid){
            return dif_num;
        }else{
            return mid;
        }
    }
}
