import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class SmokeTests {

    @Test(groups = {"Smoke_feature1"})
    public void smokeTest1(){
        System.out.println("Passing test from Smoke_feature1");
        Assert.assertTrue(true);
    }

    @Test(groups = {"Smoke_feature2"})
    public void smokeTest2(){
        System.out.println("Passing test from Smoke_feature2");
        Assert.assertTrue(true);
    }

    @Test(groups = {"Smoke_feature2"})
    public void smokeTest3(){
        System.out.println("Failing test from Smoke_feature2");
        Assert.fail("Test failed on purpose");
    }

    @Test(groups = {"Smoke_feature3"})
    public void smokeTest4(){
        System.out.println("Passing test from Smoke_feature3");
        Assert.assertTrue(true);
    }

    @Test(groups = {"Smoke_feature3"})
    public void smokeTest5(){
        System.out.println("Failing test from Smoke_feature3");
        Assert.fail("Test failed on purpose");
    }

    @Test(groups = {"Smoke_feature3"})
    public void smokeTest6(){
        System.out.println("Failing test from Smoke_feature3");
        Assert.fail("Test failed on purpose");
    }
}
