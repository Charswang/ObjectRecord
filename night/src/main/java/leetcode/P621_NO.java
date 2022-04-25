package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2022-4-24
 * 任务调度器,求最短调度时间
 */
public class P621_NO {
    public int leastInterval(char[] tasks, int n) {
        // 首先需要有一个记录某个任务的剩余数量，以及一个记录某个任务下一次执行的时间是什么时候
        Map<Character, Integer> map = new HashMap<>();
        for (char task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }
        List<Integer> nextVaild = new ArrayList<>();
        List<Integer> restNum = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            nextVaild.add(1); // 初始化的时候，令所有任务的下一次执行时间都是1
            restNum.add(entry.getValue()); // 初始化每类任务的数量
        }

        // 然后定义全局时间，根据全局时间以及所有任务的下次调用时间的到结果
        int time = 0;
        for (int i = 0; i < tasks.length; i++) {
            time++; // 记得每次访问都得先让time+1
            int minVaild = Integer.MAX_VALUE;
            for (Integer integer : nextVaild) {
                if (restNum.get(nextVaild.indexOf(integer)) > 0) {
                    minVaild = Math.min(integer, minVaild);
                }
            }
            time = Math.max(time, minVaild); // 让time前进到可以调用任务的时刻，就是跳过了等待的时间
            // 选择任务数量最多的一类任务
            int best = -1;
            for (int j = 0; j < map.size(); j++) {
                if (restNum.get(j) > 0 && nextVaild.get(j) <= time) {
                    if (best != -1) {
                        if (restNum.get(best) < restNum.get(j)) {
                            best = j;
                        }
                    } else {
                        best = j;
                    }
                }
            }
            nextVaild.set(best,time+n+1);
            restNum.set(best,restNum.get(best)-1);
        }
        return time;
    }
}
