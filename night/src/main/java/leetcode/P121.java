package leetcode;

/**
 * P2022-2-20
 * 买卖股票的最佳时机
 */
public class P121 {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int max = 0;
        for(int i = 1;i < prices.length;i++){
            max = Math.max(max,prices[i] - min);
            min = Math.min(min,prices[i]);
        }
        return max;
    }
}
