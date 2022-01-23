package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class P519_UN {
    // int[][] matrix;
    // Set<String> list = new HashSet<>();
    List<String> list = new ArrayList<>();
    int len1;
    int len2;
    public P519_UN(int m, int n) {
        // matrix = new int[m][n];
        len1=m;
        len2=n;
    }

    public int[] flip() {
        int r = new Random().nextInt(len1);
        int c = new Random().nextInt(len2);
        String temp = ""+r+c;
        while (list.contains(temp)){
            r = new Random().nextInt(len1);
            c = new Random().nextInt(len2);
            temp = ""+r+c;
        }
        list.add(temp);
        int[] res = {r,c};
        return res;
    }

    public void reset() {
        // for (int i = 0;i<matrix.length;i++){
        //     for (int j = 0;j < matrix[0].length;j++){
        //         matrix[i][j]=0;
        //     }
        // }
        list.clear();
    }
}
