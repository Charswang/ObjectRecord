package leetcode;

/**
 * 2021-9-4
 * <p>
 * >> 二进制向右移  负数右移的时候补1
 * >>> 二进制无符号右移--逻辑右移。负数右移的时候补0，不会补1
 */
public class P190_UNFINISHED {
    public static void main(String[] args) {
        int n = -3;
        int i = reverseBits(n);
        System.out.println(i);
    }

    public static int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32 && n != 0; i++) {
            res += (n & 1) << (31 - i);
            n >>>= 1;
        }
        return res;
    }
}
