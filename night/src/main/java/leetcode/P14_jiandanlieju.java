package leetcode;


import java.util.HashMap;

public class P14_jiandanlieju {
    public static void main(String[] args) {
        int n = 2999;
        int qian = n / 1000;
        int bai = n % 1000 / 100;
        int shi = n % 100 / 10;
        int ge = n % 10;
        String[] qians = {"","M","MM","MMM"};
        String[] bais = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
        String[] shis = {"","X","XX","XXX","XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] ges = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        System.out.println(qians[qian]+bais[bai]+shis[shi]+ges[ge]);



    }
}
