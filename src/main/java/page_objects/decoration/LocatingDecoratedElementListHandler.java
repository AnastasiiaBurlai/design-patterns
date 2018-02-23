package page_objects.decoration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ElementLocator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static page_objects.decoration.DecoratorInstanceCreator.createInstance;

public class LocatingDecoratedElementListHandler implements InvocationHandler {

    private ElementLocator locator;
    private Class<?> decorator;

    LocatingDecoratedElementListHandler(ElementLocator locator, Class<?> decorator) {
        this.locator = locator;
        this.decorator = decorator;
    }

    public Object invoke(Object object, Method method, Object[] objects) throws Throwable {
        List<WebElement> proxyElements = locator.findElements();
        List<Object> elements = new ArrayList<>();

        for (WebElement element : proxyElements) {
            elements.add(createInstance(decorator, element));
        }
        try {
            return method.invoke(elements, objects);
        } catch (InvocationTargetException e) {
            throw e.getCause();
        }
    }
}
