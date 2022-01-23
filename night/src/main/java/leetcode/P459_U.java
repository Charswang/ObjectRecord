package leetcode;

public class P459_U {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        // if (len%2==0){
        //     return s.substring(0,len/2).equals(s.substring(len/2,len));
        // }
        // if(len==1){
        //     return false;
        // }
        int q = len/2;
        for (int i = q;i>0;i--){
            if (len%i==0){
                boolean flag = true;
                String temp = s.substring(0,i);
                for (int b = i;b<len;b+=i){
                    if (!temp.equals(s.substring(b,b+i))){
                        flag=false;
                    }
                }
                if (flag){
                    return true;
                }
            }
        }
        return false;
    }
}
