import driver.DriverFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import page_objects.base.Page;

public class BaseTest {

    @AfterTest
    public void tearDown(){
        Page.dispose();
    }
}
