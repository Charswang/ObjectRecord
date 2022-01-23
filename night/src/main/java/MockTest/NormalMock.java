package MockTest;

import java.io.File;

public class NormalMock {
    /**
     * 没有new对象，不需要再测试类前加入@PrepareForTest(MockTest.NormalMock.class)
     * @param file
     * @return
     */
    public boolean fileDemo(File file){
        return file.exists();
    }

    /**
     * 待测试方法
     * 方法内部有new对象，则需要再测试类前面加上@PrepareForTest(MockTest.NormalMock.class)
     * @param path
     * @return
     */
    public boolean fileDemoWithNew(String path){
        File file = new File(path);
        return file.exists();
    }
}
