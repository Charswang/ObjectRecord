package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 2022-6-23
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 */
public class P48_2 {
    public int lengthOfLongestSubstring(String s) {
        int i = -1;
        Map<Character, Integer> map = new HashMap<>();
        int res = 1;
        for (int j = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))){
                i = Math.max(i,map.get(s.charAt(j)));
            }
            map.put(s.charAt(j),j);
            res = Math.max(res,j-i);
        }
        return res;
    }
}
