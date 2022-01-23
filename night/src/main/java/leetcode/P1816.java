package leetcode;

/**
 * 2021-12-6
 * 每日一题
 */
public class P1816 {
    public String truncateSentence(String s, int k) {
        final String[] s1 = s.split(" ");
        StringBuffer sb = new StringBuffer();
        k = Math.min(k,s1.length);
        for (int i = 0;i < k;i++){
            // final String trim1 = s1[0].trim();
            sb.append(s1[i] + " ");
        }
        return sb.toString().trim();
    }
}
