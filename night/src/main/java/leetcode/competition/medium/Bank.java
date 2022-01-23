package leetcode.competition.medium;

public class Bank {
    long[] balance;
    public Bank(long[] balance) {
        this.balance = balance;
    }

    public boolean transfer(int account1, int account2, long money) {
        if(money<0){
            return false;
        }
        int len = balance.length;
        if ((account1>0&&account1<=len) && (account2>0&&account2<=len)){
            if (balance[account1-1]>=money){
                balance[account1-1] = balance[account1-1] - money;
                balance[account2-1] = balance[account2-1] + money;
                return true;
            }
        }
        return false;
    }

    public boolean deposit(int account, long money) {
        if(money<0){
            return false;
        }
        int len = balance.length;
        if (account>0&&account<=len){
            balance[account-1] = balance[account-1] + money;
            return true;
        }
        return false;
    }

    public boolean withdraw(int account, long money) {
        if(money<0){
            return false;
        }
        int len = balance.length;
        if (account>0&&account<=len){
            if (balance[account-1]>=money){
                balance[account-1] = balance[account-1] - money;
                return true;
            }
        }
        return false;
    }
}
