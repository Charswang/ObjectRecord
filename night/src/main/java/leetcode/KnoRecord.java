package leetcode;

public class KnoRecord {
    public static void main(String[] args) {
        System.out.println(quickPow(2, 5));
    }

    /**
     * 快速幂；位运算方式
     * 参考：https://baike.baidu.com/item/%E5%BF%AB%E9%80%9F%E5%B9%82/5500243?fr=aladdin
     * @param a 底数
     * @param b 幂次
     * @return pow
     */
    public static int quickPow(int a, int b) {
        int res = 1;
        while (b != 0) {
            if ((b & 1) == 1) {
                res = res * a;
            }
            a = a * a;
            b = b >> 1;
        }
        return res;
    }
}
