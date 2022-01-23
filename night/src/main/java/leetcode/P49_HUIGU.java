package leetcode;

import java.util.*;

/**
 * @author chaswang
 * @since 2021-8-29
 */
public class P49_HUIGU {
    public static void main(String[] args) {
        String[] strs = {"a"};
        List<List<String>> lists = groupAnagrams(strs);
        for (List<String> list : lists) {
            for (String s : list) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
        System.out.println(lists.size());
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String s = String.valueOf(chars);
            if (map.keySet().contains(s)){
                map.get(s).add(str);
            }else{
                ArrayList<String> strings = new ArrayList<String>();
                strings.add(str);
                map.put(s,strings);
            }
        }
        List<List<String>> res = new ArrayList<List<String>>();
        for (String s : map.keySet()){
            res.add(map.get(s));
        }
        return res;
    }
}
