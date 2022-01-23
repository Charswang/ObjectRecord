package leetcode;

public class P34 {
    public static void main(String[] args) {
        int[] num = {};
        int target = 0;
        int[] res = {-1, -1};
        int a = -1;
        int b = -1;
        int i = 0;
        int j = num.length - 1;
        while (i <= j) {
            if (num[i] == target && num[j] == target) {
                res[0] = i;
                res[1] = j;
                break;
            }
            if (num[i] != target) {
                i++;
            }
            if (num[j] != target) {
                j--;
            }
        }
        for (int re : res) {
            System.out.println(re);
        }
    }
}
