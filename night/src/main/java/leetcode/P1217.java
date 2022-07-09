package leetcode;

/**
 * 2022-7-8
 * 每日一题  --  玩筹码
 */
public class P1217 {
    public int minCostToMoveChips(int[] position) {
        int a = 0;
        int b = 0;
        for (int i : position) {
            if (i%2==0){
                a++;
            }else {
                b++;
            }
        }
        return Math.min(a,b);
    }
}
