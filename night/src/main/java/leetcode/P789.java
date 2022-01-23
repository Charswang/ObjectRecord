package leetcode;

/**
 * 理解题意
 */
public class P789 {
    public static void main(String[] args) {
        int[][] ghosts = {{1,0},{0,3}};
        int[] target = {0,1};
        System.out.println(escapeGhosts(ghosts, target));
    }
    public static boolean escapeGhosts(int[][] ghosts, int[] target) {
        int diatance = Math.abs(target[0]) + Math.abs(target[1]);
        for (int[] ghost : ghosts) {
            int i = Math.abs(ghost[0] - target[0]) + Math.abs(ghost[1] - target[1]);
            if (i<=diatance){
                return false;
            }
        }
        return true;
    }
}
