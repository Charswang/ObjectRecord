package leetcode;

import org.junit.Assert;
import org.junit.Test;

public class P678NFINISHEDTest {
    @Test
    public void shouldOutputRightResult() {
        P678_UNFINISHED p678NFINISHED = new P678_UNFINISHED();
        boolean b = p678NFINISHED.checkValidString("((((()(()()()*()(((((*)()*(**(())))))(())()())(((())())())))))))(((((())*)))()))(()((*()*(*)))(*)()");
        Assert.assertTrue(b);
    }
}