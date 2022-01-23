package leetcode;

import java.util.Stack;

/**
 * 2022-1-2
 */
public class P71 {
    public static void main(String[] args) {
        String s = simplifyPath("///ddd///ddd/../././...//////44//ddd");
        System.out.println(s);
    }

    /**
     * 太慢了。
     * 执行用时： 11 ms , 在所有 Java 提交中击败了 7.15% 的用户
     * 内存消耗： 38.8 MB , 在所有 Java 提交中击败了 6.51% 的用户
     * @param path
     * @return
     */
    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] split = path.split("/+");
        StringBuffer res = new StringBuffer("");
        for (int i = 0;i < split.length;i++){
            if (split[i].equals("")){
                continue;
            }
            if (split[i].equals(".")){
                continue;
            }else if (split[i].equals("..")){
                if (!stack.isEmpty()){
                    stack.pop();
                }
            }else{
                stack.add(split[i]);
            }
        }
        while (!stack.isEmpty()){
            res.insert(0,"/" + stack.pop());
        }
        if (!res.toString().startsWith("/")){
            res.insert(0,"/");
        }
        return res.toString();
    }
}
