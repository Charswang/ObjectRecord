package leetcode;



import java.util.ArrayList;
import java.util.List;

/**
 * 字符串相乘[不使用BigInteger类似库或直接将输入转换为整数来处理]
 *
 * @author charswang
 * @since 2021-8-29
 */
public class P43_NI {
    public static void main(String[] args) {
        String num1 = "123456789";
        String num2 = "987654321";
        String multiply = multiply(num1, num2);
        System.out.println(multiply);
    }

    public static String multiply(String num1, String num2) {
        if("0".equals(num1)||"0".equals(num2)){
            return "0";
        }
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        ArrayList<String> strings = new ArrayList<String>();
        for (int i = chars1.length - 1; i >= 0; i--) {
            int n1 = Integer.parseInt(String.valueOf(chars1[i]));
            int jinwei = 0;
            StringBuffer sb = new StringBuffer("");
            for (int j = chars2.length - 1; j >= 0; j--) {
                int n2 = Integer.parseInt(String.valueOf(chars2[j]));
                int temp = n1 * n2 + jinwei;
                jinwei = temp / 10;
                sb.insert(0, temp % 10);
            }
            if (jinwei > 0) {
                sb.insert(0, jinwei);
            }
            for (int t = chars1.length - 1; t > i; t--) {
                sb.append("0");
            }
            strings.add(sb.toString());
        }
        for (String string : strings) {
            System.out.println(string);
        }
        return compute(strings);
    }
    public static String compute(List<String> list){
        int len = list.get(list.size()-1).length();
        for (int i = 0;i < list.size();i++){
            if (list.get(i).length() < len){
                StringBuffer stringBuffer = new StringBuffer(list.get(i));
                for (int j = list.get(i).length();j<len;j++){
                    stringBuffer.insert(0,"0");
                }
                list.remove(i);
                list.add(i,stringBuffer.toString());
            }
        }
        for (String s : list) {
            System.out.println(s);
        }
        StringBuffer res = new StringBuffer("");
        int jinwei = 0;
        for (int i = len-1;i>=0;i--){
            int sum = 0;
            for (String s : list) {
                int i1 = Integer.parseInt(s.charAt(i) + "");
                sum+=i1;
            }
            sum += jinwei;
            jinwei = sum / 10;
            res.insert(0,sum%10);
        }
        if (jinwei>0){
            res.insert(0,jinwei);
        }
        return res.toString();
    }
}
