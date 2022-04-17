package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 2022-4-10
 * 每日一题
 */
public class P804 {
    public static void main(String[] args) {

    }

    public int uniqueMorseRepresentations(String[] words) {
        String[] temp = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.",
                "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        Set<String> set = new HashSet<>();
        for (String word : words) {
            StringBuffer sb = new StringBuffer();
            for (int i = 0;i < word.length();i++){
                char c = word.charAt(i);
                sb.append(temp[c-'a']);
            }
            set.add(sb.toString());
        }
        return set.size();
    }
}
