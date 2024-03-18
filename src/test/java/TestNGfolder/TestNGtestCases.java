package TestNGfolder;

import org.testng.annotations.Test;

public class TestNGtestCases {
    @Test (groups = {"regression"})
    void test1(){
        System.out.println("test the TestNG");
    }
}
