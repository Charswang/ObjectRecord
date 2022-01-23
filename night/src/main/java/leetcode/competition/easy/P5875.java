package leetcode.competition.easy;

public class P5875 {
    public static void main(String[] args) {

    }
    public int finalValueAfterOperations(String[] operations) {
        int count = 0;
        for (String operation : operations) {
            if (operation.charAt(1)=='+'){
                count++;
            }else{
                count--;
            }
        }
        return count;
    }
}
