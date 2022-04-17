package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2022-4-17
 * 每日一题
 *
 * 代码好烂
 */
public class P819 {
    public static void main(String[] args) {
        String paragraph = "Bob! hit? a? ball' the' hit; BALL; flew. far after it was hit.";
        String[] banned = {"hit"};
        String s = mostCommonWord(paragraph, banned);
        System.out.println(s);
    }
    public static String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.toLowerCase();
        String s = paragraph.replaceAll("!|\\?|'|,|;|\\.", " ");
        String[] s1 = s.split(" +");
        Map<String,Integer> map = new HashMap<>();
        List<String> strings = Arrays.asList(banned);
        for (String s2 : s1) {
            if (!strings.contains(s2)){
                map.put(s2,map.getOrDefault(s2,0)+1);
            }
        }
        String res="";
        int max = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue()>max){
                max = entry.getValue();
                res = entry.getKey();
            }
        }
        return res;
    }
}
