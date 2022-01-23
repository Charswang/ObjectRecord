package leetcode;

/**
 * 2022-1-22
 * 每日一题
 */
public class P1332 {
    public int removePalindromeSub(String s) {
        if (huiwen(s)){
            return 1;
        }
        return 2;
    }
    public boolean huiwen(String s) {
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            int j = len - i - 1;
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
