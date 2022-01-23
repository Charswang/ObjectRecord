package leetcode;

/**
 * 2021-10-10
 * 每日一题
 */
public class P441 {
    public static void main(String[] args) {
        System.out.println(arrangeCoins(2147483647));
    }
    public static int arrangeCoins(int n) {
        int res = 0;
        int i = 1;
        while(n>0){
            if (n-i>=0){
                n-=i;
                res++;
                i++;
                continue;
            }
            break;
        }
        return res;
    }
}
