package leetcode;

public class P97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        int num1 = 0;
        int num2 = 0;
        String temp = "";
        StringBuffer sb = new StringBuffer("");


        if (num1==s1.length() && num2==s2.length() && temp.equals(s3)){
            return true;
        }
        return false;
    }
}
