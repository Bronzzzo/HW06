package web.elements;

import web.helpers.WaitHelper;
import org.openqa.selenium.WebElement;

// Класс "Переключатель"
public class RadioButton extends BaseElement{
    // Конструктор
    public RadioButton(WebElement webElement) {
        super(webElement);
    }

    // Установка переключателя
    public void setSelected(boolean value) {
        // Ожидание кликабельности переключателя
        WaitHelper.clickabilityOfElement(webElement);
        if (value != isSelected()) {
            webElement.click();
        }
    }

    // Проверка, что переключатель установлен
    public boolean isSelected() {
        return webElement.isSelected();
    }
}