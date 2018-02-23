package page_objects;

import elements.CheckBox;
import org.openqa.selenium.support.FindBy;
import page_objects.base.ControlPage;

import static utils.TestProperties.getBaseUrl;

public class CheckboxExamplesPage extends ControlPage {

    protected CheckboxExamplesPage() {
        super(getBaseUrl() + "/checkbox/examples");
    }

    @FindBy(css = "#mat-checkbox-30")
    public CheckBox checkedCheckbox;

    @FindBy(css = "#mat-checkbox-31")
    public CheckBox intermediateCheckbox;

    @FindBy(css = "#mat-checkbox-32")
    public CheckBox disabledCheckbox;

    @FindBy(css = "#mat-checkbox-33")
    public CheckBox resultCheckbox;
}
