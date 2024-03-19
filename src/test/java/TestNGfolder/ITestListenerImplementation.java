package TestNGfolder;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ITestListenerImplementation implements ITestListener {
    public void onTestFailure(ITestResult result){
        System.out.println("Test has failed and this message comes from ITestListenerImplementation class");
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("Test has passed and this message comes from ITestListenerImplementation class");
    }
}
