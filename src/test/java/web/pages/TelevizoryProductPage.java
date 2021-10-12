package web.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import web.elements.Link;
import web.elements.MainBlock;
import web.elements.Table;
import web.helpers.WaitHelper;

import java.util.Objects;

public class TelevizoryProductPage extends BasePage {
    //логгер
    private Logger logger = LogManager.getLogger(TelevizoryProductPage.class);

    //    конструктор
    public TelevizoryProductPage(WebDriver driver) {

        super(driver);
        // Инициализация веб элементов
        PageFactory.initElements(driver, this);

    }

    // ***** Веб элементы *****
    // Хедер
    @FindBy(xpath = "//nav[@id='header-search']")
    private WebElement mainBlock;

    // Ссылка "Характеристики"
    @FindBy(xpath = "//a[contains(text(),'Характеристики')]")
    private WebElement linkCharacteristics;
    // Таблица "Характеристики"
    @FindBy(xpath = "//table")
    private WebElement tableCharacteristics;
    // Модель
    @FindBy(xpath = "//span[contains(text(),'Модель')]/ancestor::td/following-sibling::td/div")
    private WebElement linkModel;
    @FindBy(xpath = "//span[contains(text(),' Диагональ экрана ')]/ancestor::td/following-sibling::td/div")
    private WebElement linkScreenDiagonalInch;
    @FindBy(xpath = "//span[contains(text(),' Частота обновления экрана ')]/ancestor::td/following-sibling::td/div")
    private WebElement linkScreenRefresh;
    @FindBy(xpath = "//span[contains(text(),'Тип подсветки экрана')]/ancestor::td/following-sibling::td/div")
    private WebElement linkBacklightType;

    // ***** Получение обернутых веб элементов *****
    // 1. Шапка
    public MainBlock mainBlock() {
        return new MainBlock(mainBlock);
    }
    // Ссылка "Характеристики"
    public Link linkCharacteristics() {
        WaitHelper.clickabilityOfElement(linkCharacteristics);
        return new Link(linkCharacteristics);
    }
    // Таблица "Характеристики"
    public Table tableCharacteristics() {
        WaitHelper.visibilityOfElement(tableCharacteristics);
        return new Table(tableCharacteristics);
    }

    public WebElement getLinkModel() {
        return linkModel;
    }

    public WebElement getLinkScreenDiagonalInch() {
        return linkScreenDiagonalInch;
    }

    public WebElement getLinkScreenRefresh() {
        return linkScreenRefresh;
    }

    public WebElement getLinkBacklightType() {
        return linkBacklightType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TelevizoryProductPage that = (TelevizoryProductPage) o;
        return Objects.equals(linkModel, that.linkModel) && Objects.equals(linkScreenDiagonalInch, that.linkScreenDiagonalInch) && Objects.equals(linkScreenRefresh, that.linkScreenRefresh) && Objects.equals(linkBacklightType, that.linkBacklightType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(linkModel, linkScreenDiagonalInch, linkScreenRefresh, linkBacklightType);
    }
}
