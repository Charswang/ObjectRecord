package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 2022-7-3
 * 0701的每日一题
 * 怎样去加括号
 *
 * 几种不同出栈的情况？
 */
public class P241 {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> list = new ArrayList<>();
        Stack<Character> stack = new Stack<>();
        stack.add(expression.charAt(0));
        dfs(expression,stack,1,list);
        return null;
    }
    public void dfs(String expressiop, Stack<Character> stack,int num,List<Integer> list){

    }
}
