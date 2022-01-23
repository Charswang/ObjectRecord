package MockTest;

import MockTest.NormalMockPrivate;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(NormalMockPrivate.class)
public class NormalMockPrivateTest {
    /**
     * 遇到private方法好像只能先调用一个public，然后在public中在调用private方法。
     * 因为使用assert时，是找不到private方法的。
     * @throws Exception
     */
    @Test
    public void mockPrivateTest() throws Exception {
        NormalMockPrivate mock = PowerMockito.mock(NormalMockPrivate.class);
        PowerMockito.when(mock.mockPublicMethod()).thenCallRealMethod();
        // 模拟内部方法
        PowerMockito.when(mock,"mockPrivateMethod").thenReturn(true);
        Assert.assertTrue(mock.mockPublicMethod());
    }
}