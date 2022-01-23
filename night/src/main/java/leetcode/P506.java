package leetcode;

import java.util.*;

/**
 * 2021-12-02
 * 每日一题
 */
public class P506 {
    public static void main(String[] args) {
        int[] score = {10,3,8,9,4};
        String[] relativeRanks = findRelativeRanks(score);
        for (String relativeRank : relativeRanks) {
            System.out.print(relativeRank + " ");
        }
    }
    public static String[] findRelativeRanks(int[] score) {
        List<Integer> list = new ArrayList<>();
        String[] t = {"Gold Medal","Silver Medal","Bronze Medal"};
        for (int i : score) {
            list.add(i);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for (Integer integer : list) {
            System.out.println(integer);
        }
        String[] res = new String[score.length];
        for (int i = 0;i < res.length;i++){
            if (list.indexOf(score[i])>2){
                res[i] = list.indexOf(score[i])+1+"";
            }else{
                res[i] = t[list.indexOf(score[i])];
            }
        }
        return res;
    }
}
