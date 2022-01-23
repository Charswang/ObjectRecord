package leetcode;

/**
 * 2021-9-7
 */
public class P1221 {
    public static void main(String[] args) {
        String s = "RLRRRLLRLL";
        int i = balancedStringSplit(s);
        System.out.println(i);
    }
    public static int balancedStringSplit(String s) {
        char[] chars = s.toCharArray();
        int num_R = 0;
        int num_L = 0;
        int res = 0;
        for (char aChar : chars) {
            if (aChar=='R'){
                num_R++;
            }else{
                num_L++;
            }
            if (num_L==num_R){
                res++;
                num_L=0;
                num_R=0;
            }
        }
        return res;
    }
}
