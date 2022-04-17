package leetcode.competition.medium;

/**
 * 2022-4-17
 * <p>
 * 6061. 买钢笔和铅笔的方案数
 * 给你一个整数 total ，表示你拥有的总钱数。同时给你两个整数 cost1 和 cost2 ，
 * 分别表示一支钢笔和一支铅笔的价格。你可以花费你部分或者全部的钱，去买任意数目的两种笔。
 * <p>
 * 请你返回购买钢笔和铅笔的 不同方案数目 。
 */
public class P6061 {
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        long res = 0;
        int penNum = 0;
        while (penNum * cost1 <= total) {
            int leaveTotal = total - penNum * cost1;
            res = res + leaveTotal / cost2 + 1; // 注意：0 0也算购买方案
            penNum++;
        }
        return res;
    }
}
