package page_objects.base;

import elements.menu.MenuWithBlocks;
import elements.menu.Menu;
import org.openqa.selenium.support.FindBy;

public abstract class BasePage extends Page{

    protected BasePage(String url) {
        super(url);
    }

    @FindBy(css = ".docs-navbar-header")
    public Menu header;

    @FindBy(css = ".docs-component-viewer-nav")
    public MenuWithBlocks menu;
}
