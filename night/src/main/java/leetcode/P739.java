package leetcode;

import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

/**
 * 2021-11-21
 *
 */
public class P739 {
    public int[] dailyTemperatures(int[] temperatures) {
        // 1、暴力 -- n^2
        /*int[] res = new int[temperatures.length];
        for (int i = 0;i < temperatures.length-1;i++){
            for (int j = i+1;j<temperatures.length;j++){
                if (temperatures[j]>temperatures[i]){
                    res[i] = j-i;
                }
            }
        }
        return res;*/

        // 2、单调栈
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[temperatures.length];
        for (int i = 0;i < temperatures.length;i++){
            while (!stack.isEmpty() && temperatures[i]>temperatures[stack.peek()]){
                Integer pop = stack.pop();
                res[pop] = i-pop;
            }
            stack.push(i);
        }
        return res;
    }
}
