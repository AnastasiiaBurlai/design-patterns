package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Card extends BaseElement {

    public Card(WebElement webElement) {
        super(webElement);
    }

    public String getTitle(){
        return webElement.findElement(By.xpath(".//mat-card-title")).getText();
    }
}