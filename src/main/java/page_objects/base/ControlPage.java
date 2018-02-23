package page_objects.base;

import elements.menu.Menu;
import org.openqa.selenium.support.FindBy;

public class ControlPage extends BasePage {

    protected ControlPage(String url) {
        super(url);
    }

    @FindBy(css = ".mat-tab-links")
    public Menu tabMenu;
}
