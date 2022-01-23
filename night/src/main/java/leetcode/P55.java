package leetcode;

/**
 * 2021-9-3 8:00
 */
public class P55 {
    public static void main(String[] args) {
        int[] arr = {3,2,1,0,4};
        boolean b = canJump(arr);
        System.out.println(b);
    }
    public static boolean canJump(int[] nums) {
        int[] temp = new int[nums.length];
        temp[0] = 1; // 保证第一个数肯定能达到。
        for (int i = 0;i < nums.length-1;i++){
            // 如果第i个数达不到，就返回false
            if(temp[i]==0){
                return false;
            }
            // 将nums[i]中的数所代表的跳跃数，在temp中进行跳跃，跳跃范围内的设为1，代表可到达。
            for (int j = i;j <= i+nums[i];j++){
                if (j>=nums.length){
                    break;
                }
                temp[j] = 1;
            }
        }
        if (temp[nums.length-1]>0){
            return true;
        }
        return false;
    }
}
