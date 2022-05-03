package leetcode;

import java.util.*;

/**
 * 2022-5-3
 * 每日一题
 *
 * compareTo的返回值：负数--正序；整数--反序；0--当前顺序不变
 */
public class P937 {
    public String[] reorderLogFiles2(String[] logs) {
        Arrays.sort(logs,(log1, log2)->{
            String[] s1 = log1.split(" ",2); // 只切割一次，数组长度为2
            String[] s2 = log2.split(" ",2);
            boolean b1 = Character.isDigit(s1[1].charAt(0));
            boolean b2 = Character.isDigit(s2[1].charAt(0));
            if(!b1 && !b2){
                boolean flag = s1[1].equals(s2[1]);
                if(flag){
                    return s1[0].compareTo(s2[0]);
                }
                return s1[1].compareTo(s2[1]);
            }
            return b1 ? (b2 ? 0 : 1) : -1; // compareTo的返回值：负数--正序；整数--反序；0--当前顺序不变
        });
        return logs;
    }

    public String[] reorderLogFiles(String[] logs) {
        List<String> charlogs = new ArrayList<>();
        List<String> digitlogs = new ArrayList<>();
        for (String log : logs) {
            if (Character.isLetter(log.charAt(log.length()-1))){
                charlogs.add(log);
            }else {
                digitlogs.add(log);
            }
        }
        Collections.sort(charlogs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1.substring(o1.indexOf(" ") + 1);
                String s2 = o2.substring(o2.indexOf(" ") + 1);
                if (!s1.equals(s2)){
                    return s1.compareTo(s2);
                }
                return o1.substring(0,o1.indexOf(" ")).compareTo(o2.substring(0,o2.indexOf(" ")));
            }
        });
        for (String digitlog : digitlogs) {
            charlogs.add(digitlog);
        }
        return charlogs.toArray(new String[]{});
    }
}
