package leetcode;

/**
 * 2022-7-17
 * 每日一题
 */
public class P565 {
    public static void main(String[] args) {

    }

    /**
     * 要注意到的点是：只要一个节点在一个环里面，那么就只能在这个环里面，到不了其他的环里
     *
     * 第二中原地标记的方法是去掉visited数组，直接把访问过的数字改为不在0~n-1贩卖为里的数，以此为while里面的条件
     * @param nums
     * @return
     */
    public int arrayNesting(int[] nums) {
        int res = 0;
        boolean[] visited = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int temp = 0;
            while (!visited[i]) {
                visited[i] = true;
                i = nums[i];
                temp++;
            }
            res = Math.max(res, temp);
        }
        return res;
    }
}
