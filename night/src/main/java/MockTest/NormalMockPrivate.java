package MockTest;

public class NormalMockPrivate {
    public boolean mockPublicMethod(){
        return mockPrivateMethod();
    }
    private boolean mockPrivateMethod(){
        return false;
    }
}
