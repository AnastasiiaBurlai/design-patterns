package page_objects.decoration;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.openqa.selenium.support.pagefactory.ElementLocator;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.List;

import static page_objects.decoration.DecoratorInstanceCreator.createInstance;

public class FieldDecorator extends DefaultFieldDecorator {

    public FieldDecorator(SearchContext searchContext) {
        super(new DefaultElementLocatorFactory(searchContext));
    }

    @Override
    public Object decorate(ClassLoader loader, Field field) {
        Class<?> decorator = getDecorator(field);
        if (decorator != null) {
            ElementLocator locator = factory.createLocator(field);
            if (locator == null) {
                return null;
            }
            if (List.class.isAssignableFrom(field.getType())) {
                InvocationHandler handler = new LocatingDecoratedElementListHandler(locator, decorator);
                return Proxy.newProxyInstance(loader, new Class[] {List.class}, handler);
            }
            WebElement proxy = proxyForLocator(loader, locator);
            return createInstance(decorator, proxy);
        }
        return super.decorate(loader, field);
    }

    private Class getDecorator(Field field) {
        Class<?> fieldType = field.getType();
        //Check if field is list of decorated elements
        if (List.class.isAssignableFrom(fieldType)) {
            if (Arrays.stream(field.getAnnotations()).noneMatch(a -> a.annotationType().equals(FindBy.class)
                    || a.annotationType().equals(FindBys.class))) {
                return null;
            }
            Type genericType = field.getGenericType();
            if (!(genericType instanceof ParameterizedType)) {
                return null;
            }
            fieldType = (Class<?>)((ParameterizedType) genericType).getActualTypeArguments()[0];
        }
        //Return class of concrete decorator if it has required constructor
        try {
            if (fieldType.getConstructor(WebElement.class) != null) {
                return fieldType;
            }
        } catch (NoSuchMethodException ignored) {
        }
        return null;
    }
}