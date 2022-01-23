package leetcode;

/**
 * 2022-1-2
 */
public class P5967 {
    public boolean checkString(String s) {
        int bIndex = s.indexOf('b');
        if (bIndex==-1){
            return true;
        }
        String substring = s.substring(bIndex);
        if (substring.indexOf('a')!=-1){
            return false;
        }
        return true;
    }
}
