package leetcode;

/**
 * 2021-12-01
 * 每日一题
 */
public class P1446 {
    public int maxPower(String s) {
        int i = 0;
        int max = 0;
        int count = 0;
        for (int t = 0; t < s.length(); t++) {
            if (s.charAt(t) == s.charAt(i)) {
                count++;
            }else {
                count=1;
                i = t;
            }
            max = max>count?max:count;
        }
        return max;
    }
}
