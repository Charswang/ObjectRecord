package leetcode.competition;

import java.util.*;

public class P21_11_7 {
    /*public static void main(String[] args) {

    }*/

    public int countVowelSubstrings(String word) {
        List<Character> list = new ArrayList<>();
        list.add('a');
        list.add('e');
        list.add('i');
        list.add('o');
        list.add('u');

        int res = 0;
        for (int i = 0;i < word.length()-4;i++){
            Set<Character> set = new HashSet<>();
            for (int j = i;j < word.length();j++){
                if (list.contains(word.charAt(j))){
                    set.add(word.charAt(j));
                    if (set.size()==5){
                        res++;
                    }
                }else{
                    break;
                }
            }
        }
        return res;
    }

    public long countVowels(String word) {
        List<Character> list = new ArrayList<>();
        list.add('a');
        list.add('e');
        list.add('i');
        list.add('o');
        list.add('u');
        long res = 0;
        long[] dp = new long[word.length()];
        dp[0] = list.contains(word.charAt(0))?1:0;
        for (int i = 1;i<dp.length;i++){
            if (!list.contains(word.charAt(i))){
                dp[i] = dp[i-1];
            }else {
                dp[i] = dp[i-1] + i + 1;
            }
        }
        return Arrays.stream(dp).sum();
        /*int[][] dp = new int[word.length()][word.length()];
        for (int i = 0;i < word.length();i++){
            if (list.contains(word.charAt(i))){
                dp[i][i] = 1;
            }
            res+=dp[i][i];
            for (int j = i+1;j<word.length();j++){
                if (list.contains(word.charAt(j))){
                    dp[i][j] = dp[i][j-1] + 1;
                }else{
                    dp[i][j] = dp[i][j-1];
                }
                res+=dp[i][j];
            }
        }
        return res;*/
    }

}
