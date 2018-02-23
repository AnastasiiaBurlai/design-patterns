package elements.menu;

import elements.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.text.MessageFormat;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

public class MenuWithBlocks extends BaseElement {
    public MenuWithBlocks(WebElement webElement) {
        super(webElement);
    }

    public List<Block> getMenuBlocks(){
        List<WebElement> list = webElement.findElements(By.xpath(".//nav"));
        return list.stream().map(Block::new).collect(Collectors.toList());
    }

    public Block getMenuBlock(String text){
        Optional<Block> blockToFind = getMenuBlocks().stream().filter(block -> block.getText().equals(text)).findFirst();
        if(blockToFind.isPresent()){
            return blockToFind.get();
        }
        throw new NoSuchElementException(MessageFormat.format("Menu block with text '{0}' is not found", text));
    }
}
