package leetcode;

public class P1137 {
    public int tribonacci(int n){
        int num0 = 0;
        int num1 = 1;
        int num2 = 1;
        if (n==0){
            return 0;
        }
        if (n==1){
            return 1;
        }
        if (n==2){
            return 1;
        }
        for (int i = 3;i<=n;i++){
            int temp = num0 + num1 + num2;
            num0 = num1;
            num1 = num2;
            num2 = temp;
        }
        return num2;
    }
    public int tribonacci1(int n) {
        int[] results = new int[n+1];
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }
        results[0] = 0;
        results[1] = 1;
        results[2] = 1;
        for (int i = 3;i < n+1;i++){
            results[i] = results[i-1] +results[i-2] +results[i-3];
        }
        return results[n];
    }
}
