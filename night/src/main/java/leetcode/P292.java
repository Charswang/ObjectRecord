package leetcode;

/**
 * 2021-9-18
 */
public class P292 {
    public static void main(String[] args) {
        System.out.println(canWinNim(13));
    }
    public static boolean canWinNim(int n){
        if (n%4>0 && n%4<=3){
            return true;
        }
        return false;
    }
}
