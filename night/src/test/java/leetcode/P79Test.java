package leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class P79Test {

    @Test
    public void shouldOutputTrue() {
//        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
//        String word = "ABCCED";
        String word = "ABCB";
//        String word = "SEE";
        P79 p79 = new P79();
        boolean exist = p79.exist(board, word);
        Assert.assertTrue(exist);
    }
}