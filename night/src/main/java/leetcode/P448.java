package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 2021-11-21
 */
public class P448 {
    public P448() {
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int[] temp = new int[nums.length+1];
        for (int num : nums) {
            temp[num]=1;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 1;i <= nums.length;i++){
            if (temp[i]==0){
                res.add(i);
            }
        }
        return res;
    }
}
