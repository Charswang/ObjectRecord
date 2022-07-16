package leetcode.程序员面试宝典;

/**
 * 2022-7-16
 */
public class P01_03 {
    public static void main(String[] args) {

    }

    public String replaceSpaces(String S, int length) {
        int i = length - 1;
        int j = S.length() - 1;
        char[] chars = S.toCharArray();
        while (i >= 0) {
            if (chars[i] == ' ') {
                chars[j--] = '0';
                chars[j--] = '2';
                chars[j--] = '%';
            } else {
                chars[j--] = chars[i];
            }
            i--;
        }
        return String.valueOf(chars, j + 1, S.length() - 1);
    }

    public String replaceSpaces2(String S, int length) {
        String s = S.substring(0, length).replaceAll(" ", "%20");
        return s;
    }
}
