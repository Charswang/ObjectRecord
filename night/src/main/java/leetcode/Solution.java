package leetcode;

import java.util.Random;

public class Solution {
    int[] temp, res;

    public Solution(int[] nums) {
        temp = new int[nums.length];
        res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            temp[i] = nums[i];
            res[i] = nums[i];
        }
    }

    public int[] reset() {
        for (int i = 0;i < temp.length;i++){
            temp[i] = res[i];
        }
        return temp;
    }

    public int[] shuffle() {
        Random random = new Random();
        for (int i = temp.length-1;i>=1;i--){
            // radom.nextInt(n) 是返回>=0且<n的一个数
            swap(i,random.nextInt(i+1));
        }
        return temp;
    }
    public void swap(int i,int j){
        int a = temp[i];
        temp[i]=temp[j];
        temp[j] = a;
    }
}
