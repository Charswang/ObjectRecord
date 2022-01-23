package leetcode;

/**
 * 2021-8-30
 * 统计5作为因子时，5的个数
 */
public class P172_UNFINISHED {
    public static void main(String[] args) {
        int n = 50;
        int count = 0;
        while (n >= 5) {
            count += n / 5;
            n = n / 5;
        }
        System.out.println(count);
    }
    /*public int trailingZeroes(int n) {

        int zeroCount = 0;
        for (int i = 5; i <= n; i += 5) {
            int currentFactor = i;
            while (currentFactor % 5 == 0) {
                zeroCount++;
                currentFactor /= 5;
            }
        }
        return zeroCount;
    }*/
}
