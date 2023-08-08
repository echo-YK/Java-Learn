package AnnotationCodes;

/**
 * @Description
 * @Author Beta
 * @Date 2023/8/8 22:29
 **/
public class Sample {

    @MyTest
    public static void m1() {
    }

    /**
     * 没有注解，不会在RunTest中被执行
     */
    public static void m2() {
    }

    @MyTest
    public static void m3() {
        throw new RuntimeException("Boom");
    }


    public static void m4() {
    }

    /**
     * 实例方法，注解无法生效
     */
    @MyTest
    public void m5() {
    }

    public static void m6() {
    }

    @MyTest
    public static void m7() {
        throw new RuntimeException("Crash");
    }

    public static void m8() {
    }

}
