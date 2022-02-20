package leetcode;

import java.util.Arrays;

/**
 * 2022-2-20
 */
public class P383 {
    public boolean canConstruct2(String ransomNote, String magazine) {
        int[] temp = new int[26];
        for (int i = 0;i < magazine.length();i++){
            temp[magazine.charAt(i)-'a']++;
        }
        for (int i = 0;i < ransomNote.length();i++){
            if (temp[ransomNote.charAt(i)-'a']<=0){
                return false;
            }
            temp[ransomNote.charAt(i)-'a']--;
        }
        return true;
    }
    public boolean canConstruct(String ransomNote, String magazine) {
        char[] c1 = ransomNote.toCharArray();
        char[] c2 = magazine.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        int i = 0;
        int j = 0;
        while (i<c1.length && j<c2.length){
            if (c1[i]==c2[j]){
                i++;
                j++;
            }else if (c1[i]>c2[j]){
                j++;
            }else {
                return false;
            }
        }
        if (i<c1.length){
            return false;
        }
        return true;
    }
}
