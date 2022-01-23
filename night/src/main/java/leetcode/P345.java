package leetcode;

import java.util.ArrayList;

public class P345 {
    public static void main(String[] args) {
        String s = "leetcode";
        char[] chars1 = s.toCharArray();
        String chars = "AEIOUaeiou";
        int pre = 0;
        int p = s.length()-1;
        while(pre<p){
            if (chars.indexOf(chars1[pre])!=-1 && chars.indexOf(chars1[p])!=-1){
                char c = chars1[pre];
                chars1[pre] = chars1[p];
                chars1[p] = c;
                pre++;
                p--;
                continue;
            }
            if (chars.indexOf(chars1[pre])==-1){
                pre++;
            }
            if (chars.indexOf(chars1[p])==-1){
                p--;
            }
        }
        System.out.println(String.valueOf(chars1));
    }
}
