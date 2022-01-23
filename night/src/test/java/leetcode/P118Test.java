package leetcode;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class P118Test {
    @Test
    public void shouldOutputGenerate() {
        int numRows = 1;
        P118 p118 = new P118();
        List<List<Integer>> generate = p118.generate(numRows);
        for (List<Integer> integers : generate) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}