package leetcode;

import com.sun.xml.internal.ws.api.server.AbstractServerAsyncTransport;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class P1583Test {
    @Test
    public void shouldOutputUnhappyFriends() {
        P1583 p1583 = new P1583();
        int n = 4;
//        int[][] preferences = {{1, 2, 3},{3, 2, 0},{3, 1, 0},{1, 2, 0}};
//        int[][] pairs = {{0, 1},{2, 3}};
//        int[][] preferences = {{1},{0}};
//        int[][] pairs = {{0, 1}};
        int[][] preferences = {{1, 3, 2},{2, 3, 0},{1, 3, 0},{0, 2, 1}};
        int[][] pairs = {{1, 3},{0, 2}};
        int i = p1583.unhappyFriends(n,preferences,pairs);
        Assert.assertThat(0,is(i));
    }
}