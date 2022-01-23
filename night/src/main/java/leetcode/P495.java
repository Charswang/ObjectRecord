package leetcode;

public class P495 {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int res = 0;
        int end = -1;
        for (int i = 0;i < timeSeries.length;i++){
            if (timeSeries[i]>end){
                res += duration;
                end = timeSeries[i]+duration-1;
            }else{
                res+=duration-(end-timeSeries[i]+1);
                end=end+duration-(end-timeSeries[i]+1);
            }
        }
        return res;
    }
}
