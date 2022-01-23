package leetcode;

/**
 * 2021-9-21
 * 类型：每日一题
 * 级别：easy
 */
public class P58 {
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("   fly me   to   the    moon  "));
    }

    public static int lengthOfLastWord(String s) {
        String trim = s.trim();
        int i = trim.lastIndexOf(" ");
        return trim.length() - i - 1;
    }
}
