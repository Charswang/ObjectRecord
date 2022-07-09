package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2022-07-04
 * 每日一题
 */
public class P1200 {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            int s = arr[i + 1] - arr[i];
            if (s <= min) {
                if (s < min) {
                    min = s;
//                    res = new ArrayList<>(); // 不使用clear的话，会让时间很高，但是内存使用的较少。
                    res.clear();  // 使用clear会让时间变快，但是会增加内存使用。
                }
                List<Integer> temp = new ArrayList<>();
                temp.add(arr[i]);
                temp.add(arr[i+1]);
                res.add(temp);
            }
        }
        return res;
    }
}
