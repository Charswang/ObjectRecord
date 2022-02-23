package leetcode;

/**
 * 2022-2-23
 * 每日一题
 */
public class P917 {
    public static void main(String[] args) {
        System.out.println((char)65);
        System.out.println((char)97);
    }
    public String reverseOnlyLetters(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length-1;
        while (left<right){
            if (Character.isLetter(s.charAt(left)) && Character.isLetter(s.charAt(right))){
                char c = chars[left];
                chars[left] = chars[right];
                chars[right] = c;
                left++;
                right--;
            }else if (!Character.isLetter(s.charAt(left))){
                left++;
            }else {
                right--;
            }
        }
        return String.valueOf(chars);
    }
}
