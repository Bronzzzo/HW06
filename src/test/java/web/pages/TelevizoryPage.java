package web.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Sleeper;
import web.elements.*;
import web.helpers.WaitHelper;

import java.time.Duration;

public class TelevizoryPage extends BasePage {
    // Логгер
    private Logger logger = LogManager.getLogger(TelevizoryPage.class);

    // ***** Веб элементы *****
    // Шапка
    @FindBy(xpath = "//header")
    private WebElement mainBlock;
    //
//    нижний контейнер сайта
    @FindBy(xpath = "(//div[@class='container'])[2]")
    private WebElement mainСontainerBlock;
    // Фильтры
    // - Фильтр "Производитель"
    @FindBy(xpath = "(//div[@class='ui-list-controls__content'])[2]")
    private WebElement divCompany;
    // - Фильтр "Диагональ экрана (дюйм)"
    @FindBy(xpath = "//span[contains(text(),'Диагональ экрана (дюйм)')]")
    private WebElement accordeonScreenDiagonalInch;
    // - Фильтр "Диагональ экрана (дюйм)" - минимальное значение
    @FindBy(xpath = "(//input[@type='number'])[position()='3']")
    private WebElement inputMinValueScreenDiagonal;
    // - Фильтр "Диагональ экрана (дюйм)" - минимальное значение
    @FindBy(xpath = "(//input[@type='number'])[position()='4']")
    private WebElement inputMaxValueScreenDiagonal;
    //  фильтр Частота обновления экрана (Гц)	120 Гц
    @FindBy(xpath = "//span[contains(text(),'Частота обновления экрана (Гц)')]")
    private WebElement accordeonScreenRefresh;
    // Блок с чекбоксами "Частота обновления экрана"
    @FindBy(xpath = "(//div[@class='ui-list-controls__content'])[position()='2']")
    private WebElement divScreenRefresh;
    //    фильтр Тип подсветки	Direct LED
    @FindBy(xpath = "(//span[contains(text(),'Тип подсветки экрана')])[position()='1']")
    private WebElement accordeonBacklightType;
    //    Блок с чекбоксами "Тип подсветки"
    @FindBy(xpath = "(//div[@class='ui-list-controls__content'])[position()='3']")
    private WebElement divBacklightType;
    // Кнопка "Применить"
    @FindBy(xpath = "//button[contains(text(), 'Применить')]")
    private WebElement buttonApply;
    // Аккордеон "Сортировка"
    @FindBy(xpath = "//span[contains(text(), 'Сортировка:')]/following::a")
    private WebElement accordeonSort;
    // Блок с переключателями "Сортировка"
    @FindBy(xpath = "(//div[@class='top-filter__radio-list ui-radio top-filter__popover'])[1]")
    private WebElement divSort;
    //    телевизоры
//    ссылка на первый продукт
    @FindBy(xpath = "(//a[contains(@class, \"catalog-product__name\")])[1]")
    private WebElement linkFirstProduct;


    // Конструктор класса
    public TelevizoryPage(WebDriver driver) {
        // Вызов родительского конструктора
        super(driver);
        // Инициализация веб элементов
        PageFactory.initElements(driver, this);
    }

    // ***** Получение обернутых веб элементов *****
    // 1. Шапка
    public MainBlock mainBlock() {
        return new MainBlock(mainBlock);
    }

    // Контейнер сайта
    public MainBlock mainContainerBlock() {
        return new MainBlock(mainСontainerBlock);
    }

    // 2. Фильтры
    // Фильтр "Производитель"
    // Чекбокс "Производитель"
    public CheckBox checkBoxCompany(String company) {
        return new CheckBox(findCheckBoxCompany(company));
    }

    // Поиск чекбокса "Производитель"
    private WebElement findCheckBoxCompany(String company) {
        WaitHelper.visibilityOfElement(divCompany);
        return divCompany.findElement(By.xpath("//span[contains(text(), \"" + company + "\")]"));
    }

    // Фильтр "Частота обновления экрана"
    // Аккордеон "Частота обновления экрана"
    public Accordeon accordeonScreenRefresh() {
        return new Accordeon(accordeonScreenRefresh);
    }

    // Чекбокс "Частота обновления экрана"
    public CheckBox checkBoxScreenRefresh(String refreshScreenValue) {
        return new CheckBox(findScreenRefresh(refreshScreenValue));
    }

    // Поиск чекбокса "Частота обновления экрана"
    private WebElement findScreenRefresh(String refreshScreenValue) {
        WaitHelper.visibilityOfElement(divScreenRefresh);
        return divScreenRefresh.findElement(By.xpath("//span[contains(text(), \"" + refreshScreenValue + "\")]"));
    }

    // Фильтр "тип подсветки экрана"
    //Аккордеон "тип подсветки экрана"
    public Accordeon accordeonBacklightType() {
        return new Accordeon(accordeonBacklightType);
    }

    // Чекбокс "тип подсветки экрана"
    public CheckBox checkBoxBacklightType(String backlightType) {
        return new CheckBox(findBacklightType(backlightType));
    }
    // Поиск чекбокса "тип подсветки экрана"
    private WebElement findBacklightType(String backlightType) {
        WaitHelper.visibilityOfElement(divBacklightType);
        return divBacklightType.findElement(By.xpath("//span[contains(text(), \"" + backlightType + "\")]"));
    }

    //  Фильтр "Выбор диагонали экрана"
    //  Аккордеон "Выбор диагонали экрана"
    public Accordeon accordeonScreenDiagonalInch() {
        return new Accordeon(accordeonScreenDiagonalInch);
    }

    //Минимальная диагональ
    public TextBox textMinValueScreenDiagonal() {
        return new TextBox(inputMinValueScreenDiagonal);
    }

    //Максимальная диагональ
    public TextBox textMaxValueScreenDiagonal() {
        return new TextBox(inputMaxValueScreenDiagonal);
    }

    // Кнопка Применить
    public Button buttonApply() {
        return new Button(buttonApply);
    }

    // 3. Сортировка
    // Аккордеон "Сортировка"
    public Accordeon accordeonSort() {
        return new Accordeon(accordeonSort);
    }

    // Переключатель "Сортировка"
    public RadioButton radioButtonSort(String sort) {
        return new RadioButton(findRadioButtonSort(sort));
    }

    // Поиск переключателя "Сортировка"
    private WebElement findRadioButtonSort(String sort) {
        WaitHelper.visibilityOfElement(divSort);
        return divSort.findElement(By.xpath("//span[contains(text(), \"" + sort + "\")]"));
    }

    // 4. Ссылка на первый продукт в списке
    public Link linkFirstProduct() {
        try {
            Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofMillis(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new Link(linkFirstProduct);
    }


}
