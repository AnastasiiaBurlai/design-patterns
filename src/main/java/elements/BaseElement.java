package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BaseElement {

    protected WebElement webElement;

    protected BaseElement(WebElement webElement) {
        this.webElement = webElement;
    }

    public void click(){
        webElement.click();
    }

    public String getAttribute(String attribute){
        return webElement.getAttribute(attribute);
    }

    public WebElement getParent(){
        return webElement.findElement(By.xpath(".."));
    }

    public String getText(){
        return webElement.getText();
    }
}
