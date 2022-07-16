package leetcode.程序员面试宝典;

import java.util.HashSet;
import java.util.Set;

/**
 * 2022-7-16
 */
public class P01_01 {
    public static void main(String[] args) {

    }
    public boolean isUnique(String astr) {
        int[] temp = new int[26];
        int len = astr.length();
        for (int i = 0;i < len;i++){
            if (temp[astr.charAt(i)-'a']==1){
                return false;
            }
            temp[astr.charAt(i)-'a'] = 1;
        }
        return true;
    }
}
