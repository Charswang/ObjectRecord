package leetcode;

/**
 * 2021-10-14
 * 每日一题
 */
public class OfferII069 {
    public int peakIndexInMountainArray(int[] arr) {
        int max = arr[0];
        int res = 0;
        for(int i = 1; i < arr.length;i++){
            if(arr[i]>max){
                max = arr[i];
                res = i;
            }
        }
        return res;
    }
}
