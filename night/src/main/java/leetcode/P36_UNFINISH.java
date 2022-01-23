package leetcode;

/**
 * 验证现有数独是否有效
 *
 * @author charswang
 * @since 2021-8-27
 */
public class P36_UNFINISH {
    public boolean isValidSudoku(char[][] board) {
        // 第i行的某个数是否出现
        int[][] rows = new int[9][9];
        // 第j列的某个数是否出现
        int[][] columns = new int[9][9];
        // 第block个块中的某个数是否出现
        int[][] blocks = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    // 以为数组是从0开始的，所以把数字-1
                    int num = board[i][j] - '1';
                    // 第block块，先按行加，然后再按列加；
                    // 如果i/3==1的话，说明前三个块已经跑过了，所以要*3，列的话就直接按/3的结果即可
                    int block = i / 3 * 3 + j / 3;
                    if (rows[i][num]==1 || columns[j][num]==1 || blocks[block][num]==1){
                        return false;
                    }
                    rows[i][num]=1;
                    columns[j][num]=1;
                    blocks[block][num]=1;
                }
            }
        }
        return true;
    }
}
