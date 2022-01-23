package leetcode;

/**
 * 2022-1-10
 *
 * dfs
 */
public class P306_UNFINISHED_dfs {
    public boolean isAdditiveNumber(String num) {
        return dfs(num,0,0,0,0);
    }
    public boolean dfs(String num,int start,int count,long prevprev,long prev){
        if (start>=num.length()){
            return count>2;
        }
        long current = 0;
        for (int i = start;i < num.length();i++){
            if (num.charAt(start)=='0' && i>start){
                return false;
            }
            char c = num.charAt(i);
            current = current * 10 + (c-'0');
            if (count>=2){
                long a = prev + prevprev;
                if (current>a){
                    return false;
                }
                if (current<a){
                    continue;
                }
            }
            if (dfs(num, i+1, count+1, prev,current)){
                return true;
            }
        }
        return false;
    }
}
