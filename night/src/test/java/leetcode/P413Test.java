package leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class P413Test {
    @Test
    public void test() {
        int[] nums = {1,2,3,4};
        P413 p413 = new P413();
        int i = p413.numberOfArithmeticSlices(nums);
        Assert.assertThat(3,is(i));
    }
}