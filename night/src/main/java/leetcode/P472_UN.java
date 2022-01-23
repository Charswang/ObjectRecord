package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2021-12-28
 * 每日一题
 * 字典树+递归查找/dfs查找
 */
public class P472_UN {
    Trie trie = new Trie();
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>();
        // 先进行排序，保证当前单词如果是连接词的话，那肯定只能由前面的单词组成；
        Arrays.sort(words,((o1,o2) -> o1.length()-o2.length()));
        for (String word : words) {
            // 跳过空字符串
            if (word.equals("")){
                continue;
            }
            if (dfs(word,0)){
                res.add(word);
            }else{
                trie.insertWord(word);
            }
        }
        return res;
    }

    // 判断是不是连接词
    public boolean dfs(String word,int start){
        if (start==word.length()){
            return true;
        }
        Trie node = trie;
        // 注意是start!!!
        for (int i = start;i < word.length();i++){
            int index = word.charAt(i) - 'a';
            node = node.children[index];
            if (node==null){
                return false;
            }
            if (node.isEnd){ // 如果当前node为一个单词的结尾
                if (dfs(word,i+1)){
                    return true;
                }
                // 如果后面的字符不能组成数组中的单词，那么就要从上一层的i继续往下找 !!!! important[之前就在这里写了return false，就有错]
            }
        }
        return false;
    }
}
class Trie {
    Trie[] children;
    boolean isEnd;

    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }

    public void insertWord(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Trie();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }
}
