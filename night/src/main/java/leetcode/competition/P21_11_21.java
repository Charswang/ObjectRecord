package leetcode.competition;

public class P21_11_21 {
    public static void main(String[] args) {

    }

    public int maxDistance(int[] colors) {
        int res = 0;
        for (int i = 0; i < colors.length; i++) {
            int max = 0;
            for (int j = i + 1; j < colors.length; j++) {
                if (colors[j] != colors[i]) {
                    int a = j - i;
                    max = max > a ? max : a;
                }
            }
            res = res>max?res:max;
        }
        return res;
    }
    public int wateringPlants(int[] plants, int capacity) {
        int step=0;
        int a = capacity;
        int i = 0;
        while(i<plants.length){
            a = a-plants[i];
            if (a<0){
                step+=2*i;
                a = capacity;
                continue;
            }
            i++;
        }
        return step+plants.length;
    }
}
