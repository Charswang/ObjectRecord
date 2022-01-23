package leetcode;

import java.util.*;

/**
 * 2021-9-14  每日一题，以前写过。
 */
public class P524 {
    public static void main(String[] args) {
        String s = "abpcplea";
        List<String> dictionary = new ArrayList<>();
        dictionary.add("a");
        dictionary.add("b");
        dictionary.add("c");
        String longestWord = findLongestWord(s, dictionary);
        System.out.println(longestWord);
    }
    public static String findLongestWord(String s, List<String> dictionary) {
        Collections.sort(dictionary, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()==o2.length()?o1.compareTo(o2):o2.length()-o1.length();
            }
        });
        for (String s1 : dictionary) {
            System.out.println(s1);
        }
        for (String s1 : dictionary) {
            char[] chars = s1.toCharArray();
            int a = 0;
            int i = 0;
            while (i < chars.length && a < s.length()){
                if (s.charAt(a)==chars[i]){
                    i++;
                }
                a++;
            }
            if (i==chars.length){
                return s1;
            }
        }
        return "";
    }
}
