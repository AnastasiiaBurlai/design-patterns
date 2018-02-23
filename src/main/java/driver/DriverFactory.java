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

    private List<WebDriver> drivers = new ArrayList<>();

    public static void killAllRunDrivers() {
        File driversFolder = new File(DRIVERS_PATH);
        try {
            for (File driver : Objects.requireNonNull(driversFolder.listFiles()))
                Runtime.getRuntime().exec("taskkill /F /IM " + driver.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public WebDriver getDriver() {
        WebDriver driver;

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

        drivers.add(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        return driver;
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

    public void closeAll() {
        for (WebDriver driver : drivers) {
            if (driver != null) {
                driver.quit();
            }
        }
        drivers.clear();
    }
}