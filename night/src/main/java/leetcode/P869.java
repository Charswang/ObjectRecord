package leetcode;

/**
 * 2021-10-28
 * 每日一题
 */
public class P869 {
    public boolean reorderedPowerOf2(int n) {
        String str = String.valueOf(n);
        char[] chars = str.toCharArray();
        int[] visited = new int[chars.length];
        return dfs(chars,"",visited);
    }
    public boolean dfs(char[] chars,String str,int[] visited){
        if (str.length()==chars.length){
            int temp = Integer.parseInt(str);
            if(str.charAt(0)=='0'){
                return false;
            }
            if (check(temp)){
                return true;
            }
        }
        boolean flag = false;
        for (int i = 0;i < chars.length;i++){
            if (visited[i]==0){
                visited[i]=1;
                boolean dfs = dfs(chars, str + chars[i], visited);
                if (dfs){
                    flag=true;
                }
                visited[i]=0;
            }
        }
        return flag;
    }

    /**
     * 判断是否为2的幂次方
     * (n & (n-1))==0 ?
     * @param temp
     * @return
     */
    public boolean check(int temp){
        int a = 0;
        while(a<=temp){
            int t = 1 << a;
            if (t==temp){
                return true;
            }
            if (t<temp){
                a++;
            }else {
                break;
            }
        }
        return false;
    }
}
