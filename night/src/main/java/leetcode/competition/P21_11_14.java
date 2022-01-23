package leetcode.competition;

import java.util.Arrays;
import java.util.Comparator;

public class P21_11_14 {
    public static void main(String[] args) {
        int[][] temp = {{1,2},{3,2},{2,4},{5,6},{3,5}};
        Arrays.sort(temp, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1]-o1[1];
            }
        });
        for (int i = 0;i<temp.length;i++){
            for (int j = 0;j < temp[0].length;j++){
                System.out.print(temp[i][j] + " ");
            }
            System.out.println();
        }
    }
    public boolean checkAlmostEquivalent(String word1, String word2) {
        char[] c1 = new char[26];
        char[] c2 = new char[26];
        int n = word1.length();
        for (int i = 0;i<n;i++){
            char a1 = word1.charAt(i);
            char a2 = word2.charAt(i);
            c1[a1-97]++;
            c2[a2-97]++;
        }
        for (int i=0;i<26;i++){
            if (Math.abs(c1[i]-c2[i])>3){
                return false;
            }
        }
        return true;
    }

    /**
     * 能看错题意，我也是服了。。。
     * @param items
     * @param queries
     * @return
     */
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1]-o1[1];
            }
        });
        int[] res = new int[queries.length];
        for (int t = 0;t < queries.length;t++){
            int value = queries[t];
            for (int[] item : items) {
                if (item[0]<=value){
                    res[t] = item[1];
                    break;
                }
            }
        }
        return res;
        /*int len = items.length;
        int[] res = new int[queries.length];
        for (int t=0;t<queries.length;t++) {
            int value = queries[t];
            int[][] dp = new int[len+1][value+1];
            int max = 0;
            for (int i = 1;i<=len;i++){
                for (int j = 1;j<=value;j++){
                    if (items[i-1][0]>j){
                        dp[i][j] = dp[i-1][j];
                    }else{
                        dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-items[i-1][0]]+items[i-1][1]);
                    }
                    max = dp[i][j]>max?dp[i][j]:max;
                }
            }
            res[t]=max;
        }
        return res;*/
    }
}
