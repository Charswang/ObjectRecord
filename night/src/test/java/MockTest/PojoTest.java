package MockTest;

import MockTest.NormalMockStatic_Final;
import MockTest.Pojo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(NormalMockStatic_Final.class)
public class PojoTest {
    @Test
    public void staticTest() {
        PowerMockito.mockStatic(NormalMockStatic_Final.class);
        PowerMockito.when(NormalMockStatic_Final.isStaticAlive()).thenReturn(true);
        Pojo pojo = new Pojo();
        Assert.assertTrue(pojo.callStaticMethod());
    }

    @Test
    public void finalTest() {
        NormalMockStatic_Final mock = PowerMockito.mock(NormalMockStatic_Final.class);
        PowerMockito.when(mock.isFinalAlive()).thenReturn(true);
        Pojo pojo = new Pojo();
        Assert.assertTrue(pojo.callFinalMethod(mock));
    }
}