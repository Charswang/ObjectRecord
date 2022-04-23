package leetcode;

/**
 * 2022-4-23
 *
 * 【注意！！！】
 * 取ax2和bx2的最大值，ax1和bx1的最小值，就是x的范围 --- y值同理 ！！！
 *【注意！！！】
 */
public class P223 {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        // 分别计算两个矩形的面积
        int r1 = computeArea(ax1, ay1, ax2, ay2);
        int r2 = computeArea(bx1, by1, bx2, by2);

        // 计算两者相交面积
        // ax2>ax1  bx2>bx1  ay2>ay1  by2>by1
        int cx1, cx2, cy1, cy2;
        int r3;
        // 判断是否相交
        if (ax2 <= bx1 || ax1 >= bx2 || ay2 <= by1 || ay1 >= by2) {
            return r1 + r2;
        }
        cx2 = Math.min(ax2, bx2);
        cx1 = Math.max(ax1, bx1);
        cy2 = Math.min(ay2, by2);
        cy1 = Math.max(ay1, by1);
        r3 = computeArea(cx1, cy1, cx2, cy2);
        return r1 + r2 - r3;
    }

    /**
     * 计算矩形面积
     *
     * @param ax1 x1
     * @param ay1 y1
     * @param ax2 x2
     * @param ay2 y2
     * @return area
     */
    public int computeArea(int ax1, int ay1, int ax2, int ay2) {
        int width = ax2 - ax1;
        int height = ay2 - ay1;
        return height * width;
    }
}
