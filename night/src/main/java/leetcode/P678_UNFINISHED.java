package leetcode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 2021-9-12
 */
public class P678_UNFINISHED {
    public static void main(String[] args) {
        boolean b = checkValidString("(((((*)))**");
        System.out.println(b);
    }
    public static boolean checkValidString(String s) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> nums_xing = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0;i < chars.length;i++){
            char aChar = chars[i];
            if (aChar == '(') {
                stack.push(i);
            }
            if (aChar == '*') {
                nums_xing.push(i);
            }
            if (aChar == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    if (!nums_xing.isEmpty()) {
                        nums_xing.pop();
                    } else {
                        return false;
                    }
                }
            }
        }
        while (!stack.isEmpty() && !nums_xing.isEmpty()) {
            int pop = stack.pop();
            int pop1 = nums_xing.pop();
            if (pop>pop1){
                return false;
            }
        }
        return stack.isEmpty();
    }
}
