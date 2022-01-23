package leetcode;

/**
 * 2021-11-17
 * 每日一题
 *
 * 使用bitmap，将单词转换为26位的二进制数，然后两个单词的二进制数进行与运算如果==0，则说明没有公共字符。
 *
 */
public class P318_UN {
    public static void main(String[] args) {
        String[] words = {"abc"};
        System.out.println(maxProduct(words));
    }

    public static int maxProduct(String[] words) {
        int len = words.length;
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            int sum = 0;
            for (int j = 0; j < words[i].length(); j++) {
                int index = words[i].charAt(j) - 'a';
                // sum += (1 << index);
                /**
                 * !!!
                 */
                sum |= (1 << index); // 应对一个单词中出现重复字母的时候
            }
            arr[i] = sum;
        }
        int max = 0;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if ((arr[i] & arr[j]) == 0) {
                    int l = words[i].length() * words[j].length();
                    max = l > max ? l : max;
                }
            }
        }
        return max;
    }
}
