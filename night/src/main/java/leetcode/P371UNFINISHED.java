package leetcode;

/**
 * 2021-9-27
 * 2021-9-26的每日一题
 */
public class P371UNFINISHED {
    public static void main(String[] args) {
        int sum = getSum(2, 3);
        System.out.println(sum);
    }
    public static int getSum(int a, int b) {
        int sum = a ^ b; // 先得不进位的和
        int carry = (a&b)<<1;
        if (carry!=0){
            return getSum(sum,carry);
        }
        return sum;
    }
}
