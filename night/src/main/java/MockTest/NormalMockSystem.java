package MockTest;

public class NormalMockSystem {
    public String mockSystem(String string){
        // mock系统类的方法
        return System.getProperty(string);
    }
}
