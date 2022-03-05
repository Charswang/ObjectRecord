package leetcode;

/**
 * 2022-3-5
 * 每日一题
 */
public class P521 {
    public int findLUSlength(String a, String b) {
        if (a.equals(b)){
            return -1;
        }
        return Math.max(a.length(),b.length());
    }
}
