package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 2021-10-11
 * 每日一题
 */
public class P273 {
    public static void main(String[] args) {
        System.out.println(numberToWords(1000000));
    }
    public static String numberToWords(int num) {
        if (num==0){
            return "Zero";
        }
        StringBuffer res = new StringBuffer();
        int flag = 1;//指定级别billion、million等级别
        // 做个map放置级别
        Map<Integer,String> map = new HashMap<>();
        map.put(1," ");
        map.put(2,"Thousand ");
        map.put(3,"Million ");
        map.put(4,"Billion ");
        map.put(5,"trillion ");
        while (num>0){
            StringBuffer t = new StringBuffer();
            int temp = num % 1000;
            // 每3个数说明一次，并指定时级别；
            if (!" ".equals(sanwei(temp))){
                t.append(sanwei(temp)+map.get(flag));
            }
            res.insert(0,t);
            num = num / 1000;
            flag++;
        }
        return res.toString().trim();
    }
    public static String sanwei(int temp){
        String[] gewei = {"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
        String[] shiji = {"Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
        String[] jishi = {"","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
        StringBuffer sb = new StringBuffer();
        int bai = temp / 100;
        temp = temp % 100;
        int shi = temp / 10;
        temp = temp % 10;
        int ge = temp % 10;
        if (bai>0){
            sb.append(gewei[bai] + " Hundred ");
        }
        if (shi==1){
            sb.append(shiji[ge]);
        }else if (shi==0){
            sb.append(gewei[ge]);
        }else {
            sb.append(jishi[shi] + " " + gewei[ge]);
        }
        return sb.toString().trim()+" ";
    }
}
