package MockTest;

public class NormalMockStatic_Final {
    /**
     * 在Mock Static method的时候，含静态方法的类需要写到@PrepareForTest注解里面
     * @return
     */
    public static boolean isStaticAlive(){
        return false;
    }

    public final boolean isFinalAlive(){
        return false;
    }
}
class Pojo{
    /**
     * 待测试方法,mock 这个类[MockTest.NormalMockStatic_Final]的方法，所以要mock创建这个对象；
     * @return
     */
    public boolean callStaticMethod(){
        return NormalMockStatic_Final.isStaticAlive();
    }
    public boolean callFinalMethod(NormalMockStatic_Final mockStatic_final){
        return mockStatic_final.isFinalAlive();
    }
}
