package leetcode;

public class P492_UN {
    public static void main(String[] args) {
        int[] ints = constructRectangle(2);

    }
    public static int[] constructRectangle(int area) {
        int[] res = new int[2];
        int floor = (int) Math.ceil(Math.sqrt(area));
        for (int i = floor;i<=area;i++){
            if (area%i==0){
                res[0] = i;
                res[1] = area / i;
                return res;
            }
        }
        return null;
    }
}
