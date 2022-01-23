package leetcode;

/**
 * 2021-11-4
 * 每日一题
 */
public class P367_UN {
    public boolean isPerfectSquare(int num) {
//        int a = (int)Math.sqrt(num);
//        return a*a==num;

        // 前n个奇数之和=n的平方；
        // 1+3+5+...+(2n-1) = n^2

        // 不能使用sqrt
        // 二分法
        int left = 1;
        int right = num;
        while(left<=right){
            int mid = left+(right-left)/2;
            if (mid*mid==num){
                return true;
            }
            if (mid*mid<num){
                left = mid+1;
            }else {
                right = mid-1;
            }
        }
        return false;
    }
}
