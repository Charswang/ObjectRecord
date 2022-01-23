package MockTest;

import MockTest.NormalMockSystem;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(NormalMockSystem.class)
public class NormalMockSystemTest {

    /**
     * 要mock那个类的方法，就PowerMockito.mock(xx.class)哪个类
     * 否则，直接创建即可；
     */
    @Test
    public void mockSystemMethod() {
//        MockTest.NormalMockSystem mock = PowerMockito.mock(MockTest.NormalMockSystem.class);
        NormalMockSystem normalMockSystem = new NormalMockSystem();
        PowerMockito.mockStatic(System.class); // Mock模拟系统类的方法
        PowerMockito.when(System.getProperty("aaa")).thenReturn("bbb");
        Assert.assertEquals("bbb",normalMockSystem.mockSystem("aaa"));
    }
}