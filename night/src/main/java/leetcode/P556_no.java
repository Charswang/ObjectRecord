package leetcode;

/**
 * 2022-7-4
 * P556与P31差不多
 */
public class P556_no {
    public int nextGreaterElement(int n) {
        char[] chars = String.valueOf(n).toCharArray();
        int a = chars.length-2;
        while (a>=0 && chars[a]>=chars[a+1]){
            a--;
        }
        if (a == -1) {
            return -1;
        }
        int b = chars.length-1;
        while (b>=0 && chars[a]>=chars[b]){
            b--;
        }
        swap(chars, a, b);
        reverse(chars, a + 1, chars.length - 1);
        long ans = Long.parseLong(new String(chars));
        return ans > Integer.MAX_VALUE ? -1 : (int)ans;
    }

    public void swap(char[] chars, int a, int b) {
        char temp = chars[a];
        chars[a] = chars[b];
        chars[b] = temp;
    }

    public void reverse(char[] chars, int start, int end) {
        while (start < end) {
            swap(chars, start, end);
            start++;
            end--;
        }
    }
}
