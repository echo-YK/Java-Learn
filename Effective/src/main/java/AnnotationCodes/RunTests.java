package AnnotationCodes;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Description
 * @Author Beta
 * @Date 2023/8/8 22:33
 **/
public class RunTests {
    public static void main(String[] args) throws ClassNotFoundException {
        int tests = 0;
        int pass = 0;
        Class<?> testClass = Class.forName("AnnotationCodes.Sample");
        for (Method m : testClass.getDeclaredMethods()) {
            if (m.isAnnotationPresent(MyTest.class)) {
                ++tests;
                try {
                    m.invoke(null);
                    ++pass;
                } catch (InvocationTargetException e) {
                    Throwable exc = e.getCause();
                    System.out.println(m + "failed: " + exc);
                } catch (Exception e) {
                    System.out.println("Invalid @Test: " + m);
                }
            }
        }
        System.out.printf("Passed: %d, Failed: %d%n", pass, tests - pass);
    }
}
