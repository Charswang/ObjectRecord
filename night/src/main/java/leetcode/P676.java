package leetcode;

import com.google.gson.internal.$Gson$Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2022-7-11
 * 每日一题
 */
public class P676 {

}

class MagicDictionary {
    Map<Integer, List<String>> map;

    public MagicDictionary() {
        map = new HashMap<>();
    }

    public void buildDict(String[] dictionary) {
        for (String s : dictionary) {
            int len = s.length();
            if (map.containsKey(len)) {
                List<String> strings = map.get(len);
                strings.add(s);
                map.put(len, strings);
            }else {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(len,list);
            }
        }
    }

    public boolean search(String searchWord) {
        int len = searchWord.length();
        if (map.containsKey(len)) {
            List<String> strings = map.get(len);
            /*if (strings.contains(searchWord)) {
                return false;
            }*/
            for (String string : strings) {
                int k = 0;
                for (int i = 0; i < len; i++) {
                    if (string.charAt(i) != searchWord.charAt(i)) {
                        k++;
                    }
                    if (k > 1) {
                        break;
                    }
                }
                if (k == 1) {
                    return true;
                }
            }
        }
        return false;
    }
}