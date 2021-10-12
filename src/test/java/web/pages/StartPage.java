package web.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import web.elements.Link;

public class StartPage extends BasePage{
    // Конструктор класса
    public StartPage(WebDriver driver) {
        // Вызов родительского конструктора
        super(driver);
        // Инициализация веб элементов
        PageFactory.initElements(driver, this);
    }
    // Логгер
    private Logger logger = LogManager.getLogger(StartPage.class);

    // ***** Веб элементы *****
    // Кнопка "Да" на всплывашке
    @FindBy(xpath = "//a[contains(text(),\"Да\")]")
    private WebElement linkYes;
    //    Ссылка на "ТВ и мультимедиа"
    @FindBy(xpath =  "//a[contains(text(),'ТВ и мультимедиа')]")
    private WebElement linkTvAndMultimedia;
    //    Ссылка на "Телевизоры"
    @FindBy(xpath = "(//a[contains(text(), 'Телевизоры')])[position()='2']")
    private WebElement linkTv;

    // ***** Получение обернутых веб элементов *****
    // Кнопка "Да" на всплывашке
    public Link linkYes() {
        return new Link(linkYes);
    }
    //    Ссылка на "ТВ и мультимедиа"
    public Link linkTvAndMultimedia() {
        return new Link(linkTvAndMultimedia);
    }

    //    Ссылка на "Телевизоры"
    public Link linkTv() {
        return new Link(linkTv);
    }
}
