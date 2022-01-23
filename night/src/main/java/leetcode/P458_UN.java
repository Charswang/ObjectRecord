package leetcode;

/**
 * 2021-11-25
 * 每日一题
 *
 * 老鼠喝毒药  ==  小猪喝毒药
 */
public class P458_UN {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int pigs = 0;
        int round = minutesToTest/minutesToDie + 1;
        while(Math.pow(round,pigs) < buckets){
            pigs++;
        }
        return pigs;
    }
}
