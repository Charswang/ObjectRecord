package leetcode;

/**
 * 2022-2-20
 * 每日一题
 */
public class P717 {
    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        while (i < bits.length - 1) {
            if (bits[i] == 1) {
                i += 2;
            } else {
                i += 1;
            }
        }
        return i == (bits.length - 1) ? true : false;
    }
}
