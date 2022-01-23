package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 2021-9-5
 */
public class P120 {
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        ArrayList<Integer> integers1 = new ArrayList<>();
        integers1.add(2);
        ArrayList<Integer> integers2 = new ArrayList<>();
        integers2.add(3);
        integers2.add(4);
        ArrayList<Integer> integers3 = new ArrayList<>();
        integers3.add(6);
        integers3.add(5);
        integers3.add(7);
        ArrayList<Integer> integers4 = new ArrayList<>();
        integers4.add(4);
        integers4.add(1);
        integers4.add(8);
        integers4.add(3);
        triangle.add(integers1);
        triangle.add(integers2);
        triangle.add(integers3);
        triangle.add(integers4);
        int i = minimumTotal(triangle);
        System.out.println(i);
    }
    public static int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        int[][] res = new int[len][len];
        // 将无关位置设为最大值
        for (int i = 0;i < len;i++){
            for (int j = i+1;j<len;j++){
                res[i][j]=Integer.MAX_VALUE;
            }
        }
        // 第一列直接按正常相加
        for (int i = 0;i < triangle.size();i++){
            if (i==0){
                res[i][0] = triangle.get(i).get(0);
            }else{
                res[i][0] = triangle.get(i).get(0) + res[i-1][0];
            }
        }
        // 其他位置按照dp来走
        for (int i = 1;i < triangle.size();i++){
            for (int j = 1;j < i+1;j++){
                res[i][j] = Math.min(res[i-1][j-1],res[i-1][j]) + triangle.get(i).get(j);
            }
        }
        /*for (int i = 0;i<len;i++){
            for (int j = 0;j<len;j++){
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }*/
        int min = res[len-1][0];
        for (int i = 1;i<len;i++){
            if (min > res[len-1][i]){
                min = res[len-1][i];
            }
        }
        return min;
    }
}
