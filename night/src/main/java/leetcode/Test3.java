package leetcode;

import java.util.*;

public class Test3 {
    public static void main(String[] args) {
//        System.out.println(countValidWords(" 62   nvtk0wr4f  8 qt3r! w1ph 1l ,e0d 0n 2v 7c.  n06huu2n9 s9   ui4 nsr!d7olr  q-, vqdo!btpmtmui.bb83lf g .!v9-lg 2fyoykex uy5a 8v whvu8 .y sc5 -0n4 zo pfgju 5u 4 3x,3!wl  fv4   s  aig cf j1 a i  8m5o1  !u n!.1tz87d3 .9    n a3  .xb1p9f  b1i a j8s2 cugf l494cx1! hisceovf3 8d93 sg 4r.f1z9w   4- cb r97jo hln3s h2 o .  8dx08as7l!mcmc isa49afk i1 fk,s e !1 ln rt2vhu 4ks4zq c w  o- 6  5!.n8ten0 6mk 2k2y3e335,yj  h p3 5 -0  5g1c  tr49, ,qp9 -v p  7p4v110926wwr h x wklq u zo 16. !8  u63n0c l3 yckifu 1cgz t.i   lh w xa l,jt   hpi ng-gvtk8 9 j u9qfcd!2  kyu42v dmv.cst6i5fo rxhw4wvp2 1 okc8!  z aribcam0  cp-zp,!e x  agj-gb3 !om3934 k vnuo056h g7 t-6j! 8w8fncebuj-lq    inzqhw v39,  f e 9. 50 , ru3r  mbuab  6  wz dw79.av2xp . gbmy gc s6pi pra4fo9fwq k   j-ppy -3vpf   o k4hy3 -!..5s ,2 k5 j p38dtd   !i   b!fgj,nx qgif "));
        /*String s = " ds dsfs     45";
        String[] s1 = s.split(" +");
        for (String s2 : s1) {
            System.out.println(s2);
        }*/
//        System.out.println("sss".substring(0,0));
//        System.out.println(1^5);
        /*int[] a = {1,2};
        System.out.println(a[0]);*/


    }
    public static int nextBeautifulNumber(int n) {
        String s = String.valueOf(n);
        int a = Integer.parseInt(s.charAt(0)+"");
        int x_len = s.length()-a;
        StringBuffer sb = new StringBuffer();
        for (int i = 0;i < x_len;i++){
            sb.append(x_len);
        }
        if (x_len>a){
            for (int i = 0;i < a;i++){
                sb.append(a);
            }
        }else{
            for (int i = 0;i < a;i++){
                sb.insert(0,a);
            }
        }
        int b = Integer.parseInt(sb.toString());
        if (b<=n){
            a++;
            x_len--;
        }
        StringBuffer sb1 = new StringBuffer();
        sb1.append(a);
        for (int i = 1;i <= x_len;i++){
            if (i==a){
                int j = 1;
                while(j<i){
                    sb1.append(i);
                }
            }else {
                int j = 0;
                while(j<i){
                    sb1.append(i);
                }
            }

            int t = 0;
            while(t<(x_len-i)){
                sb1.append(x_len-i);
            }
            int k = Integer.parseInt(sb1.toString());
            if (k>n){
                return n;
            }
        }
        return 0;
    }
    public static int countValidWords(String sentence) {
        int res = 0;
        String[] split = sentence.trim().split("[ ]+");
        for (String s : split) {
            boolean matches = s.matches("^[a-z]*([a-z]-[a-z]+)?[!\\.,]?$");
            if (matches){
                res++;
            }
        }
        return res;
    }
    public static int countValidWords1(String sentence) {
        String sentence1 = sentence.trim();
        String[] strs = sentence1.split("[ ]+");
        List<Character> chars = new ArrayList<>();
        chars.add('!');
        chars.add('.');
        chars.add(',');
        int res = 0;
        for (String str : strs) {
            if (str.equals("")){
                continue;
            }
            int biaodian_num = 0;
            int lianzifu_num = 0;
            boolean flag = true;
            for (int i = 0;i < str.length();i++){
                char c = str.charAt(i);
                if (Character.isDigit(c)){
                    flag=false;
                    break;
                }
                if (c=='-'){
                    if (i==0 || i==(str.length()-1) || lianzifu_num>0){
                        flag=false;
                        break;
                    }
                    char c1 = str.charAt(i + 1);
                    if (!Character.isLowerCase(c1)){
                        flag=false;
                        break;
                    }
                    lianzifu_num++;
                }
                if (chars.contains(c)){
                    if (biaodian_num>0 || i<(str.length()-1)){
                        flag=false;
                        break;
                    }
                    biaodian_num++;
                }
                if (Character.isUpperCase(c)){
                    flag=false;
                    break;
                }
            }
            if (flag){
                res++;
                System.out.println(str);
            }
        }
        return res;
    }
}
