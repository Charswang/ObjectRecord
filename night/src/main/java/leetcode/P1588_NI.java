package leetcode;

/**
 * 奇数子数组求和
 *
 * @author charswang
 * @since 2021-8-29
 */
public class P1588_NI {
    public int sumOddLengthSubarrays(int[] arr) {
        // 暴力，需要提升
        int sum = 0;
        for(int i = 0;i<arr.length;i+=2){
            for(int j = 0;j + i < arr.length;j++){
                for(int t = j;t<=j+i;t++){
                    sum += arr[t];
                }
            }
        }
        return sum;
    }
}
