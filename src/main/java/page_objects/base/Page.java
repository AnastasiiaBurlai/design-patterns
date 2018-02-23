package page_objects.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import page_objects.decoration.FieldDecorator;

import static org.testng.AssertJUnit.assertEquals;
import static utils.TestProperties.getBaseUrl;

public abstract class Page {

    protected String url;
    private static WebDriver driver;
    protected Actions actions;

    public static void init(WebDriver initDriver){
        driver = initDriver;
    }

    protected Page(){
        this(getBaseUrl());
    }

    protected Page(String url){
        if(driver == null)
            throw new RuntimeException("Page was not initialized with driver instance. Use Page.init(WebDriver driver).");
        this.url = url;
        PageFactory.initElements(new FieldDecorator(driver), this);
        actions = new Actions(driver);
    }

    public void open(){
        driver.navigate().to(url);
    }

    public void checkOpened(){
       assertEquals(driver.getCurrentUrl(), url);
    }

    public void goBack(){
        driver.navigate().back();
    }
}
