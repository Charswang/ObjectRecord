package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 2021-11-7
 * 每日一题
 */
public class P598 {
    public static void main(String[] args) {
        int[][] ops = {{3,2},{5,3},{2,2},{5,5},{5,4},{2,1}};
        System.out.println(maxCount(5, 5, ops));
    }
    public static int maxCount(int m, int n, int[][] ops) {
        if (ops.length==0){
            return m*n;
        }
        Arrays.sort(ops, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        for (int[] op : ops) {
            System.out.println(op[0] + "--" + op[1]);
        }
        System.out.println("================================");
        int min_row = ops[0][0];
        Arrays.sort(ops, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        int min_col = ops[0][1];

        for (int[] op : ops) {
            System.out.println(op[0] + "--" + op[1]);
        }

        return min_col*min_row;
    }
}
