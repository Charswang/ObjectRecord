package leetcode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 2022-2-16
 */
public class P1 {
    public int[] twoSum2(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0;i < nums.length;i++){
            int a = target - nums[i];
            if (map.containsKey(a)){
                res[0] = i;
                res[1] = map.get(a);
                return res;
            }else {
                map.put(nums[i],i);
            }
        }
        return res;
    }
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        for (int i = 0;i < nums.length-1;i++){
            int a = target - nums[i];
            int i1 = list.lastIndexOf(a);
            if (i1!=-1 && i1!=i){
                res[0] = i;
                res[1] = i1;
                return res;
            }
        }
        return res;
    }
}
