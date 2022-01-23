package leetcode;

import java.util.ArrayList;
import java.util.List;

public class P1078 {
    public String[] findOcurrences(String text, String first, String second) {
        String[] strs = text.split(" ");
        List<String> l = new ArrayList<>();
        for (int i = 0;i < strs.length-2;i++){
            if (first.equals(strs[i]) && second.equals(strs[i+1])){
                l.add(strs[i+2]);
            }
        }
        String[] strings = l.toArray(new String[l.size()]);
        return strings;
    }
}
