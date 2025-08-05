package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.MainPage;

@Epic("IMDb Web Application")
@Feature("Навигация по сайту")
@Story("Проверка меню и виджетов")
@Tag("navigation")
public class NavigationTests extends BaseTest {
    private final MainPage mainPage = new MainPage();

    @Test
    @DisplayName("Проверка названия поля виджета 'Movies'")
    @Owner("Dinar Aminev")
    @Severity(SeverityLevel.MINOR)
    void widgetTextTest() {
        mainPage.openMainPage();
        mainPage.openNavigationMenu();
        mainPage.checkMoviesMenuItem();
    }
}
