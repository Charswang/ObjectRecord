package leetcode;

import java.util.*;

/**
 * N皇后问题
 * 分三种情况一种是不在前面皇后所在的列、一种是不在行号+列号=i的位置、一种是不在行号-列号=i的位置
 * 。。。。
 * 。。。。
 * 。。。。
 * 。。。。
 */
public class P51 {
    private static List<List<String>> result = new ArrayList<List<String>>();
    public static void main(String[] args) {
        int n = 1;
        Set<Integer> Columns = new HashSet<Integer>();
        Set<Integer> fanduijiao = new HashSet<Integer>();
        Set<Integer> zhengduijiao = new HashSet<Integer>();
        int[] queens = new int[n];
        Arrays.fill(queens,-1); // 将每行皇后所在列置为-1
        dfs(n,queens,0,Columns,fanduijiao,zhengduijiao);
        for (List<String> strings : result) {
            for (String string : strings) {
                System.out.print(string);
            }
            System.out.println();
        }
    }
    public static void dfs(int n,int[] queens,int num,Set<Integer> Columns,Set<Integer> fanduijiao,Set<Integer> zhengduijiao){
        if (num==n){
            List<String> strings = buildQueen(queens, n);
            result.add(strings);
            return;
        }else {
            for (int i = 0;i < n;i++){
                if (Columns.contains(i)){
                    continue;
                }
                if (fanduijiao.contains(i+num)){
                    continue;
                }
                if (zhengduijiao.contains(num-i)){
                    continue;
                }
                Columns.add(i);
                fanduijiao.add(i+num);
                zhengduijiao.add(num-i);
                queens[num] = i;
                dfs(n,queens,num+1,Columns,fanduijiao,zhengduijiao);
                Columns.remove(i);
                fanduijiao.remove(i+num);
                zhengduijiao.remove(num-i);
                queens[num] = -1;
            }
        }

    }
    public static List<String> buildQueen(int[] queens,int n){
        List<String> ll = new ArrayList<String>();
        for (int i = 0;i<n;i++){
            char[] chars = new char[n];
            Arrays.fill(chars,'.');
            chars[queens[i]] = 'Q';
            ll.add(new String(chars));
        }
        return ll;
    }
}
