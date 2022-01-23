package leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class P5Test {

    @Test
    public void longestPalindrome() {
        String s = "bb";
        P5 p5 = new P5();
        String s1 = p5.longestPalindrome(s);
        Assert.assertThat("bb",is(s1));
    }
}