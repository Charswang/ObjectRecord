package leetcode;

public class P1583 {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int[][] orders = new int[n][n];
        // 每个数匹配的优先级
        for (int i = 0; i < preferences.length; i++) {
            for (int j = 0; j < preferences[0].length; j++) {
                orders[i][preferences[i][j]] = j;
            }
        }
        // 设置每个数实际匹配的值
        int[] pair = new int[n];
        for (int[] ints : pairs) {
            pair[ints[0]] = ints[1];
            pair[ints[1]] = ints[0];
        }
        // 获取不开心人数
        int unhappyCount = 0;
        // 从第0个人开始算
        for (int i = 0; i < n; i++) {
            // 第i个人实际匹配朋友的优先级
            int i_pre = orders[i][pair[i]];
            // 如果实际优先级大于0的话，进行判断
            if (i_pre>0){
                // 获取那些优先级高于i实际匹配的人的人
                for (int j = 0;j < i_pre;j++){
                    // 比i目前匹配的数的优先级要高的数
                    int num = preferences[i][j];
                    if (orders[num][pair[num]] > orders[num][i]){
                        unhappyCount++;
                        break;
                    }
                }
            }
        }
        return unhappyCount;
    }
}
