package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 2021-10-6   没写出来，只是单纯的自己想的太简单了
 */
public class P282_UNFINISH {
    public static void main(String[] args) {
        String a = "1+2*3";
        System.out.println(compute(a));
    }
    // 回溯试一下
    /*List<String> list = new ArrayList<>();
    public List<String> addOperators(String num, int target) {
        dfs(num,target,1,String.valueOf(num.charAt(0)));
        return list;
    }
    public void dfs(String num,int target,int n,String temp){
        if (n==num.length()){
            if (compute(temp)==target){
                System.out.println(compute(temp));
                list.add(temp);
            }
            return;
        }
        dfs(num, target, n+1,  temp+"+"+num.charAt(n));
        dfs(num, target, n+1,  temp+"-"+num.charAt(n));
        dfs(num, target, n+1,  temp+"*"+num.charAt(n));
        return;
    }*/
    public static int compute(String temp){
        Stack<Character> stack = new Stack<>();
        int i = 0;
        while(i < temp.length()){
            char c = temp.charAt(i);
            if (c!='*'){
                stack.push(c);
                i++;
            }else{
                Character pop = stack.pop();
                char c1 = temp.charAt(i + 1);
                System.out.println(Integer.parseInt(String.valueOf(c1)));
                int t = Integer.parseInt(String.valueOf(pop)) * Integer.parseInt(String.valueOf(c1));
                stack.push(String.valueOf(t).charAt(0));
                i+=2;
            }
        }
        int res = Integer.parseInt(String.valueOf(stack.pop()));
        while (!stack.isEmpty()){
            Character pop = stack.pop();
            Character pop1 = stack.pop();
            int a = Integer.parseInt(String.valueOf(pop1));
            if (pop=='+'){
                res = a + res;
            }else{
                res = a - res;
            }
        }
        return res;
    }
}
