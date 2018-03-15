package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaDriverService;
import org.openqa.selenium.remote.BrowserType;
import utils.TestProperties;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class DriverFactory {

    public static final String DRIVERS_PATH = new File("").getAbsolutePath() + "/src/test/resources/drivers/";

    private WebDriver driver;

    public WebDriver getDriver() {
        if (driver != null) return driver;

        switch (TestProperties.getBrowserType()) {
            case BrowserType.FIREFOX:
                driver = initFirefox();
                break;
            case BrowserType.IE:
                driver = initInternetExplorer();
                break;
            default:
                driver = initChrome();
                break;
        }

        driver.manage().window().maximize();
        setDefaultTimeouts();
        return driver;
    }

    public void setDefaultTimeouts() {
        if(driver != null) {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
            driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        }
    }

    private WebDriver initChrome() {
        System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY,
                Paths.get(DRIVERS_PATH + "chromedriver.exe").toString());
        return new ChromeDriver();
    }

    private WebDriver initFirefox() {
        System.setProperty("webdriver.gecko.driver",
                Paths.get(DRIVERS_PATH + "geckodriver.exe").toString());
        return new FirefoxDriver();
    }

    @Deprecated
    //IE does not work, probably require adding some data to the registry
    private WebDriver initInternetExplorer() {
        System.setProperty(InternetExplorerDriverService.IE_DRIVER_EXE_PROPERTY,
                Paths.get(DRIVERS_PATH + "IEDriverServer.exe").toString());
        return new InternetExplorerDriver();
    }

    public void close() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}