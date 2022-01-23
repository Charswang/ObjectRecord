package leetcode;

/**
 * 2022-1-5
 * 每日一题
 */
public class P1576_UN {
    public String modifyString(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0;i < chars.length;i++){
            if (chars[i]=='?'){
                char a = 'a';
                /**
                 * 要熟悉这里，
                 * 遇到一个数组中除了0和n.length-1位置上的操作不一样，其他位置所执行的操作是一样的
                 */
                while((i>0 && chars[i-1]==a)||(i<chars.length-1&&chars[i+1]==a)){
                    a++;
                }
                chars[i] = a;
            }
        }
        return String.valueOf(chars);
    }
}
