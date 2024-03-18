package TestNGfolder;

import org.testng.annotations.Test;

public class TestNGxml {

    @Test (groups = {"smoke", "regression"})
    public void method1(){
        System.out.println("Hello from method1");
    }

    @Test (groups = {"smoke"})
    public void method2(){
        System.out.println("Hello from method2");
    }
}
