package leetcode;

import java.util.ArrayList;
import java.util.List;

public class P89 {
    public static void main(String[] args) {
        /*List<Integer> integers = grayCode(3);
        for (Integer integer : integers) {
            System.out.println(integer);
        }*/

        List<Integer> result = new ArrayList<Integer>();
        result.add(0);
        int head = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = result.size() - 1; j >= 0; j--) {
                result.add(head+result.get(j));
            }
            head = head << 1;
        }
        for (Integer integer : result) {
            System.out.println(integer);
        }
    }

    // 000 001 011 010 110 111 101 100
    public static List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<Integer>();
        boolean dfs = dfs(res, 0, n);
        if (dfs) {
            return res;
        }
        return null;
    }

    public static boolean dfs(List<Integer> res, int num, int n) {
        if (res.contains(num)) {
            return false;
        }
        res.add(num);
        if (res.size() == (1 << n)) {
            return true;
        }
        for (int i = 0; i < n; i++) {
            boolean dfs = dfs(res, num ^ (1 << i), n);
            if (dfs) {
                return true;
            }
        }
        res.remove(res.size() - 1);
        return false;
    }
}
