package leetcode.程序员面试宝典;

/**
 * 2022-7-16
 */
public class P01_02 {
    public static void main(String[] args) {

    }

    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int[] temp = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            temp[s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s1.length(); i++) {
            if (temp[s2.charAt(i) - 'a']==0){
                return false;
            }
            temp[s2.charAt(i) - 'a']--;
        }
        return true;
    }
}
