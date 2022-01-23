package leetcode;

/**
 * 2021-11-15
 * 每日一题
 * 因为只有奇数个因子的时候，该位置灯泡才会变亮。一个数如果出现因子那肯定是成对出现的；
 * 但是如果这个数是平方数的话，他的开根号是一个因子，并且不是成对出现的。所以如果该位置是平方数，则会变亮；
 * 1-n之间的平方数的个数即为(int)Math.sqrt(n);
 */
public class P319_UN {
    public int bulbSwitch(int n){
        return (int)Math.sqrt(n);
    }
    /**
     * 超出内存限制
     * @param n
     * @return
     */
    public int bulbSwitch2(int n) {
        if(n==0){
            return 0;
        }
        int res = 1;
        int[] temp = new int[n+1];
        for(int i = 1;i <= n;i++){
            temp[i]=1;
        }
        for (int i = 2;i <= n;i++){
            int j = 1;
            while(j*i<=n){
                int a = j*i;
                temp[a]=temp[a]==1?0:1;
                j++;
            }
            res+=temp[i];
        }

        return res;
    }

    /**
     * 看有所少个因子？
     * 超出时间限制
     * @param n
     * @return
     */
    public int bulbSwitch1(int n) {
        int res = 0;
        for (int i = 1;i <= n;i++){
            int check = check(i);
            if (check%2!=0){
                res++;
            }
        }
        return res;
    }

    public int check(int n){
        int a = (int)Math.sqrt(n);
        int num=0;
        for (int i = 1;i <= a;i++){
            if (n%i==0){
                num++;
            }
        }
        if (a*a==n){
            num=num*2-1;
        }else{
            num = num*2;
        }
        return num;
    }
}
