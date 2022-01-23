package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 2021-12-14
 * 每日一题
 */
public class P630_UN {
    public int scheduleCourse(int[][] courses) {
        // 按照完成期限从小到大进行排序
        Arrays.sort(courses, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        // 优先队列--大根堆，将之前最大的执行时间去除
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        int temp = 0;
        for (int[] cours : courses) {
            if (temp+cours[0]<=cours[1]){
                temp += cours[0];
                pq.add(cours[0]);
            }else{
                if (!pq.isEmpty()){
                    Integer peek = pq.peek();
                    if(peek>cours[0]){
                        Integer poll = pq.poll();
                        pq.add(cours[0]);
                        temp = temp - poll + cours[0];
                    }
                }
            }
        }
        return pq.size();
    }
}
