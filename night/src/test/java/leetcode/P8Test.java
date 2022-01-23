package leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class P8Test {
    @Test
    public void shouldOutputRes() {
        P8 p8 = new P8();
        String s = "-91283472332";
        int res = p8.myAtio(s);
        Assert.assertThat(-2147483648,is(res));
    }
}