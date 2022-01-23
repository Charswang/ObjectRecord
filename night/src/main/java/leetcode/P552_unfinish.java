package leetcode;

public class P552_unfinish {
    private static int sum = 0;
    public static void main(String[] args) {
        int n = 2;
        System.out.println(checkRecord(n));
    }
    public static int checkRecord(int n){
        char[] chars = {'A','L','P'};
        int num = 0;
        dfs(n,num,chars,"");
        return sum;
    }
    public static void dfs(int n,int num,char[] chars,String str){
        for (int i = 0;i<chars.length;i++){
            if (chars[i]=='A'){
                if (str.contains("A")){
                    continue;
                }
            }else if (chars[i]=='L'){
                if (num>2){
                    if ("LL".equals(str.substring(num-1))){
                        continue;
                    }
                }
            }
            if (num==n-1){
                sum++;
                return;
            }

            dfs(n,num+1,chars,str+chars[i]);
        }
    }
}
