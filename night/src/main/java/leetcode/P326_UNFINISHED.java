package leetcode;

/**
 * 2021-9-23
 * 每日一题
 * 除法比乘法耗时要低；
 */
public class P326_UNFINISHED {
    public static void main(String[] args) {

    }
    public static boolean isPowerOfThree(int n) {
        /*int i = 1;
        while(i < n){
            i = i *3;
        }
        if (i==n){
            return true;
        }
        return false;*/
        while(n!=0 && n%3==0){
            n = n / 3;
        }
        return n==1;
    }
}
