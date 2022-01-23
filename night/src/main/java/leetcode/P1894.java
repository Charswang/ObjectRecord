package leetcode;

/**
 * 2021-9-10
 */
public class P1894 {
    public static void main(String[] args) {
        int[] chalk = {5,1,5};
        int k = 2;
        int i = chalkReplacer(chalk, k);
        System.out.println(i);
    }
    public static int chalkReplacer(int[] chalk, int k) {
        long sum = 0; // 注意使用int的话会出现错误；
        for (int i : chalk) {
            sum += i;
        }
        long leave = k%sum;
        for (int i = 0;i < chalk.length;i++){
            if (leave<chalk[i]){
                return i;
            }
            leave = leave - chalk[i];
        }
        return 0;
    }
}
