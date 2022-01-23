import leetcode.Test2;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

//@RunWith(PowerMockRunner.class)
public class Test2Test {
    @Test
    public void testName() {
        assertEquals("OK",new Test2().show());
    }

    @Test
    public void testVoid() {
        Test2 mock = PowerMockito.mock(Test2.class);
        Mockito.doNothing().when(mock).testVoid();
    }
}