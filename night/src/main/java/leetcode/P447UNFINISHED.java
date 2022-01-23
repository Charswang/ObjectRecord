package leetcode;

import java.util.HashMap;

/**
 * 2021-9-13
 */
public class P447UNFINISHED {
    public static void main(String[] args) {

    }
    public static int numberOfBoomerangs(int[][] points) {
        int len = points.length;
        int res = 0;
        HashMap<Double, Integer> map = new HashMap<>();
        for (int i = 0;i < len;i++){
            for (int j = 0;j < len;j++){
                double distance = 0;
                if (i!=j){
                    distance = Math.pow(points[i][0]-points[j][0],2) + Math.pow(points[i][1]-points[j][1],2);
                    if (!map.keySet().contains(distance)){
                        map.put(distance,1);
                    }else {
                        // 这两句不要颠倒顺序
                        res += 2*map.get(distance);
                        map.put(distance,map.get(distance)+1);
                    }
                }
            }
            map.clear();
        }
        return res;
    }
}
