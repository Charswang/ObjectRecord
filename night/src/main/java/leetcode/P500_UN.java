package leetcode;

import java.util.ArrayList;
import java.util.List;

public class P500_UN {
    public String[] findWords(String[] words) {
        List<String> res_list = new ArrayList<>();
        String rowIdx = "12210111011122000010020202";
        for (String word : words) {
            boolean b = true;
            char index = rowIdx.charAt(word.toLowerCase().charAt(0)-'a');
            for (int i = 0;i < word.length();i++){
                char c = rowIdx.charAt(word.toLowerCase().charAt(i) - 'a');
                if (c!=index){
                    b=false;
                }
            }
            if (b){
                res_list.add(word);
            }
        }
        String[] res = new String[res_list.size()];
        for (int i = 0;i < res_list.size();i++){
            res[i] = res_list.get(i);
        }
        return res;
    }
}
