package leetcode;

import java.util.*;

/**
 * 2021-10-8
 * 每日一题
 */
public class P187 {
    public static void main(String[] args) {
        System.out.println(findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    }
    public static List<String> findRepeatedDnaSequences(String s) {
        if (s.length()<10){
            return new ArrayList<String>();
        }
        Set<String> set = new HashSet<String>();
        Map<String,Integer> map = new HashMap<>();
        int len = s.length();
        for (int i = 0;i < len-9;i++){
            String str = s.substring(i, i + 10);
            Set<String> strings = map.keySet();
            if (strings.contains(str)){
                set.add(str);
            }else {
                map.put(str,1);
            }
        }
        return new ArrayList<>(set);
    }
}
