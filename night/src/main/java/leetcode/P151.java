package leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 2022-1-11
 * 每日一题
 */
public class P151 {
    public String reverseWords(String s) {
        /*String[] split = s.trim().split(" +");
        StringBuffer sb = new StringBuffer();
        for (int i = split.length-1;i > 0;i--){
            sb.append(split[i] + " ");
        }
        sb.append(split[0]);
        return sb.toString();*/
        String[] split = s.trim().split(" +");
        List<String> strings = Arrays.asList(split);
        Collections.reverse(Arrays.asList(split));
        return String.join(" ",split);
    }
}
