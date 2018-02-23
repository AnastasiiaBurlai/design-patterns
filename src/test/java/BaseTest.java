import driver.DriverFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import page_objects.base.Page;

public class BaseTest {

    private DriverFactory driverFactory;

    @BeforeTest
    public void setUp(){
        driverFactory = new DriverFactory();
        Page.init(driverFactory.getDriver());
    }

    @AfterTest
    public void tearDown(){
        driverFactory.closeAll();
        DriverFactory.killAllRunDrivers();
    }
}
