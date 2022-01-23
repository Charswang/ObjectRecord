package leetcode;

import java.util.Arrays;

public class P825 {
    /**
     * 拆除时间限制
     * @param ages
     * @return
     */
    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        int res = 0;
        for (int i = ages.length-1;i>=0;i--){
            for (int j = i - 1;j >= 0;j--){
                if (ages[j]<=14){
                    break;
                }
                if (ages[i]*0.5+7<ages[j]){
                    res++;
                    if (ages[i]==ages[j]){
                        res++;
                    }
                }
            }
        }
        return res;
    }
}
