package leetcode;

public class P5926 {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int t = tickets[k];
        int sum = 0;
        // 前t-1轮
        for (int i = 0;i < t-1;i++){
            for (int j = 0;j < tickets.length;j++){
                if (tickets[j]>0){
                    tickets[j]--;
                    sum++;
                }
            }
        }
        for (int i = 0;i <= k;i++){
            if (tickets[i]>0){
                sum++;
            }
        }
        return sum;
    }
}
