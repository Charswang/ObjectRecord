package leetcode;

/**
 * 2021-9-21
 * 类型：刷题
 * 级别：困难  --   需要进阶时间复杂度O(log(num1_len + nums2_len))
 */
public class P4 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3,4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length+ nums2.length;
        int middle = len / 2;
        int[] temp = new int[len];
        int p = 0;
        int q = 0;
        int i = 0;
        boolean flag = false;
        while(p<nums1.length&&q<nums2.length){
            if (nums1[p]>nums2[q]){
                temp[i] = nums2[q];
                q++;
            }else{
                temp[i] = nums1[p];
                p++;
            }
            if (i==middle){
                flag=true;
                break;
            }
            i++;
        }
        // 注意这里的判断条件；flag是用来看是不是已经找到middle的位置了；
        if (i <= middle && flag==false) {
            while (p < nums1.length) {
                temp[i] = nums1[p];
                if (i == middle) {
                    break;
                }
                i++;
                p++;
            }
        }
        if (i<=middle && flag==false){
            while (q < nums2.length) {
                temp[i] = nums2[q];
                if (i == middle) {
                    break;
                }
                i++;
                q++;
            }
        }
        // double l = (double)Math.round((temp[middle - 1] + temp[middle]) / 2.0 * 100000) / 100000;
        // double r = (double)Math.round(temp[middle]*10000)/100000;
        return len%2==0?(temp[middle - 1] + temp[middle]) / 2.0:temp[middle]*1.0;
    }
}
