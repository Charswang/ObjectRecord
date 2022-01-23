package leetcode;

public class P6_luoji {
    public static void main(String[] args) {
        String s = "PAYPALISHIRING"; // PAHNAPLSIIGYIR
        int numRows = 3;
        System.out.println(convert(s,numRows));
    }
    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int cycleLen = numRows + numRows - 2;
        int length = s.length();
        StringBuffer res = new StringBuffer();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < length; j += cycleLen) {
                res.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && (j + i + cycleLen - 2 * i) < length) {
                    res.append(s.charAt(j + i + cycleLen - 2 * i));
                }
            }
        }
        return res.toString();
    }
}
