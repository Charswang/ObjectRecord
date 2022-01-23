package leetcode;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合
 */
public class P77Test {
    @Test
    public void shouldOutputNumsOf1ToN() {
        int n = 5;
        int k = 3;
        P77 p77 = new P77();
        List<List<Integer>> result = p77.combine(n,k);
        for (List<Integer> integers : result) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}