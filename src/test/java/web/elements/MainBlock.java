package web.elements;

import web.helpers.JavaScriptHelper;
import org.openqa.selenium.WebElement;

// Класс "Главный блок"
public class MainBlock extends BaseElement {
    // Конструктор
    public MainBlock(WebElement webElement) {
        super(webElement);
    }

    // Скрытие блока
    public void hide() {
        JavaScriptHelper.displayNone(webElement);
    }
}