package leetcode;

import java.util.*;

/**
 * 2021-10-19
 * 每日一题
 */
public class P211 {
    Map<Integer, Set<String>> map;

    public P211() {
        map = new HashMap<>();
    }

    public void addWord(String word) {
        int len = word.length();
        if (map.keySet().contains(len)) {
            map.get(word.length()).add(word);
        } else {
            Set<String> set = new HashSet<>();
            set.add(word);
            map.put(word.length(), set);
        }
    }

    public boolean search(String word) {
        int len = word.length();
        if (map.keySet().contains(word.length())) {
            for (String s : map.get(word.length())) {
                for (int i = 0; i < s.length(); i++) {
                    if (word.charAt(i) == '.' || word.charAt(i) == s.charAt(i)) {
                        if (i == (s.length() - 1)) {
                            return true;
                        }
                        continue;
                    }
                    break;
                }
            }
        }
        return false;
    }

}
