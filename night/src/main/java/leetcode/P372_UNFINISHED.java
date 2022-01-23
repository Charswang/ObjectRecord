package leetcode;

public class P372_UNFINISHED {
    int MOD = 1337;
    public int superPow(int a, int[] b) {
        return dfs(a,b,b.length-1);
    }
    public int dfs(int a,int[] b,int l){
        if(l==-1){
            return 1;
        }
        int i = pow(dfs(a, b, l - 1), 10) * pow(a, b[l]) % MOD;
        return i;
    }
    public int pow(int a,int b){
        int ans = 1;
        a %= MOD;
        // while (b != 0) {
        //     if ((b & 1) != 0) ans = ans * a % MOD;
        //     a = a * a % MOD;
        //     b >>= 1;
        // }
        while(b-->0){
            ans = ans * a % MOD;
        }
        return ans;
    }
}
