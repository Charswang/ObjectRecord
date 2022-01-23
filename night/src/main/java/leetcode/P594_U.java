package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 2021-11-20
 * 代码很臭，看一下别人的代码，用滑动窗口。。
 */
public class P594_U {
    public int findLHS(int[] nums) {
        /**
         * 双指针，滑动窗口
         */
        Arrays.sort(nums);
        int begin = 0;
        int res = 0;
        for(int end = 0;end < nums.length;end++){
            if(nums[end]-nums[begin]==1){
                res = Math.max(res,end-begin+1);
            }else{
                while(nums[end]-nums[begin]>1){
                    begin++;
                }
            }
        }
        return res;
        /**
         * 自己的代码，很单纯的照着题意做，代码很臭
         */
        /*Arrays.sort(nums);
        int a = nums[0];
        int b = a+1;
        int a_len = 1;
        int b_len = 0;
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == a) {
                a_len++;
            } else if (nums[i] == b) {
                if(i==nums.length-1){
                    int res = a_len+b_len+1;
                    max = res > max ? res : max;
                    return max;
                }
                b_len++;
            } else {
                if (b_len != 0) {
                    int res = a_len + b_len;
                    max = res > max ? res : max;
                    if(nums[i]==(b+1)){
                        a = b;
                        a_len=b_len;
                        b = nums[i];
                        b_len=1;
                    }else{
                        a = nums[i];
                        a_len=1;
                        b = a+1;
                        b_len=0;
                    }
                }else{
                    a = nums[i];
                    a_len=1;
                    b = a+1;
                    b_len=0;
                }

            }
        }
        return max;*/

    }
}
