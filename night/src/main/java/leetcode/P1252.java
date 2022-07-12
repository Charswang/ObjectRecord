package leetcode;

/**
 * 2022-7-12
 * 每日一题
 */
public class P1252 {
    public int oddCells(int m, int n, int[][] indices) {
        // 行为偶数、列为基数
        // 行为基数，列为偶数
        // 或者找出是偶数的--行为偶数、列为偶数 || 行为基数，列为奇数
        int row_ji = 0;
        int row_ou = 0;
        int col_ji = 0;
        int col_ou = 0;
        int[] rows = new int[m];
        int[] cols = new int[n];
        for (int[] index : indices) {
            int row = index[0];
            int col = index[1];
            rows[row]++;
            cols[col]++;
        }
        for (int row : rows) {
            if (row % 2 == 0) {
                row_ou++;
            } else {
                row_ji++;
            }
        }
        for (int col : cols) {
            if (col % 2 == 0) {
                col_ou++;
            } else {
                col_ji++;
            }
        }
        return (row_ji * col_ou) + (row_ou * col_ji);
    }
}
