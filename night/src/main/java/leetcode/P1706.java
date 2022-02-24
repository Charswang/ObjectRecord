package leetcode;

/**
 * 2022-2-24
 * 每日一题
 */
public class P1706 {
    public static void main(String[] args) {
        int[][] grid = {{1,1,1,1,1,1},{-1,-1,-1,-1,-1,-1},{1,1,1,1,1,1},{-1,-1,-1,-1,-1,-1}};
        int[] ball = findBall(grid);
        for (int i : ball) {
            System.out.println(i);
        }
    }
    public static int[] findBall(int[][] grid) {
        int[] res = new int[grid[0].length];
        for (int i = 0; i < res.length; i++) {
            int a = i;
            for (int j = 0; j < grid.length; j++) {
                if (grid[j][a] == 1) {
                    if (a + 1 < res.length && grid[j][a + 1] == 1) {
                        a = a + 1;
                    } else {
                        res[i] = -1;
                        break;
                    }
                } else {
                    if (a - 1 >= 0 && grid[j][a - 1] == -1) {
                        a = a - 1;
                    } else {
                        res[i] = -1;
                        break;
                    }
                }
            }
            if(res[i]!=-1){
                res[i] = a;
            }
            // res[i] = res[i]==0?a:-1;
        }
        return res;
    }
}
