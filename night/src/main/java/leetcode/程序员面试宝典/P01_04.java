package leetcode.程序员面试宝典;

import java.util.HashMap;
import java.util.Map;

/**
 * 2022-7-16
 */
public class P01_04 {
    public static void main(String[] args) {

    }

    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int flag = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            if (value % 2 == 1) {
                if (flag > 0) {
                    return false;
                }
                flag++;
            }
        }
        return true;
    }

    /**
     * 用int[] temp = new int[26];识别不出来//\\等符号
     *
     * @param s
     * @return
     */
    public boolean canPermutePalindrome2(String s) {
        int[] temp = new int[26];
        int flag = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            int a = c - 'a';
            if (a > 25 || a < 0) {
                return false;
            }
            temp[s.charAt(i) - 'a']++;
        }
        for (int c : temp) {
            if (c % 2 == 1) {
                if (flag > 0) {
                    return false;
                }
                flag++;
            }
        }
        return true;
    }
}
