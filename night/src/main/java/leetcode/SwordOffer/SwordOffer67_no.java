package leetcode.SwordOffer;

/**
 * 2022-7-4
 */
public class SwordOffer67_no {
    public static void main(String[] args) {

    }

    public static int strToInt(String str) {
        String trim = str.trim();
        if (trim.length() == 0) {
            return 0;
        }
        int i = 0; // 标记数字从哪一位开始
        int sign = 1; // 标记正负数
        if (trim.charAt(0) == '-') {
            i = 1;
            sign = -1;
        } else if (trim.charAt(0) == '+') {
            i = 1;
        }
        int res = 0;
        int bnry = Integer.MAX_VALUE / 10; // ！！！！！这里的关键
        while (i<trim.length()){
            if (trim.charAt(i)<'0' || trim.charAt(i)>'9'){
                break;
            }
            // 如果加上当前索引上的数字，超出了Integer的最大值，就返回Integer的最大值，然后加上正负标记。
            if (res>bnry || (res==bnry&&trim.charAt(i)>'7')){
                // >7很妙，因为Integer的正数最大值的最后一位就是7【-2147483648~2147483647】
                return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
            res = res * 10 + (trim.charAt(i)-'0');
            i++;
        }
        return res * sign;
    }

    // 自己写的一个错误的
    /*public static int strToInt(String str) {
        String trim = str.trim();
        if (trim.length()==0){
            return 0;
        }
        char a = trim.charAt(0);
        if (!Character.isDigit(a) && a != '+' && a != '-') {
            return 0;
        }
        StringBuffer sb = new StringBuffer();
        sb.append(a);
        for (int i = 1; i < trim.length(); i++) {
            if (!Character.isDigit(trim.charAt(i))) {
                break;
            }
            sb.append(trim.charAt(i));
        }
        if ((a=='+' || a=='-') && sb.length()==1){
            return 0;
        }
        long l = Long.parseLong(sb.toString());
        if (l < Integer.MIN_VALUE || l > Integer.MAX_VALUE) {
            if (l<0){
                return Integer.MIN_VALUE;
            }
            return Integer.MAX_VALUE;
        }
        return (int) l;
    }*/
}
