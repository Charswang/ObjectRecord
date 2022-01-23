package leetcode;

/**
 * 2021-10-15
 * 每日一题
 */
public class P38 {
    public static void main(String[] args) {
        for (int i = 1;i < 20;i++){
            System.out.println(countAndSay(i));
        }
//        System.out.println(countAndSay(4));
    }
    public static String countAndSay(int n) {
        String docs = "1";
        for (int i = 1;i<n;i++){
            docs = getDocs(docs);
        }
        return docs;
    }
    public static String getDocs(String s){
        char c = s.charAt(0);
        int count = 0;
        StringBuffer res = new StringBuffer();
        int i = 0;
        while(i<s.length()){
            if (s.charAt(i)==c){
                count++;
                i++;
            }else{
                res.append(count+""+c);
                count=0;
                c = s.charAt(i);
            }
        }
        if (count>0){
            res.append(count+""+c);
        }
        return res.toString();
    }
}
