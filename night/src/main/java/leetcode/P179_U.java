package leetcode;

import java.util.*;

/**
 * 2022-1-8
 * 每日一题
 */
public class P179_U {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("3");
        list.add("30");
        list.add("34");
        list.add("5");
        list.add("9");
        for (String s : list) {
            System.out.println(s + " ");
        }
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo((o1+o2));
            }
        });
        for (String s : list) {
            System.out.println(s + " ");
        }
    }
    public String largestNumber(int[] nums) {
        String[] temp = new String[nums.length];
        for (int i = 0;i < nums.length;i++){
            temp[i] = String.valueOf(nums[i]);
        }
        // 还是这个新的比较方式。。。
        // 不能是单纯的o2.compareTo(o1)
        // 3 30  --  如果是上面的那样，就变成303了。但实际上应该是330
        Arrays.sort(temp, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo((o1+o2));
            }
        });
        StringBuffer sb = new StringBuffer("");
        for (String s : temp) {
            sb.append(s);
        }
        return sb.toString().charAt(0)=='0'?"0":sb.toString();
    }
}
