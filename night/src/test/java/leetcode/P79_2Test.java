package leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class P79_2Test {

    @Test
    public void sholdOutputRight() {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
//        char[][] board = {{'a','a'}};
//        String word = "ABCCED";
//        String word = "ABCB";
        String word = "SEE";
//        String word = "aaa";
        P79_2 p79_2 = new P79_2();
        boolean exist = p79_2.exist(board, word);
        Assert.assertTrue(exist);
    }
}