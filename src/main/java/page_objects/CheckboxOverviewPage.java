package page_objects;

import elements.Button;
import elements.CheckBox;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page_objects.base.ControlPage;

import static utils.TestProperties.getBaseUrl;

public class CheckboxOverviewPage extends ControlPage {

    public CheckboxOverviewPage(){
        super(getBaseUrl() + "/checkbox/overview");
    }

    @FindBy(css = ".mat-checkbox")
    public CheckBox checkbox;

    @FindBy(xpath = "//button[@aria-describedby='cdk-describedby-message-1']")
    public Button viewSourceButton;

    @FindBy(css = ".docs-example-source doc-viewer")
    public WebElement source;
}