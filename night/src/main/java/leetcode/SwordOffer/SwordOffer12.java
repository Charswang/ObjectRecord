package leetcode.SwordOffer;

/**
 * 2022-06-20
 * 每日一题
 */
public class SwordOffer12 {
    public static void main(String[] args) {
        char[][] board = {{'a', 'b', 'c', 'e'}, {'s', 'f', 'c', 's'}, {'a', 'd', 'e', 'e'}};
        String word = "abcced";
        System.out.println(exist(board, word));
    }

    public static boolean exist(char[][] board, String word) {
        int[][] visited = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean dfs = dfs(board, word, visited, 0, i, j);
                if (dfs) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean dfs(char[][] board, String word, int[][] visited, int num, int i, int j) {
        if (board[i][j] != word.charAt(num)) {
            return false;
        }
        if (num == word.length() - 1) {
            return true;
        }
        boolean res = false;
        visited[i][j]=1;
        // 四方格中的，分别的四个方向的移动：【向上、向下、向左、向右】
        int[][] temp = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int m = 0; m < 4; m++) {
            int a = temp[m][0] + i;
            int b = temp[m][1] + j;
            if (a >= 0 && a < board.length && b >= 0 && b < board[0].length){
                if (visited[a][b]==0){
                    boolean dfs = dfs(board, word, visited, num+1, a, b);
                    if (dfs){
                        res = true;
                        break;
                    }
                }
            }
        }
        visited[i][j]=0;
        return res;
    }
}
