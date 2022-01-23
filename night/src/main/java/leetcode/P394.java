package leetcode;

import java.util.Stack;

/**
 * 2021-12-6
 */
public class P394 {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuffer res = new StringBuffer("");
        for (int i = 0;i < s.length();i++){
            if (s.charAt(i)!=']'){
                stack.add(s.charAt(i));
            }else{
                StringBuffer sb = new StringBuffer("");
                while (!stack.isEmpty() && stack.peek()!='['){
                    sb.insert(0,stack.pop());
                }
                stack.pop();
                StringBuffer num = new StringBuffer("");
                while(!stack.isEmpty() && Character.isDigit(stack.peek())){
                    num.insert(0,stack.pop());
                }
                int t = Integer.parseInt(num.toString());
                String s1 = sb.toString();
                for (int a = 0;a < t-1;a++){
                    sb.append(s1);
                }
                String s2 = sb.toString();
                if (i==s.length()-1){
                    res.append(s2);
                }else{
                    for (int b = 0;b < s2.length();b++){
                        stack.add(s2.charAt(b));
                    }
                }
            }
        }
        while (!stack.isEmpty()){
            res.insert(0,stack.pop());
        }
        return res.toString();

    }
}
