package leetcode;

public class P79 {
    public boolean exist(char[][] board, String word) {
        int[][] flag = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean res = dfs(board, word, flag, "", i, j);
                    if (res == true) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int[][] flag, String temp, int i, int j) {
        if (temp.length() == word.length()) {
            if (word.equals(temp)) {
                return true;
            }
            return false;
        }
        temp = temp + board[i][j];
        if (word.equals(temp)) {
            return true;
        }
        flag[i][j] = 1;
        boolean res = false;
        // 往下走
        if (i + 1 < board.length && flag[i + 1][j] == 0) {
            boolean dfs = dfs(board, word, flag, temp, i + 1, j);
            if (dfs){
                return true;
            }
        }
        // 往上走
        if (i - 1 >= 0 && flag[i - 1][j] == 0) {
            boolean dfs = dfs(board, word, flag, temp, i - 1, j);
            if (dfs){
                return true;
            }
        }
        // 往右走
        if (j + 1 < board[0].length && flag[i][j + 1] == 0) {
            boolean dfs = dfs(board, word, flag, temp, i, j + 1);
            if (dfs){
                return true;
            }
        }
        // 往左走
        if (j - 1 >= 0 && flag[i][j - 1] == 0) {
            boolean dfs = dfs(board, word, flag, temp, i, j - 1);
            if (dfs){
                return true;
            }
        }
        flag[i][j]=0;
        return false;
    }
}
