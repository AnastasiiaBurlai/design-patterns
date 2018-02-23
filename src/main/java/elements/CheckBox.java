package elements;

import org.openqa.selenium.*;

public class CheckBox extends BaseElement {

    public CheckBox(WebElement rootElement){
        super(rootElement);
    }

    private BaseElement getCheckbox(){
       return new BaseElement(webElement.findElement(By.xpath(".//input")));
    }

    private BaseElement getLabel(){
        return new BaseElement(webElement.findElement(By.xpath(".//*[contains(@class, 'label')]")));
    }

    public void check(){
        if(!isChecked()) getCheckbox().getParent().click();
    }

    public void uncheck(){
        if(isChecked()) getCheckbox().getParent().click();
    }

    public boolean isChecked(){
        return getCheckbox().getAttribute("aria-checked").equals("true");
    }

    public String getLabelText(){
       return getLabel().getText();
    }
}
