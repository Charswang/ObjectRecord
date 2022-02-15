package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 2022-2-15
 */
public class P217 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)){
                return true;
            }
        }
        return false;
    }
}
