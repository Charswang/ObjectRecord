package leetcode;

/**
 * 2022-1-2
 */
public class P390 {
    /**
     * ①、当前剩余的数字个数为偶数时只会删除一个边界[左/右]；
     * ②、第x次删除之后，数字相隔的数的大小为2的x次方；从0开始
     * ③、还要标注是从前往后删除还是从后往前删除；
     * ②和③使用turn还表示；
     * @param n
     * @return
     */
    public int lastRemaining(int n) {
        int left = 1;
        int right = n;
        int temp = n; // 为偶数个数时只会删除一个边界，奇数个数的话两个边界都会删除
        int turn = 0; // 能整除2说明从前往后，否则从后往前删除
        while (temp!=1){
            if (temp%2==0){
                if (turn%2==0){
                    left = left + (int)Math.pow(2,turn);
                }else{
                    right = right - (int)Math.pow(2,turn);
                }
            }else{
                left = left + (int)Math.pow(2,turn);
                right = right - (int)Math.pow(2,turn);
            }
            turn++;
            temp = temp / 2;
        }
        return left;
    }
}
