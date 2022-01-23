package leetcode;

/**
 * 旋转图像
 * 想法：先对所有列的顺序转换，然后对阵转换
 * @author charswang
 * @since 2021-8-29
 */
public class P48 {
    public static void main(String[] args) {
        int[][] matrix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        rotate(matrix);
    }
    public static void rotate(int[][] matrix) {
        int len = matrix.length;
        // 列顺序转换
        for (int i = 0;i < len;i++){
            for (int j = 0;j<len/2;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][len-j-1];
                matrix[i][len-j-1] = temp;
            }
        }
        //对称转换
        for (int i = 0;i < len;i++){
            for (int j = 0;j<len - i;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[len-1-j][len-1-i];
                matrix[len-1-j][len-1-i] = temp;
            }
        }
        for (int i = 0;i < len;i++){
            for (int j = 0;j<len;j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
