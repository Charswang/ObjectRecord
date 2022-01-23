package leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class P516Test {

    @Test
    public void shouldOutputNum() {
        String s = "cbbd";
        P516 p516 = new P516();
        int res = p516.longestPalindromeSubseq(s);
        Assert.assertThat(2,is(res));
    }
}