package leetcode;

import org.junit.Test;

import java.util.List;

public class P78Test {
    @Test
    public void shouldOutputAll() {
        P78 p78 = new P78();
        int[] nums = {1,2,3};
        List<List<Integer>> result = p78.subsets(nums);
        for (List<Integer> integers : result) {
            for (Integer integer : integers) {
                System.out.print(integer);
            }
            System.out.println();
        }
    }
}
