package leetcode;

import java.util.ArrayList;
import java.util.List;

public class P68_UNFINISH {
    public static void main(String[] args) {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        List<String> strings = fullJustify(words, 16);
        for (String string : strings) {
            System.out.println(string);
        }
    }

    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<String>();
        int right = 0;
        int n = words.length;
        while (true){
            int left = right;
            int sum_len = 0;
            while(right<n && sum_len + words[right].length() + right - left<=maxWidth){
                sum_len += words[right].length();
                right++;
            }
            if (right==n){
                String zhongjian = zhongjian(words, left, right," ");
                String jiakongge = jiakongge(maxWidth - zhongjian.length());
                result.add(zhongjian+jiakongge);
                return result;
            }
            int word_num = right-left;
            int extral_num = maxWidth-sum_len;
            if (word_num==1){
                String jiakongge = jiakongge(extral_num);
                result.add(words[left]+jiakongge);
                continue;
            }
            // 多个单词
            int avg_space = extral_num / (word_num - 1);
            int extral_space = extral_num % (word_num - 1);
            String zhongjian = zhongjian(words, left, left+extral_space+1, jiakongge(avg_space+1));
            String jiakongge = jiakongge(avg_space);
            String zhongjian1 = zhongjian(words, left + extral_space + 1, right, jiakongge(avg_space));
            result.add(zhongjian+jiakongge+zhongjian1);
        }
    }
    public static String jiakongge(int n){
        StringBuffer sb = new StringBuffer("");
        for (int i = 0;i < n;i++){
            sb.append(" ");
        }
        return sb.toString();
    }
    public static String zhongjian(String[] words,int left,int right,String space){
        StringBuffer sb = new StringBuffer("");
        sb.append(words[left]);
        for (int i = left+1;i<right;i++){
            sb.append(space);
            sb.append(words[i]);
        }
        return sb.toString();
    }
}
