package leetcode;

public class P461 {
    public static void main(String[] args) {
        System.out.println(1^4); // 异或
    }
    public int hammingDistance(int x, int y) {
        int temp = x^y;
        int res = 0;
        int i = 30;
        while(temp>0){
            int i1 = 1 << i;
            if (i1<=temp){
                temp = temp - i1;
                res++;
            }
            i--;
        }
        return res;
    }
}
