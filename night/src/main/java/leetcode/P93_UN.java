package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 2022-1-5
 * 每日一题
 */
public class P93_UN {
    /**
     * dfs吧
     * @param s
     * @return
     */
    String str = null;
    List<String> res = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        int[] temp = new int[4];
        str = s;
        dfs(temp,0,0);
        return res;
    }
    public void dfs(int[] temp,int num,int numStart){
        if (num==4){
            if (numStart==str.length()){
                StringBuffer sb = new StringBuffer();
                for (int i = 0;i < 4;i++){
                    sb.append(temp[i]);
                    if (i!=3){
                        sb.append(".");
                    }
                }
                res.add(sb.toString());
            }
            return;
        }
        // 没搞完4个ip段，后面就没有了字符了
        if (numStart>=str.length()){
            return;
        }
        // 为前导零的时候，直接这个段就只能是0
        if (str.charAt(numStart)=='0'){
            temp[num] = 0;
            dfs(temp,num+1,numStart+1);
        }
        // 正常的计算
        int a = 0;
        for (int i = numStart;i < str.length();i++){
            // 这里a的计算也值得思考
            a = a*10+(str.charAt(i)-'0');
            if (a>0 && a<=255){
                temp[num] = a;
                dfs(temp,num+1,i+1);
            }else {
                break;
            }
        }

    }
}
