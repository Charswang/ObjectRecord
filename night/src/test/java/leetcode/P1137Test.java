package leetcode;

import org.junit.Assert;
import org.junit.Test;

public class P1137Test {
    @Test
    public void shouldOutPutResOfN() {
        int n = 25;
        P1137 p1137 = new P1137();
        int result = p1137.tribonacci(n);
        System.out.println(result);
        Assert.assertTrue(1389537==result);
    }
}
