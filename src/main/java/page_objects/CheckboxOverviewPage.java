package page_objects;

import elements.CheckBox;
import org.openqa.selenium.support.FindBy;
import page_objects.base.ControlPage;
import page_objects.base.Page;

import static utils.TestProperties.getBaseUrl;

;

public class CheckboxOverviewPage extends ControlPage {

    public CheckboxOverviewPage(){
        super(getBaseUrl() + "/checkbox/overview");
    }

    @FindBy(css = ".mat-checkbox")
    public CheckBox checkbox;
}