package elements.menu;

import elements.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Block extends Menu {
    public Block(WebElement element) {
        super(element);
    }

    private Button getButton(){
        return new Button(webElement.findElement(By.xpath(".//button")));
    }

    private Button getExpander(){
        return new Button(webElement.findElement(By.xpath(".//mat-icon")));
    }

    public boolean isExpanded(){
        return getButton().getAttribute("aria-expanded").equals("true");
    }

    public void expand(){
        if(!isExpanded()) getExpander().click();
    }

    public void collapse(){
        if(isExpanded()) getExpander().click();
    }

    public String getText(){
        return getButton().getText().replace(getExpander().getText(), "").trim();
    }
}
