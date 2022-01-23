package leetcode;

/**
 * 2021-11-23
 */
public class P338_UNFINISHED {
    // 从右往前遇到的第一个0反转为1，这个0后面的所有1都变为0
    public int[] countBits(int n) {
        int[] res = new int[n+1];
        // f(n) = f(n-1)的最右边0的右边的位数-1；== 求f(n-1)最右边0的位置
        // 上面那个不知道怎么实现
        // 分奇偶；a为偶数的时候，就说明是a/2往左移1位所以res[a]=res[a/2]
        // a为奇数的时候,就说明a-1为偶数，a-1的最后一位为0，所以res[a] = res[a-1]+1

        for (int i = 0;i<=n;i++){
            if (i%2==0){
                res[i] = res[i/2];
            }else {
                res[i] = res[i-1]+1;
            }
        }
        return res;
    }
    public int[] countBits2(int n) {
        int[] res = new int[n+1];
        // 第i个数的1的个数==第1>>1的1的个数+(i&1)
        // i往右移动一位，相当于i的最后一位消失；然后用i&1就是用来判断i的最后一位是否是1，如果是1的话i&1也是1，否则为0
        for (int i = 0;i<=n;i++){
            res[i] = res[i>>1] + (i&1);
        }
        return res;
    }
}
