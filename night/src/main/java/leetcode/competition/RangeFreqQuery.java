package leetcode.competition;

public class RangeFreqQuery {
    int[] temp;

    public RangeFreqQuery(int[] arr) {
        temp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }
    }

    public int query(int left, int right, int value) {
        int sum = 0;
        for (int i = left;i<=right;i++){
            if (temp[i]==value){
                sum++;
            }
        }
        return sum;
    }
}
