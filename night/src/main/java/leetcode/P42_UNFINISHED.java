package leetcode;

/**
 * 2021-11-3
 */
public class P42_UNFINISHED {
    public int trap(int[] height) {
        int len = height.length;
        int left = 0;
        int right = len -1;
        int leftmax = 0;
        int rightmax = 0;
        int res = 0;
        while(left<right){
            leftmax = Math.max(leftmax,height[left]);
            rightmax = Math.max(rightmax,height[right]);
            if (height[left]<height[right]){
                res += leftmax - height[left];
                left++;
            }else{
                res += rightmax - height[right];
                right--;
            }
        }
        return res;
    }
}
