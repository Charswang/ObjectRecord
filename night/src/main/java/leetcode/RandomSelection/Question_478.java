package leetcode.RandomSelection;

import java.util.Random;

/**
 * 2022-6-5
 * 每日一题
 */
public class Question_478 {
    double radius;
    double x_center;
    double y_center;
    Random r;

    public Question_478(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
        r = new Random();
    }

    // 拒绝采样法
    // 2r*2r的正方形中有个圆，在正方形中随机采样，如果在圆中，则返回，否则继续找。
    // 因为nextDouble只能找[0,1)之间的小数，忽略了找不到1]的情况
    // 先找到[-r,r)之间的随机采样，然后再加上原点位置，返回即可。
    // 看的答案。
    public double[] randPoint() {
        // r.nextDouble() * (2*radius)   ==   [0，2*radius)
        // r.nextDouble() * (2*radius) - radius  ===  [-radius,radius)
        while (true) {
            double x = r.nextDouble() * (2 * radius) - radius;
            double y = r.nextDouble() * (2 * radius) - radius;
            if (x * x + y * y <= radius * radius) {
                return new double[]{x + x_center, y + y_center};
            }
        }
    }
}

