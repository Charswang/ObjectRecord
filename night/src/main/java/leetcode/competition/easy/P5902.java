package leetcode.competition.easy;

import java.util.ArrayList;
import java.util.List;

public class P5902 {
    public boolean areNumbersAscending(String s) {
        String[] s1 = s.split(" ");
        int temp = -1;
        for (String s2 : s1) {
            if (Character.isDigit(s2.charAt(0))){
                if (Integer.parseInt(s2)<=temp){
                    return false;
                }
                temp = Integer.parseInt(s2);
            }
        }
        return true;
    }
}
