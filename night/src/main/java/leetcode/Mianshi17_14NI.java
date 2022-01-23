package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 2021-9-3 7:30
 */
public class Mianshi17_14NI {
    public static void main(String[] args) {
        int[] arr = {1,3,5,7,2,4,6,8};
        int k = 4;
        int[] ints = smallestK(arr, k);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
    public static int[] smallestK(int[] arr, int k) {
        /*int[] res = new int[k];
        Arrays.sort(arr);
        for (int i = 0;i < k;i++){
            res[i] = arr[i];
        }
        return res;*/
        // 使用堆排序，可减少内存占用，但是速度会比使用api要慢一些
        int[] res = new int[k];
        // 这个是必要的，因为如果k=0的话，queue.peek()会报空指针异常
        if(k==0){
            return res;
        }
        // 使用堆
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;//倒序
            }
        });
        for (int i = 0;i < k;i++){
            queue.offer(arr[i]);
        }
        for (int i = k;i < arr.length;i++){
            if (queue.peek()>arr[i]){
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        for (int i = 0;i < k;i++){
            res[i] = queue.poll();
        }
        return res;
    }
}
