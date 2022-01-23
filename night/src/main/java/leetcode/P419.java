package leetcode;

/**
 * 2021-12-18
 * 每日一题
 */
public class P419 {
    public int countBattleships(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        int[][] visited = new int[row][col];
        int res = 0;
        for (int i = 0;i < row;i++){
            for (int j = 0;j < col;j++){
                if (visited[i][j]==0 && board[i][j]=='X'){
                    if (j+1<col){
                        int a = j+1;
                        while(a<col && board[i][a]=='X'){
                            visited[i][a]=1;
                            a++;
                        }
                    }
                    if (i+1<row){
                        int b = i+1;
                        while(b<row && board[b][j]=='X'){
                            visited[b][j]=1;
                            b++;
                        }
                    }
                    res++;
                }
            }
        }
        return res;
    }
}
