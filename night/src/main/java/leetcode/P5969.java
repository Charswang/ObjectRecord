package leetcode;

import java.util.Arrays;

/**
 * 2022-1-2
 * 注意数值的溢出。。。long
 */
public class P5969 {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long sum = mass;
        for (int asteroid : asteroids) {
            if (sum>=asteroid){
                sum+=asteroid;
            }else{
                return false;
            }
        }
        return true;
    }
}
