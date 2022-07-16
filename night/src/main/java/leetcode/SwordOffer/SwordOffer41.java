package leetcode.SwordOffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 2022-7-16
 * 每日一题
 */
public class SwordOffer41 {

}

class MovingAverage {

    List<Integer> res;
    int len;
    double sum;

    /**
     * Initialize your data structure here.
     */
    public MovingAverage(int size) {
        res = new ArrayList<>();
        len = size;
        sum = 0;
    }

    public double next(int val) {
        if (res.size() < len) {
            res.add(val);
            sum += val;
        } else {
            sum -= res.get(0);
            res.remove(0);
            res.add(val);
            sum += val;
        }
        return sum / res.size();
    }

    /*public int sum() {
        int sum = 0;
        for (Integer re : res) {
            sum += re;
        }
        return sum;
    }*/
}
