package page_objects.base;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page_objects.decoration.FieldDecorator;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;
import static utils.TestProperties.getBaseUrl;

public abstract class Page {

    protected String url;
    private static DriverFactory driverFactory = new DriverFactory();
    protected Actions actions;

    protected Page(){
        this(getBaseUrl());
    }

    protected Page(String url){
        this.url = url;
        PageFactory.initElements(new FieldDecorator(driverFactory.getDriver()), this);
        actions = new Actions(driverFactory.getDriver());
    }

    public void open(){
        driverFactory.getDriver().navigate().to(url);
    }

    public void checkOpened(){
       assertEquals(driverFactory.getDriver().getCurrentUrl(), url);
    }

    public void goBack(){
        driverFactory.getDriver().navigate().back();
    }

    public void waitLoading() {
        try {
            WebDriverWait wait = new WebDriverWait(driverFactory.getDriver(), 5);
            driverFactory.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[text()='Loading document...']")));
        }finally {
            driverFactory.setDefaultTimeouts();
        }
    }

    public static void dispose(){
        driverFactory.close();
    }
}
