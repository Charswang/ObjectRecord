package leetcode;

import javafx.scene.layout.Priority;

import java.util.*;

/**
 * 2021-9-8
 */
public class P502_UNFINISH {
    public static void main(String[] args) {
        int k = 2;
        int w = 0;
        int[] prfits = {1,2,3};
        int[] captial = {0,9,10};
        int maximizedCapital = findMaximizedCapital(k, w, prfits, captial);
        System.out.println(maximizedCapital);
    }

    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int[][] temp = new int[profits.length][2];
        for (int i = 0;i < profits.length;i++){
            temp[i][0] = capital[i];
            temp[i][1] = profits[i];
        }
        Arrays.sort(temp,(a,b)->a[0]-b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>((x,y)->y-x);
        int curr = 0; // ?
        for (int i = 0;i < k;i++){
            while(curr<profits.length && temp[curr][0]<=w){ // ?
                pq.add(temp[curr][1]);
                curr++;
            }
            if (!pq.isEmpty()){
                w+=pq.poll();
            }else {
                break;
            }
        }
        return w;
    }
}
