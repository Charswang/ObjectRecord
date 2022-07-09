package leetcode.SwordOffer;

/**
 * 2022-6-26
 * <p>
 * 异或计算类型题目
 * <p>
 * 遍历统计
 */
public class SwordOffer56_II_二进制异或_数组中不重复出现的数字 {
    public int singleNumbers(int[] nums) {
        int[] count = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                count[i] += num & 1;
                num = num >> 1;
            }
        } // 统计所有数在32位二进制数的每个位置上为1的总数。

        int res = 0;
        for (int i = 0;i < 32;i++){
            res = res << 1;
            res |= count[31-i] % 3;
        } // 32位二进制中每个位置上1的个数不能整除3的，表示为目标数字在该位置上为1，遍历统计将最终目标数字还原出来

        return res;
    }
}
