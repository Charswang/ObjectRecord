package leetcode;

/**
 * 2022-1-9
 * 每日一题
 */
public class P1629 {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int max = releaseTimes[0];
        char c = keysPressed.charAt(0);
        for (int i = 1; i < releaseTimes.length; i++) {
            int r = releaseTimes[i] - releaseTimes[i - 1];
            if (r == max) {
                if (keysPressed.charAt(i) > c) {
                    c = keysPressed.charAt(i);
                }
            } else if (r > max) {
                max = r;
                c = keysPressed.charAt(i);
            }
        }
        return c;
    }
}
