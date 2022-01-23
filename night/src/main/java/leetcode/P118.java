package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author charswang
 * @date 2021-08-14
 */
public class P118 {
    public List<List<Integer>> generate(int numRows) {
        int[][] dp = new int[numRows][numRows];
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        for (int i = 0;i<numRows;i++){
            ArrayList<Integer> integers = new ArrayList<Integer>();
            for (int j = 0;j<=i;j++){
                if (j==0 || j==i){
                    dp[i][j] = 1;
                    integers.add(dp[i][j]);
                    continue;
                }
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                integers.add(dp[i][j]);
            }
            lists.add(integers);
        }
        return lists;
    }
}
