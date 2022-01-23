package leetcode.competition.medium;

public class P5876 {
    public static void main(String[] args) {
        int[] nums = {9,9,3,8,7,9,6,10};
        System.out.println(sumOfBeauties(nums));
    }
    public static int sumOfBeauties(int[] nums) {
        int len = nums.length;
        // 创建每个元素包括自身及之前元素值的最大值；和 每个元素包括自身及之后元素值的最小值；-- 条件一；
        int[][] temp = new int[len][2];
        int min_behind = nums[len-1];
        int max_front = nums[0];
//        int[] res = new int[len];
        for (int i = len-1;i>=0;i--){
            if (nums[i]<min_behind){
                min_behind = nums[i];
            }
            temp[i][0] = min_behind;
        }
        for (int i = 0;i<len;i++){
            if (nums[i] > max_front){
                max_front = nums[i];
            }
            temp[i][1] = max_front;
        }
        int sum = 0;
        for (int i = 1;i < len-1;i++){
            if (nums[i]>temp[i-1][1] && nums[i]<temp[i+1][0]){
                sum+=2;
            }else if (nums[i]>nums[i-1] && nums[i] < nums[i+1]){
                sum+=1;
            }
        }
        return sum;
    }
}
