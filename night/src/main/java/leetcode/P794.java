package leetcode;

public class P794 {
    public boolean validTicTacToe(String[] board) {
        int x_num = 0;
        int o_num = 0;
        for (int i = 0;i < 3;i++){
            String trim = board[i].trim();
            for (int j = 0;j < trim.length();j++){
                if (trim.charAt(j)=='X'){
                    x_num++;
                }else{
                    o_num++;
                }
            }
        }
        if (x_num!=o_num && x_num!=(o_num+1)){
            return false;
        }
        // 是否存在行/列/对角线相同的情况，有的话只能为1个，没有的话那么所有位置都不为空
        // x_num=o_num / x_num=o_num+1
        int same = 0;
        int sum_num = 0;
        for (int i = 0; i < board.length; i++) {
            String s = board[i];
            sum_num += s.trim().length();
            if (s.equals("XXX") || s.equals("OOO")) {
                if (same == 0) {
                    same += 1;
                } else {
                    return false;
                }
            }
            if (board[0].charAt(i)==board[1].charAt(i) && board[0].charAt(i)==board[2].charAt(i)){
                if (same==0){
                    same+=1;
                }else {
                    return false;
                }
            }
        }
        if (board[0].charAt(0) == board[1].charAt(1) && board[0].charAt(0) == board[2].charAt(2)){
            if (same==0){
                same+=1;
            }else {
                return false;
            }
        }
        return true;
    }
}
