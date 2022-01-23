package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P846__UNFINISHED {
    public static void main(String[] args) {
        int[] hand = {53,78,62,108,83,56,66,110,49,104,117,123,86,131,94,107,84,103,42,127,100,50,55,97,81,93,71,45,63,39,91,87,129,126,84,125,73,95,116,47,106,52,121,54,38,68,69,76,89,90,57,67,86,114,64,87,79,92,115,60,51,105,132,101,59,130,44,85,80,82,48,65,128,102,74,61,40,46,98,111,109,119,72,43,112,120,58,113,77,88,41,118,75,85,124,122,96,83,99,70};
        int groupSize = 50;
        System.out.println(isNStraightHand(hand, groupSize));
    }
    public static boolean isNStraightHand(int[] hand, int groupSize) {
        int len = hand.length;
        if (len % groupSize!=0){
            return false;
        }
        Arrays.sort(hand);
        Map<Integer,Integer> map = new HashMap<>();
        for (int i : hand) {
            map.put(i,map.getOrDefault(i,0)+1);
        }
        for (int i : hand) {
            if (map.get(i)>0){
                for (int j = 0;j < groupSize;j++){
                    if (map.getOrDefault(i+j,0)>0){
                        map.put(i+j,map.get(i+j)-1);
                    }else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
