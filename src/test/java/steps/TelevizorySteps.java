package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import models.testobjects.TelevizoryVO;
import models.valueobjects.BacklightType;
import models.valueobjects.Company;
import models.valueobjects.DiagonalScreen;
import models.valueobjects.RefreshScreenValue;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import web.drivers.WebDriverFactory;
import web.helpers.JavaScriptHelper;
import web.pages.StartPage;
import web.pages.TelevizoryPage;
import web.pages.TelevizoryProductPage;

import java.util.List;
import java.util.Map;

public class TelevizorySteps {
    // Логгер
    private Logger logger = LogManager.getLogger(TelevizorySteps.class);

    // Страницы
    StartPage startPage;
    TelevizoryPage televizoryPage;
    TelevizoryProductPage televizoryProductPage;



    @Дано("Открыта Главная страница ДНС")
    public void startDriverAndOpenStartPage() {
        startPage = new StartPage(WebDriverFactory.getCurrentDriver());
        televizoryPage = new TelevizoryPage(WebDriverFactory.getCurrentDriver());
        televizoryProductPage = new TelevizoryProductPage(WebDriverFactory.getCurrentDriver());

//    Открыть страницу ДНС
        WebDriverFactory.getCurrentDriver().get("https://www.dns-shop.ru/");
        logger.info("Открыта Стартовая страница сайта DNS");
    }

    @Когда("Выполнен переход на страницу Телевизоры")
    public void openTelevizoryPage() {
        startPage.linkYes().click();
        startPage.linkTvAndMultimedia().focusOnLink();
        startPage.linkTv().click();
        logger.info("Выполнен переход на страницу Телевизоры");
    }

    @Тогда("Проверить: В заголовке страницы отображается текст Телевизоры")
    public void assertTitle() {
//  Проверка заголовка страницы
        logger.info("Проверка заголовка страницы");
        Assertions.assertTrue(televizoryPage.getPageTitle().contains("Телевизоры"),
                "В заголовке страницы не отображается текст Телевизоры");

    }

    @И("Установлена сортировка {string}")
    public void setSortBy(String sortBy) {
        televizoryPage.accordeonSort().show();
        televizoryPage.radioButtonSort(sortBy).setSelected(true);
        logger.info("Установлена сортировка" + sortBy);
    }

    @И("В фильтре {string} выбрано значение {string}")
    public void setFilterBy(String filterBy, String value) {

        switch (filterBy) {
            case "Производитель":
                JavaScriptHelper.scrollBy(0, 800);
                televizoryPage.checkBoxCompany(value).setChecked(true);
                break;
            case "Частота обновления экрана":
                JavaScriptHelper.scrollBy(0, 800);
                televizoryPage.accordeonScreenRefresh().show();
                televizoryPage.checkBoxScreenRefresh(value).setChecked(true);
                break;
            case "Тип подсветки экрана":
//                JavaScriptHelper.scrollBy(0, 800);
                televizoryPage.accordeonBacklightType().show();
                televizoryPage.checkBoxBacklightType(value).setChecked(true);
                break;
            case "Минимальнная диагональ экрана":
                JavaScriptHelper.scrollBy(0, -800);
                televizoryPage.accordeonScreenDiagonalInch().show();
                televizoryPage.textMinValueScreenDiagonal().setValue(value);
                break;
            case "Максимальная диагональ экрана":
//
                televizoryPage.textMaxValueScreenDiagonal().setValue(value);
                break;
        }
        logger.info("В фильтре " + filterBy + " выбрано значение " + value);
    }

    @И("Применены выбранные фильтры")
    public void applyFilters() {
        JavaScriptHelper.scrollBy(0, 800);
        televizoryPage.buttonApply().click();
        logger.info("Применены выбраннфе фильтры");
    }

    @И("Выполнен переход на страницу первого товара из списка")
    public void selectFirstTV() {
        JavaScriptHelper.scrollBy(0, -1500);
        televizoryPage.linkFirstProduct().click();
        logger.info("Выполнен переход на страницу первого товара из списка");
    }



    @Тогда("Проверить: В заголовке страницы отображается текст {string}")
    public void assertTitleTelevizoryProduct(String company) {
//
        logger.info("Проверка заголовка страницы");
        Assertions.assertTrue(televizoryProductPage.getPageTitle().contains(company),"В заголовке страницы не отображается текст" + company);
    }

    @И("Установлены фильтры из таблицы с одной колонкой")
    public void setFiltersFromTable1(List<String> filters) {
        TelevizoryVO televizoryVO = new TelevizoryVO(
                new Company(filters.get(0)),
                new RefreshScreenValue(Integer.parseInt(filters.get(1).replaceAll("[^\\d]", ""))),
                new BacklightType(filters.get(2)),
                new DiagonalScreen(Integer.parseInt(filters.get(3)),Integer.parseInt(filters.get(4))));

        JavaScriptHelper.scrollBy(0, 800);
        televizoryPage.checkBoxCompany(televizoryVO.getCompany().getCompany()).setChecked(true);
        JavaScriptHelper.scrollBy(0, 800);
        televizoryPage.mainBlock().hide();
        televizoryPage.mainContainerBlock().hide();
        televizoryPage.accordeonBacklightType().show();
        televizoryPage.checkBoxBacklightType(televizoryVO.getBacklightType().getBacklightType()).setChecked(true);
        JavaScriptHelper.scrollBy(0, 800);
        televizoryPage.accordeonScreenRefresh().show();
        televizoryPage.checkBoxScreenRefresh(televizoryVO.getRefreshScreenValue().getRefreshScreenValue() + " Гц").setChecked(true);
        JavaScriptHelper.scrollBy(0, 400);
        televizoryPage.accordeonScreenDiagonalInch().show();
        televizoryPage.textMinValueScreenDiagonal().setValue(filters.get(3));
        televizoryPage.textMaxValueScreenDiagonal().setValue(filters.get(4));
        logger.info("***** Установлены фильтры из таблицы с одной колонкой");

    }

    @И("Установлены фильтры из таблицы с двумя колонками")
    public void setFiltersFromTable2(Map<String, String> filters){
        TelevizoryVO televizoryVO = new TelevizoryVO(
                new Company(filters.get("Производитель")),
                new RefreshScreenValue(Integer.parseInt(filters.get("Частота обновления экрана").replaceAll("[^\\d]", ""))),
                new BacklightType(filters.get("Тип подсветки экрана")),
                new DiagonalScreen(Integer.parseInt(filters.get("Минимальнная диагональ экрана")),Integer.parseInt(filters.get("Максимальнная диагональ экрана")))
        );
        televizoryPage.mainBlock().hide();
        JavaScriptHelper.scrollBy(0,800);
        televizoryPage.checkBoxCompany(televizoryVO.getCompany().getCompany()).setChecked(true);
        JavaScriptHelper.scrollBy(0, 800);

        televizoryPage.mainContainerBlock().hide();
        televizoryPage.accordeonBacklightType().show();
        televizoryPage.checkBoxBacklightType(televizoryVO.getBacklightType().getBacklightType()).setChecked(true);
        JavaScriptHelper.scrollBy(0, 800);
        televizoryPage.accordeonScreenRefresh().show();
        televizoryPage.checkBoxScreenRefresh(televizoryVO.getRefreshScreenValue().getRefreshScreenValue() + " Гц").setChecked(true);
        JavaScriptHelper.scrollBy(0, 400);
        televizoryPage.accordeonScreenDiagonalInch().show();
        //Тут нужно по другому организовать, чтобы данные из таблицы брались
        televizoryPage.textMinValueScreenDiagonal().setValue("60");
        televizoryPage.textMaxValueScreenDiagonal().setValue("80");
        logger.info("***** Установлены фильтры из таблицы с двумя колонками");

    }

    @Дано("Установлена сортировка и фильтры из таблицы с шестью колонками")
    public void setFiltersAndSortFromTable3(DataTable dataTable) {
        List<Map<String, String>> table = dataTable.asMaps(String.class, String.class
        );
        String sortBy = table.get(0).get("Сортировка");
        String filterByCompany = table.get(0).get("Производитель");
        String filterByRefreshScreen = table.get(0).get("Частота обновления экрана");
        String filterByBacklightType = table.get(0).get("Тип подсветки экрана");
        String filterByDiagonalScreenMin = table.get(0).get("Минимальнная диагональ экрана");
        String filterByDiagonalScreenMax = table.get(0).get("Максимальнная диагональ экрана");

        televizoryPage.accordeonSort().show();
        televizoryPage.radioButtonSort(sortBy).setSelected(true);
        TelevizoryVO televizoryVO = new TelevizoryVO(
                new Company(filterByCompany),
                new RefreshScreenValue(Integer.parseInt(filterByRefreshScreen.replaceAll("[^\\d]", ""))),
                new BacklightType(filterByBacklightType),
                new DiagonalScreen(Integer.parseInt(filterByDiagonalScreenMin),Integer.parseInt(filterByDiagonalScreenMax))
        );
        televizoryPage.mainBlock().hide();
        JavaScriptHelper.scrollBy(0, 800);
        televizoryPage.checkBoxCompany(televizoryVO.getCompany().getCompany()).setChecked(true);
        JavaScriptHelper.scrollBy(0, 800);

        televizoryPage.mainContainerBlock().hide();
        televizoryPage.accordeonBacklightType().show();
        televizoryPage.checkBoxBacklightType(televizoryVO.getBacklightType().getBacklightType()).setChecked(true);
        JavaScriptHelper.scrollBy(0, 600);
        televizoryPage.accordeonScreenRefresh().show();
        televizoryPage.checkBoxScreenRefresh(televizoryVO.getRefreshScreenValue().getRefreshScreenValue() + " Гц").setChecked(true);
        JavaScriptHelper.scrollBy(0, 400);
        televizoryPage.accordeonScreenDiagonalInch().show();
        televizoryPage.textMinValueScreenDiagonal().setValue("60");
        televizoryPage.textMaxValueScreenDiagonal().setValue("80");
        logger.info("***** Установлены фильтры из таблицы с шестью колонками");

    }


    @И("Перейти в таблицу Характеристики выбранного продукта")
    public void linkCharacteristicsTable() {
        televizoryProductPage.mainBlock().hide();
        JavaScriptHelper.scrollBy(0, 1000);
        televizoryProductPage.linkCharacteristics().click();
    }

    @Тогда("Проверить: В таблице отображается Модель телевизора {string} и Частота обновления экрана {string}")
    public void assertModelTelevizoryProduct(String model, String screenRefresh) {
//        Проверка модели по таблице
        logger.info("Проверка модели телевизора и частоты обновления по таблице");
        JavaScriptHelper.scrollBy(0, 800);
        Assertions.assertTrue(televizoryProductPage.getLinkModel().getText().contains(model));
        Assertions.assertTrue(televizoryProductPage.getLinkScreenRefresh().getText().contains(screenRefresh));

    }




}
