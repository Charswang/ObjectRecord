package leetcode;

/**
 * 2021-9-4
 * 斐波那契数列
 */
public class Offer10_1 {
    public static void main(String[] args) {
        System.out.println(fib(5));
    }
    public static int fib(int n) {
        int a = 0;
        int b = 1;
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        for(int i = 0;i < n-1;i++){
            int temp = a;
            a = b;
            b = (temp + b) % 1000000007;
        }
        return b;
    }
}
