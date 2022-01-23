package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 2021-10-14
 */
public class P73 {
    public void setZeroes(int[][] matrix) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i = 0;i < matrix.length;i++){
            for (int j = 0;j < matrix[0].length;j++){
                if (matrix[i][j]==0){
                    set1.add(i);
                    set2.add(j);
                }
            }
        }
        for (Integer integer : set1) {
            for (int i = 0;i < matrix[0].length;i++){
                matrix[integer][i] = 0;
            }
        }
        for (Integer integer : set2) {
            for (int i = 0;i < matrix.length;i++){
                matrix[i][integer] = 0;
            }
        }
    }
}
