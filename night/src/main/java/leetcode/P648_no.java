package leetcode;

import java.util.*;

/**
 * 字典树的数据结构
 */
class Trie1 {
    Map<Character, Trie1> children;

    public Trie1() {
        children = new HashMap<>();
    }
}

public class P648_no {

    /**
     * 字典树，搜索前缀
     *
     * @param dictionary
     * @param sentence
     * @return
     */
    public String replaceWords(List<String> dictionary, String sentence) {
        // 构建字典树
        Trie1 Trie1 = new Trie1();
        for (String word : dictionary) {
            Trie1 cur = Trie1;
            for (int i = 0; i < word.length(); i++) {
                cur.children.putIfAbsent(word.charAt(i), new Trie1());
                cur = cur.children.get(word.charAt(i));
            }
            cur.children.putIfAbsent('#', new Trie1());
        }
        String[] split = sentence.split(" ");
        for (int i = 0; i < split.length; i++) {
            split[i] = findRoot(split[i], Trie1);
        }
        return String.join(" ", split);
    }

    public String findRoot(String word, Trie1 Trie1) {
        StringBuffer sb = new StringBuffer();
        Trie1 cur = Trie1;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.children.containsKey('#')){ // 这个if要放到前面
                return sb.toString();
            }
            if (!cur.children.containsKey(c)){ // 这个if要放到后面
                return word;
            }
            sb.append(c);
            cur = cur.children.get(c);
        }
        return sb.toString();
    }


    /**
     * 很容易超时
     *
     * @param dictionary
     * @param sentence
     * @return
     */
    public String replaceWords_2(List<String> dictionary, String sentence) {
        Set<String> dictionarySet = new HashSet<String>();
        for (String root : dictionary) {
            dictionarySet.add(root);
        }
        String[] split = sentence.split(" ");
        StringBuffer res = new StringBuffer();
        for (String s : split) {
            StringBuffer sb = new StringBuffer();
            boolean flag = false;
            for (int i = 0; i < s.length(); i++) {
                sb.append(s.charAt(i));
                if (dictionarySet.contains(sb.toString())) {
                    flag = true;
                    res.append(sb.toString() + " ");
                    break;
                }
            }
            if (!flag) {
                res.append(s + " ");
            }
        }
        return res.toString().trim();
    }
}
