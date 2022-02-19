package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2022-2-19
 * 每日一题
 *
 * 例2431 - 先进行操作变为xxx4，再弄xx34，x234, 1234
 * 先找到4的位置，把当前4的位置的前几个数进行反转，把4放到第一位，然后反转4位，以此类推。。。
 */
public class P969 {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8};
        reverse(a, 4);
        for (int i : a) {
            System.out.print(i + " ");
        }
    }

    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> res = new ArrayList<>();
        int len = arr.length;
        for (int i = len - 1; i >= 0; i--) {
            if (arr[i]!=(i+1)){
                // 找到i的位置index，转换前index个
                int index = -1;
                for (int j = 0;j < i;j++){
                    if (arr[j]==(i+1)){
                        index = j;
                        break;
                    }
                }
                reverse(arr,index+1);
                // 转换前i个
                reverse(arr,i+1);
                res.add(index+1);
                res.add(i+1);
            }
        }
        return res;
    }

    public static void reverse(int[] nums, int len) {
        for (int i = 0; i < len / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[len - i - 1];
            nums[len - i - 1] = temp;
        }
    }
}
