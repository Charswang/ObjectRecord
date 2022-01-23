package leetcode;

import java.util.ArrayList;

/**
 * 2021-9-4
 */
public class P57_UNFINISHED {
    public static void main(String[] args) {

    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> list = new ArrayList<>();
        int left = newInterval[0];
        int right = newInterval[1];
        boolean p = false;//表示newInterval是否已经插入
        for (int[] interval : intervals) {
            if (interval[1] < left) {
                list.add(interval);
            }else if (interval[0]>right){
                if (!p){
                    list.add(new int[]{left,right});
                    p=true;
                }
                list.add(interval);
            }else{
                // 因为newInterval可能不仅需要合并一次
                left = Math.min(interval[0],left);
                right = Math.max(interval[1],right);
            }
        }
        if (!p){
            list.add(new int[]{left,right});
        }
        return list.toArray(new int[list.size()][2]);
    }
}
