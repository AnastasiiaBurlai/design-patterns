import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class RegressionTests {

    @Test(groups = {"Regression_suite2"})
    public void regressionTest1(){
        System.out.println("Failing test from Regression_suite_2");
        Assert.fail("Test failed on purpose");
    }

    @Test(groups = {"Regression_suite2"})
    public void regressionTest2(){
        System.out.println("Passing test from Regression_suite2");
        Assert.assertTrue(true);
    }

    @Test(groups = {"Regression_suite3"})
    public void regressionTest3(){
        System.out.println("Failing test from Regression_suite2");
        Assert.fail("Test failed on purpose");
    }

    @Test(groups = {"Regression_suite3"})
    public void regressionTest4(){
        System.out.println("Passing test from Regression_suite3");
        Assert.assertTrue(true);
    }

    @Test(groups = {"Regression_suite3"})
    public void regressionTest5(){
        System.out.println("Passing test from Regression_suite3");
        Assert.assertTrue(true);
    }

    @Test(groups = {"Regression_suite4"})
    public void regressionTest6(){
        System.out.println("Passing test from Regression_suite4");
        Assert.assertTrue(true);
    }

    @Test(groups = {"Regression_suite4"})
    public void regressionTest7(){
        System.out.println("Passing test from Regression_suite4");
        Assert.assertTrue(true);
    }

    @Test(groups = {"Regression_suite4"})
    public void regressionTest8(){
        System.out.println("Failing test from Regression_suite4");
        Assert.fail("Test failed on purpose");
    }

    @Test(groups = {"Regression_suite4"})
    public void regressionTest9(){
        System.out.println("Failing test from Regression_suite4");
        Assert.fail("Test failed on purpose");
    }
}
