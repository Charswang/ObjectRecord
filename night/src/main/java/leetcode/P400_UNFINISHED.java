package leetcode;

/**
 * 2021-11-30
 * 每日一题
 *
 * 为什么都得用long，只是num那里使用long不行。。。为什么？
 */
public class P400_UNFINISHED {
    public static void main(String[] args) {
        System.out.println(findNthDigit(1000000000));
    }
    public static int findNthDigit(int n) {
        long length=0;
        long cnt=9;// 当前区间有多少个数
        long i = 1;
        for (;length+cnt*i<n;i++){
            length += cnt*i;
            cnt *= 10;
        }
        // 因为Math.pow(10, i - 1)已经算是这个区间的第一个数了
        // 所以这里用n - length - 1；然后用它/i就是第一个数后面的第几个数了
        long num = (long)Math.pow(10, i - 1) + (n - length - 1) / i;
        long index = (n - length - 1) % i;// 定位到这个数的第几位
        return String.valueOf(num).charAt((int)index)-'0';
    }
    /**
     * 超出时间限制
     * @param n
     * @return
     */
    public int findNthDigit2(int n) {
        int i = 1;
        while (true){
            int len = String.valueOf(i).length();
            if (n-len>0){
                i++;
                n=n-len;
                continue;
            }else {
                char c = String.valueOf(i).charAt(n - 1);
                return Integer.parseInt(String.valueOf(c));
            }
        }
    }
}
