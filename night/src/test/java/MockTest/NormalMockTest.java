package MockTest;

import MockTest.NormalMock;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.File;

@RunWith(PowerMockRunner.class)
// mock方法内部有new出来对象的话，要将该类加入到PrepareFotTest中【fileDemoWithNewTest】
@PrepareForTest(NormalMock.class)
public class NormalMockTest {
    @Test
    public void fileDemoTest() {
        // 创建mock模拟对象
        File mock = PowerMockito.mock(File.class);
        // 当执行mock.exists()函数时，返回true
        PowerMockito.when(mock.exists()).thenReturn(true);
        // 创建对象执行方法
        NormalMock fileDemo = new NormalMock();
        // 验证对错
        Assert.assertTrue(fileDemo.fileDemo(mock));
    }

    @Test
    public void fileDemoWithNewTest() {
        File mock = PowerMockito.mock(File.class);
        try {
            PowerMockito.whenNew(File.class).withArguments("xxx").thenReturn(mock);
            PowerMockito.when(mock.exists()).thenReturn(true);
            NormalMock normalMock = new NormalMock();
            Assert.assertTrue(normalMock.fileDemoWithNew("xxx"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}