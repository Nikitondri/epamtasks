package by.zakharanka.task02array.view.manager;

import by.zakharanka.task02array.view.exception.ViewException;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public enum MessageManager {

    EN(ResourceBundle.getBundle("language.ui_en_US", new Locale("en", "EN"))),
    BY(ResourceBundle.getBundle("language.ui_be_BY", new Locale("be", "BY"))),
    RU(ResourceBundle.getBundle("language.ui_ru_RU", new Locale("ru", "RU")));

    private ResourceBundle bundle;
    MessageManager(ResourceBundle bundle) {
        this.bundle = bundle;
    }

    public String getString(String key) {
        return bundle.getString(key);
    }
}
