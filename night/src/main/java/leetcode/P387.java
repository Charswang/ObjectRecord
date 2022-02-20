package leetcode;

/**
 * 2022-2-20
 */
public class P387 {
    public static void main(String[] args) {
        System.out.println((char)97);
    }
    public static int firstUniqChar(String s) {
        for (int i = 0;i < s.length();i++){
            char c = s.charAt(i);
            if (s.indexOf(c)==s.lastIndexOf(c)){
                return s.indexOf(c);
            }
        }
        return -1;
    }
}
