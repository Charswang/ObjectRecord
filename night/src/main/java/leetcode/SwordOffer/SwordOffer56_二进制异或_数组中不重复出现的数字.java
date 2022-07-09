package leetcode.SwordOffer;

/**
 * 2022-6-26
 * <p>
 * 异或计算类型题目
 */
public class SwordOffer56_二进制异或_数组中不重复出现的数字 {
    public int[] singleNumbers(int[] nums) {
        int z = 0;
        for (int num : nums) {
            z ^= num;
        } // 相同的数之间进行异或，得到的是0，否则不等于0，将所有数进行异或可以得到两个不重复出现的数字进行异或的结果。

        int m = 1;
        while ((z & m) == 0) {
            m = m << 1;
        } // 让m利用二进制，从右到左和z进行与运算，得到z最右边等于1的那一位。
        // 因为z再二进制中等于1的位置，是两个不重复出现的数字在二进制中出现不同值的位置

        int x = 0, y = 0;
        for (int num : nums) {
            if ((num & m) == 0) {
                x ^= num;
            } else {
                y ^= num;
            }
        }// 因为在m位置，两个目标数a,b，有一个是0，有一个是1。假设a在m位置上是0，b在m位置上是1
        // x==>：在二进制m位置上==0的数字之间的异或值
        // y==>：在二进制m位置上==1的数字之间的异或值
        // 像上面说的，两个相同的数之间进行异或，得到的仍然是0，所以，x最终得到的是m位置上等于0的a，y则是b；
        return new int[]{x,y};
    }
}
