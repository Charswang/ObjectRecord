package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 2021-11-8
 * 每日一题
 */
public class P299 {
    public String getHint(String secret, String guess) {
        // secret = "1807", guess = "7810"  输出: "1A3B"
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0;i < secret.length();i++){
            char c = secret.charAt(i);
            if (map.keySet().contains(c)){
                map.put(c,map.get(c)+1);
            }else{
                map.put(c,1);
            }
        }
        int x = 0;
        int y = 0;
        for (int i = 0;i < secret.length();i++){
            char a = secret.charAt(i);
            char b = guess.charAt(i);
            if (a==b){
                x++;
                map.put(a,map.get(a)-1);
            }
        }
        for (int i = 0;i < secret.length();i++){
            char a = secret.charAt(i);
            char b = guess.charAt(i);
            if (a!=b) {
                if (map.containsKey(b) && map.get(b) > 0) {
                    y++;
                    map.put(b, map.get(b) - 1);
                }
            }
        }
        return x+"A"+y+"B";
    }
}
