package page_objects;

import elements.Card;
import org.openqa.selenium.support.FindBy;
import page_objects.base.BasePage;
import page_objects.base.Page;

import java.util.List;
import java.util.Optional;

import static utils.TestProperties.getBaseUrl;

public class FormControlsPage extends BasePage {

    public FormControlsPage(){
        super(getBaseUrl() + "/categories/forms");
    }

    @FindBy(css = ".mat-card")
    public List<Card> controlsCards;

    public void selectCard(String title) {
        Optional<Card> searchedCard = controlsCards.stream().filter(card -> card.getTitle().equals(title)).findFirst();
        searchedCard.ifPresent(Card::click);
    }
}