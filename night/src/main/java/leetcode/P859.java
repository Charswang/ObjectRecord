package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 2021-11-23
 * 每日一题
 */
public class P859 {
    public boolean buddyStrings(String s, String goal) {
        char[] chars = s.toCharArray();
        int[] res = {0, s.length() - 1};
        int i = 0;
        int j = 0;
        Set<Character> set = new HashSet<>();
        while (i < chars.length) {
            final char a = s.charAt(i);
            final char b = goal.charAt(i);
            if (a != b) {
                res[j] = i;
                j++;
            }
            if (j == 2) {
                break;
            }
            i++;
            set.add(a);
        }
        if (s.equals(goal)) {
            if (set.size() == s.length()) {
                return false;
            } else {
                return true;
            }
        }
        if (j == 1 || res[0] == res[1]) {
            return false;
        }
        char temp = chars[res[0]];
        chars[res[0]] = chars[res[1]];
        chars[res[1]] = temp;

        if (String.valueOf(chars).equals(goal)) {
            return true;
        }
        return false;
    }
}
