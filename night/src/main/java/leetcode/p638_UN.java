package leetcode;

import java.util.List;

/**
 * 2021-10-24
 * 每日一题
 *
 * 或许需要dfs
 */
public class p638_UN {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int len = needs.size();
        int res = 0;
        while(true){
            boolean a = true;
            int max_lirun = 0;
            int max_index = 0;
            for (int j = 0;j < special.size();j++) {
                boolean flag = true;
                int sum = 0;
                for (int i = 0;i < needs.size();i++){
                    if (special.get(j).get(i)>needs.get(i)){
                        flag = false;
                        break;
                    }
                    sum += price.get(i)*needs.get(i);
                }
                if (flag){
                    int lirun = sum - special.get(j).get(len);
                    if (max_lirun<lirun){
                        max_lirun = lirun;
                        max_index = j;
                    }
                }
            }
            if (max_index==0&&max_lirun==0){
                break;
            }else {
                for (int i = 0;i < needs.size();i++){
                    res += max_lirun;
                    needs.set(i,needs.get(i)-special.get(max_index).get(i));
                }
            }
        }
        for (int i = 0;i < needs.size();i++){
            res += needs.get(i)*price.get(i);
        }
        return res;
    }
}
