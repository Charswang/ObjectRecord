package leetcode.competition.easy;

import java.util.Arrays;
import java.util.List;

/**
 * 2022-4-17
 */
public class Zhaoshang01 {
    public static void main(String[] args) {
        String koN_y_j_du = deleteText("Hello World", 2);
        System.out.println(koN_y_j_du);
    }

    public static String deleteText(String article, int index) {
        if (index>=article.length() || article.charAt(index)==' '){
            return article;
        }
        String[] s = article.split(" ");
        StringBuffer sb = new StringBuffer();
        if (s[0].length()>index){
            return article.substring(s[0].length(),article.length()).trim();
        }else {
            sb.append(s[0]);
        }
        for (int i = 1;i<s.length;i++) {
            String s1 = s[i];
            if (sb.length()+s1.length()+1>index){
                index = Integer.MAX_VALUE;
                continue;
            }
            sb.append(" " + s1);
        }
        return sb.toString().trim();
    }
}
