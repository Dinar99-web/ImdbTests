package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.MainPage;

@Epic("IMDb Web Application")
@Feature("Навигация по сайту")
@Story("Проверка меню и виджетов")
@Tag("imdb")
@Owner("Dinar Aminev")
public class NavigationTests extends BaseTest {
    private final MainPage mainPage = new MainPage();

    @Test
    @DisplayName("Проверка названия поля виджета 'Movies'")
    @Severity(SeverityLevel.MINOR)
    void widgetTextTest() {
        mainPage.openMainPage()
                .openNavigationMenu()
                .checkMoviesMenuItem();
    }
}
