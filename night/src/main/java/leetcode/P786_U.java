package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 2021-11-29
 * 每日一题
 *
 * 优先队列--要进行尝试
 */
public class P786_U {
    public static void main(String[] args) {
        int[] arr = {1,2,3,5};
        int k = 3;
        int[] ints = kthSmallestPrimeFraction(arr, k);
        System.out.println(ints[0] +" " + ints[1]);
    }
    public static int[] kthSmallestPrimeFraction(int[] arr, int k) {
        Map<Double,String> map = new TreeMap<>();
        for (int i = 0;i < arr.length;i++){
            for (int j = i+1;j < arr.length;j++){
                String s = i+" " + j;
                map.put(arr[i]*1.0/arr[j],s);
            }
        }
        int[] ints = new int[2];
        for (Double aDouble : map.keySet()) {
            System.out.println(aDouble);
        }
        System.out.println("==============");
        int count = 1;
        for (Map.Entry<Double, String> doubleStringEntry : map.entrySet()) {
            if (count==k){
                ints[0]=Integer.parseInt(doubleStringEntry.getValue().split(" ")[0]);
                ints[1]=Integer.parseInt(doubleStringEntry.getValue().split(" ")[1]);
            }
            count++;
        }
        return ints;
    }
}
