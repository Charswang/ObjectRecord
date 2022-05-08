package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 2022-5-4
 * 每日一题
 */
public class P1823_约瑟夫环问题 {
    public static void main(String[] args) {
        int theWinner = findTheWinner(6, 500);
        System.out.println(theWinner);
    }

    public static int findTheWinner(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        int i = 0;
        while (list.size() > 1) {
            int index = i + k - 1;
            while (index >= list.size()) {
                index = index - list.size();
            }
            if (index==(list.size()-1)){
                i = 0;
            }else {
                i = index;
            }
            list.remove(index);
        }
        return list.get(0);
    }
}
