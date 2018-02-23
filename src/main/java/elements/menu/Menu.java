package elements.menu;

import elements.BaseElement;
import elements.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

public class Menu extends BaseElement {

    public Menu(WebElement element) {
        super(element);
    }

    public Button[] getItems(){
        List<WebElement> list = webElement.findElements(By.xpath(".//a"));
        return list.stream().map(Button::new).toArray(Button[]::new);
    }

    public String[] getTextItems(){
       return Arrays.stream(getItems()).map(item -> item.getText()).toArray(String[]::new);
    }
}
