package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 2022-6-4
 * 每日一题
 */
public class P929 {
    public static void main(String[] args) {

    }

    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            String[] split = email.split("@");
            String s = split[0];
            if (s.contains("+")) {
                s = s.substring(0, s.indexOf("+"));
            }
            s = s.replaceAll("\\.*", "");
            set.add(s + "@" + split[1]);
        }
        for (String s : set) {
            System.out.println(s);
        }
        return set.size();
    }
}
