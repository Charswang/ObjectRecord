package leetcode;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class Test {
    private static boolean flag=false;
    public static void main(String[] args) {
        // 第一行输入的是n个物品和总重量m
        // 第二行输入的是这n个物品分别的重量
        // 看这n个重量的物品能否组成m重量
        // eg：7 15 \n 1 4 3 4 5 2 7
        // 0-1背包问题
        /*Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0;i < n;i++){
            nums[i] = sc.nextInt();
        }
        sum(nums,n,m);
        System.out.println(flag);*/

        // 检验括号是否完全匹配
        // 遇到(就入栈，遇到)检查栈是否为空，为空则no，否则，弹出栈，继续往下走
        /*Stack<Character> stack = new Stack<Character>();
        String str = "5.6*(-2*(1+(-3)))";
        boolean flag = true;
        for (int i = 0;i < str.length();i++){
            if (str.charAt(i)=='('){
                stack.push('(');
            }else if (str.charAt(i)==')'){
                if (!stack.isEmpty()){
                    stack.pop();
                }else{
                    System.out.println("NO");
                    flag=false;
                    break;
                }
            }
        }
        if (flag==true){
            if (!stack.isEmpty()){
                System.out.println("NO");
            }else{
                System.out.println("YES");
            }
        }*/

        /*Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = (int)Math.pow(10,String.valueOf(a).length())-1;
        int r = gcd(a,b);
        System.out.println(a/r + "/" + b/r);*/

        /*Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            Set<Integer> set = new HashSet<Integer>();
            int n = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            int i = 1;
            while(x*i<=n || y*i<=n || z*i<=n){
                if (x*i<=n){
                    set.add(x*i);
                }
                if (y*i<=n){
                    set.add(y*i);
                }
                if (z*i<=n){
                    set.add(z*i);
                }
                i++;
            }
            System.out.println(set.size());
            *//*for (Integer integer : set) {
                System.out.println(integer);
            }*//*
        }*/

        // 搞一下螺旋队列还是螺旋数组来着
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int x_tmp = 0;
        int y_tmp = 0;
        int i = 1;
        int sum = 1;
        boolean flag = false;
        if (x_tmp==x && y_tmp==y){
            System.out.println(1);
        }else{
            while(flag==false){
                if (i%2!=0){
                    for (int j = 0;j < i;j++){
                        x_tmp++;
                        sum++;
                        if (x_tmp==x && y_tmp==y){
                            flag=true;
                            System.out.println(sum);
                            break;
                        }
                    }
                    for (int j = 0;j < i;j++){
                        y_tmp++;
                        sum++;
                        if (x_tmp==x && y_tmp==y){
                            flag=true;
                            System.out.println(sum);
                            break;
                        }
                    }
                }else{
                    for (int j = 0;j < i;j++){
                        x_tmp--;
                        sum++;
                        if (x_tmp==x && y_tmp==y){
                            flag=true;
                            System.out.println(sum);
                            break;
                        }
                    }
                    for (int j = 0;j < i;j++){
                        y_tmp--;
                        sum++;
                        if (x_tmp==x && y_tmp==y){
                            flag=true;
                            System.out.println(sum);
                            break;
                        }
                    }
                }
                i++;
            }
        }



    }
    public static int gcd(int a,int b){
        return b==0?a:gcd(b,a%b);
    }
    public static void sum(int[] nums,int n,int m){
        if (n<0){
            return;
        }else if (nums[n-1]==m){
            flag=true;
        }else{
            sum(nums,n-1,m-nums[n-1]);
            sum(nums,n-1,m);
        }
    }
}
