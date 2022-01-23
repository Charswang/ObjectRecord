package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2021-11-28
 * 每日一题
 */
public class P438 {
    public static void main(String[] args) {
        // cbaebabacd  abc
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(findAnagrams(s, p));
    }
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int[] chars_p = new int[26];
        for (int i = 0;i < p.length();i++){
            chars_p[p.charAt(i)-97]++;
        }
        int len = s.length()-p.length();
        for (int i = 0;i <=len;i++){
            int[] temp = new int[26];
            boolean flag = true;
            for (int j=i;j < i+p.length();j++){
                char c = s.charAt(j);
                int c_num = c - 97;
                if (temp[c_num]<chars_p[c_num]){
                    temp[c_num]++;
                }else{
                    flag=false;
                    break;
                }
            }
            if (flag){
                res.add(i);
            }
        }
        return res;
    }
    /**
     * 超出时间限制
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams1(String s, String p) {
        List<Integer> res = new ArrayList<>();
        char[] chars_p = p.toCharArray();
        int len_s = s.length();
        int len_p = p.length();
        int len = len_s-len_p;
        for (int i = 0;i <= len;i++){
            String substring = s.substring(i, i + len_p);
            char[] chars = substring.toCharArray();
            Arrays.sort(chars);
            Arrays.sort(chars_p);
            if (String.valueOf(chars).equals(String.valueOf(chars_p))){
                res.add(i);
            }
        }
        return res;
    }
}
