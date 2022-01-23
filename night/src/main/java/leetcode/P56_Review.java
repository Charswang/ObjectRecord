package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * 2021-9-4
 */
public class P56_Review {
    public static void main(String[] args) {
//        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] intervals = {{1, 4}, {0, 0}};
        int[][] merge = merge(intervals);
        for (int[] ints : merge) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    public static int[][] merge(int[][] intervals) {
        // 先进行排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        ArrayList<int[]> lists = new ArrayList<>();
        for (int[] interval : intervals) {
            if (lists.size() == 0 || lists.get(lists.size() - 1)[1] < interval[0]) {
                lists.add(interval);
            } else {
                int left = lists.get(lists.size() - 1)[0];
                int right = Math.max(lists.get(lists.size() - 1)[1],interval[1]);
                int[] temp = {left,right};
                lists.set(lists.size()-1,temp);
            }
        }
        return lists.toArray(new int[lists.size()][2]);
    }
}
