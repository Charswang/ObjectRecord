package leetcode;

/**
 * 2021-9-5
 * 其实还是不太理解这个题目的意思
 *
 * (rand_X-1) * Y + rand_Y    能生成均匀分布/等概率生成的[1,X*Y]之间的数
 *
 * 所以在做限制条件的时候，尽量能够靠近随机数的最大值最好，这样就能少循环几次
 * 对于随机数 randN，只要 K 是 N 的约数（或者说 N 是 K 的整数倍），都可以通过 randN 一步得到 randK：randK = (randN % K) + 1;
 */
public class P470_UNFINISHED {
    public static void main(String[] args) {

    }
    /*public int rand10() {
        int num = (rand7()-1) * 7 + rand7();
        while(num>10){
            num = (rand7()-1) * 7 + rand7();
        }
        return num;
    }*/
    /*public int rand10() {
        while(true){
            int a = rand7();
            int b = rand7();
            int num = (a-1)*7+b;
            if(num<=40){
                return num%10+1;
            }
            // 41-49也是均匀随机生成的，所以可以-40
            a = num-40;//rand9
            b = rand7();//重新生成a之后，b也得重新生成一下；
            num = (a-1)*7+b; // [1,63]
            if(num<=60){
                return num%10+1;
            }

            //61-63也是随机生成的，所以可以-60
            a = num-60;
            b = rand7();
            num = (a-1)*7+b; //[1,21] //尽量让num<=N靠近随机生成的最大数，这样能减少循环次数。更容易命中
            if(num<=20){
                return num%10+1;
            }
        }
    }*/
}
