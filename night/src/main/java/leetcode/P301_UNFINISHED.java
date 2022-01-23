package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 2021-10-27
 * 每日一题
 */
public class P301_UNFINISHED {
    public List<String> removeInvalidParentheses(String s) {
        Set<String> set = new HashSet<>();
        set.add(s);
        List<String> list = new ArrayList<>();
        while(true){
            for (String s1 : set) {
                if (isValid(s1)){
                    list.add(s1);
                }
            }
            if (!list.isEmpty()){
                return list;
            }
            Set<String> set_temp = new HashSet<>();
            for (String s1 : set) {
                for (int i = 0;i < s1.length();i++){
                    if (s1.charAt(i)=='(' || s1.charAt(i)==')'){
                        set_temp.add(s1.substring(0,i)+s1.substring(i+1,s1.length()));
                    }
                }
            }
            set=set_temp;
        }
    }

    /**
     * 判断字符串是否合法
     * @param str
     * @return
     */
    public boolean isValid(String str){
        int count=0;
        int len = str.length();
        for (int i = 0;i < len;i++){
            if (str.charAt(i)=='('){
                count++;
            }
            if (str.charAt(i)==')'){
                count--;
            }
            if (count<0){
                return false;
            }
        }
        return count==0;
    }
}
