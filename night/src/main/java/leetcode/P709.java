package leetcode;

/**
 * 2021-12-12
 * 每日一题
 */
public class P709 {
    public static void main(String[] args) {
        toLowerCase("s");
    }

    // A=65  a=97
    public static String toLowerCase(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] > 64 && chars[i] < 91) {
                chars[i] = (char) (chars[i] + 32);
            }
        }
        return String.valueOf(chars);
    }
}
