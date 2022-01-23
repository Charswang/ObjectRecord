package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 2021-11-17
 * 11-16的每日一题
 */
public class P391_UNFINISHED {
    public boolean isRectangleCover(int[][] rectangles) {
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        int bottom = Integer.MAX_VALUE;
        int top = Integer.MIN_VALUE;
        int all_area = 0;
        int temp_area = 0;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < rectangles.length; i++) {
            // 求四个点
            left = Math.min(left,rectangles[i][0]);
            right = Math.max(right,rectangles[i][2]);
            bottom = Math.min(bottom,rectangles[i][1]);
            top = Math.max(top,rectangles[i][3]);

            // 求假定构成矩形总的大小
            temp_area = (right-left) * (top-bottom);
            all_area+=(rectangles[i][2]-rectangles[i][0]) * (rectangles[i][3]-rectangles[i][1]);

            // 除了四个顶点是只能出现一次，其他点都是成对出现的；
            // 计算小矩形的四个顶点
            String lt = rectangles[i][0] + " " + rectangles[i][3];
            String lb = rectangles[i][0] + " " + rectangles[i][1];
            String rt = rectangles[i][2] + " " + rectangles[i][3];
            String rb = rectangles[i][2] + " " + rectangles[i][1];
            // 如果没出现过就加入，出现过就移除；最后再计算，剩余的坐标是否与大的矩形四个点的坐标相同
            if (!set.contains(lt)) set.add(lt);
            else set.remove(lt);
            if (!set.contains(lb)) set.add(lb);
            else set.remove(lb);
            if (!set.contains(rt)) set.add(rt);
            else set.remove(rt);
            if (!set.contains(rb)) set.add(rb);
            else set.remove(rb);
        }
        //最后只剩4个大矩形坐标且面积相等即为完美矩形
        if (set.size() == 4 && set.contains(left + " " + top) && set.contains(left + " " + bottom) && set.contains(right + " " + bottom) && set.contains(right + " " + top)) {
            return temp_area==all_area;
        }
        return false;
    }
}
