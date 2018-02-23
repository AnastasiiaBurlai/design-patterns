package page_objects.decoration;

import org.openqa.selenium.WebElement;

import java.lang.reflect.InvocationTargetException;
import java.text.MessageFormat;

class DecoratorInstanceCreator {

    static Object createInstance(Class<?> decorator, WebElement element) {
        try {
            return decorator.getConstructor(WebElement.class).newInstance(element);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new IllegalArgumentException(MessageFormat.format(
                    "Unable to create instance of {0} decorator with WebElement", decorator));
        }
    }


}
