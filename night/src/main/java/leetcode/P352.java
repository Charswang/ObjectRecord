package leetcode;

import java.util.*;

/**
 * 2021-10-9
 * 每日一题
 */
public class P352 {
    public static void main(String[] args) {

    }
}

class SummaryRanges {
    public ArrayList<Integer> arr;
    public Set<Integer> set;

    public SummaryRanges() {
//        arr = new ArrayList<Integer>();
        set = new TreeSet<Integer>();
    }

    public void addNum(int val) {
        set.add(val);
//        arr.add(val);
        arr = new ArrayList<>(set);
//        Collections.sort(arr);
    }

    public int[][] getIntervals() {
        ArrayList<int[]> res = new ArrayList<>();
        int start = 0;
        int end = 0;
        while (start < arr.size() && end < arr.size()) {
            int num1 = arr.get(start);
            int num2 = arr.get(end);
            if ((num2-num1)==(end-start)){
                end++;
            }else{
                int[] temp = new int[2];
                temp[0] = num1;
                temp[1] = arr.get(end-1);
                res.add(temp);
                start = end;
            }
        }
        int[] temp = new int[2];
        temp[0] = arr.get(start);;
        temp[1] = arr.get(end-1);
        res.add(temp);

        int[][] r = new int[res.size()][2];
        for (int i = 0;i<res.size();i++){
            for (int j = 0;j < 2;j++){
                r[i][j] = res.get(i)[j];
            }
        }
        return r;
    }
}
