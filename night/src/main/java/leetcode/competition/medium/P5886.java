package leetcode.competition.medium;

/**
 * 2021-10-16
 */
public class P5886 {
    public static void main(String[] args) {
        System.out.println(winnerOfGame("1111"));
    }

    public static boolean winnerOfGame(String colors) {
//        StringBuffer sb = new StringBuffer(colors);
        int a_num = 0;
        int b_num = 0;
        for (int i = 1; i < colors.length() - 1; i++) {
            if (colors.charAt(i) == colors.charAt(i - 1) && colors.charAt(i) == colors.charAt(i + 1)) {
                if (colors.charAt(i) == 'A') {
                    a_num++;
                } else {
                    b_num++;
                }
            }
        }
        return a_num > b_num ? true : false;
    }
}
