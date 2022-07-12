package leetcode.SwordOffer;

public class SwordOffer15 {
    public int hammingWeight(int n) {
        /*int res = 0;
        while (n != 0) {
            res++;
            n &= n-1;
        }
        return res;*/

        int res = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) == 1) {
                res++;
            }
        }
        return res;
    }
}
