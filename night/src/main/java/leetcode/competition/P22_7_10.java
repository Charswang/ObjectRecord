package leetcode.competition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 2022-7-10
 * 周日竞赛
 */
public class P22_7_10 {
    public static void main(String[] args) {

    }

    // P6112
    public int fillCups(int[] amount) {
        Arrays.sort(amount);
//        int max = amount[2];
        int res = 0;
        while (amount[0] > 0 && amount[1] > 0 && amount[2] > 0) {
            if (amount[0] > 0) {
                amount[0]--;
                amount[2]--;
                res++;
            }
            if (amount[1] > 0) {
                amount[1]--;
                amount[2]--;
                res++;
            }
            Arrays.sort(amount);
        }
        int a = Math.max((Math.max(amount[0], amount[1])), amount[2]);
        return res + a;
    }

    // P6114
    // 先判断L和R出现的顺序是不是相同
    // 然后判断L和R能不能按照顺序达到目标所在的那个位置
    public boolean canChange(String start, String target) {
        int n = start.length();
        char[] starts = start.toCharArray();
        char[] targets = target.toCharArray();
        for (int i = 0, j = 0; i < n; i++, j++) {
            while (i < n && starts[i] == '_') {
                i++;
            }
            while (j < n && targets[j] == '_') {
                j++;
            }
            if (i<n&&j<n&&starts[i] != targets[j]) {
                return false;
            }
        }
        int l1 = 0, r1 = 0, l2 = 0, r2 = 0;  // 下面对i进行遍历的时候，查看当前i之前有多少个L或者R
        // 如果starts在当前位置上的L的个数是大于targets的话 || 如果starts在当前位置上的R的个数是小于targets的话 ，false，
        for (int i = 0; i < n; i++) {
            if (starts[i]=='L'){
                l1++;
            }else if (starts[i]=='R'){
                r1++;
            }
            if (targets[i]=='L'){
                l2++;
            }else if (targets[i]=='R'){
                r2++;
            }
            if (l1>l2 || r1<r2){
                return false;
            }
        }
        return l1==l2 && r1==r2;   //  '_'和'L'出现的情况
    }
}

// P6113
class SmallestInfiniteSet {
    ArrayList<Integer> temp;

    public SmallestInfiniteSet() {
        temp = new ArrayList<>();
        for (int i = 1; i <= 1000; i++) {
            temp.add(i);
        }
    }

    public int popSmallest() {
        int res = temp.get(0);
        temp.remove(0);
        return res;
    }

    public void addBack(int num) {
        if (!temp.contains(num)) {
            temp.add(num);
            Collections.sort(temp);
        }
    }
}