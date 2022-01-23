package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P1034_Error {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        List<int[]> res = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        int[][] visited = new int[grid.length][grid[0].length];
        int a = grid[row][col];
        q.add(row+""+col);
        visited[row][col]=1;
        while (!q.isEmpty()){
            String poll = q.poll();
            int r = Integer.parseInt(String.valueOf(poll.charAt(0)));
            int c = Integer.parseInt(String.valueOf(poll.charAt(1)));
            visited[r][c]=1;
            boolean border = isBorder(grid, r, c,a);
            if (border){
                res.add(new int[]{r,c});
            }
            if (r-1>=0 && grid[r-1][c]==a){
                if (visited[r-1][c]==0){
                    q.add((r-1) + "" + c);
                }
            }
            if (r+1<grid.length && grid[r+1][c]==a){
                if (visited[r+1][c]==0) {
                    q.add((r + 1) + "" + c);
                }
            }
            if (c-1>=0 && grid[r][c-1]==a){
                if (visited[r][c-1]==0) {
                    q.add(r + "" + (c - 1));
                }
            }
            if (c+1<grid[0].length && grid[r][c+1]==a){
                if (visited[r][c+1]==0) {
                    q.add(r + "" + (c + 1));
                }
            }
        }
        for (int[] re : res) {
            grid[re[0]][re[1]]=color;
        }
        return grid;
    }
    public boolean isBorder(int[][] grid,int row,int col,int a){
        if (row==0 || col==0 || row==grid.length-1 || col==grid[0].length-1){
            return true;
        }
        if (grid[row-1][col]==a || grid[row+1][col]==a || grid[row][col-1]==a || grid[row][col+1]==a){
            return false;
        }
        return true;
    }
}
