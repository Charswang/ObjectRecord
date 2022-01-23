package leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

public class P576NotFinishTest {

    @Test
    public void shouldOutputRes() {
        P576_NotFinish p576NotFinish = new P576_NotFinish();
        int m = 2;
        int n = 2;
        int maxMove = 2;
        int startRow = 0;
        int startColumn = 0;
        int paths = p576NotFinish.findPaths(m, n, maxMove, startRow, startColumn);
        Assert.assertThat(6,is(paths));
    }
}