package leetcode;

/**
 * 2022-1-4
 *
 * 从1开始的26进制转换问题；
 * 因为一般的进制转换都是从0开始的；所以有个这种题；
 *
 * 从10进制转26进制的时候，每次进行/26的时候，都要-1.。。
 * ？？？没理解
 */
public class P168_UNFINISHED_从1开始的10进制转26进制问题_每次要减1 {
    public String convertToTitle(int columnNumber) {
        StringBuffer sb = new StringBuffer();
        while (columnNumber>0){
            /**
             * 这里/一次都要减去1才可以
             */
            columnNumber--;
            sb.append((char) (columnNumber%26+'A'));
            columnNumber = columnNumber / 26;
        }
        return sb.reverse().toString();
    }
}
