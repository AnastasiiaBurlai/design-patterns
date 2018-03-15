import org.testng.annotations.Test;
import page_objects.CheckboxOverviewPage;
import page_objects.FormControlsPage;

import static org.testng.Assert.*;

public class FormControlsTest extends BaseTest {

    @Test
    public void verifyAngularCheckBox(){
        FormControlsPage formControlsPage = new FormControlsPage();
        formControlsPage.open();
        formControlsPage.checkOpened();
        String formControlsMenuBlock = "Form Controls";
        assertFalse(formControlsPage.menu.getMenuBlock(formControlsMenuBlock).isExpanded());

        formControlsPage.selectCard("Checkbox");
        CheckboxOverviewPage checkboxOverviewPage = new CheckboxOverviewPage();
        checkboxOverviewPage.checkOpened();
        assertEquals(checkboxOverviewPage.tabMenu.getTextItems(), new String[] {"OVERVIEW", "API", "EXAMPLES"});
        assertTrue(formControlsPage.menu.getMenuBlock(formControlsMenuBlock).isExpanded());

        assertFalse(checkboxOverviewPage.checkbox.isChecked());
        checkboxOverviewPage.checkbox.check();
        assertTrue(checkboxOverviewPage.checkbox.isChecked());
        assertEquals(checkboxOverviewPage.checkbox.getLabelText(), "Check me!");

        checkboxOverviewPage.viewSourceButton.click();
        checkboxOverviewPage.waitLoading();
        //this is WebElement - to check that both custom elements and selenium WebElement decoration works
        assertTrue(checkboxOverviewPage.source.isDisplayed());
        assertEquals(checkboxOverviewPage.source.getText(), "<mat-checkbox>Check me!</mat-checkbox>");

        checkboxOverviewPage.goBack();
        formControlsPage.checkOpened();
    }
}