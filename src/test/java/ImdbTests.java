import com.codeborne.selenide.Configuration;
import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.SearchResultsPage;
import pages.SignInPage;

import static com.codeborne.selenide.Selenide.open;

@Epic("IMDb Tests")
@Feature("Поиск и навигация по IMDb")
public class ImdbTests {
    private MainPage mainPage = new MainPage();
    private SearchResultsPage searchResultsPage = new SearchResultsPage();
    private SignInPage signInPage = new SignInPage();

    @BeforeAll
    static void BrowserSetup() {
        Configuration.baseUrl = "https://www.imdb.com";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;
    }

    @Test
    @DisplayName("Поиск фильма по названию")
    void searchImdbFilmTest() {
        open("/");
        mainPage.searchFor("Interstellar");
        searchResultsPage.checkResultContains("Interstellar");
    }

    @Test
    @DisplayName("Проверка названия поля виджета")
    void widgetTextTest() {
        mainPage.openMainPage();
        mainPage.openNavigationMenu();
        mainPage.checkMoviesMenuItem();
    }

    @Test
    @DisplayName("Способы аутентификации")
    void checkinVariantsTest() {
        open("https://s.media-imdb.com/registration/signin");
        signInPage.selectSignInOption("Sign in with IMDb");
        signInPage.checkLogoIsVisible();
    }

    @Test
    @DisplayName("Поиск по ключевому слову")
    void keyWordSearchTest() {
        mainPage.openMainPage();
        mainPage.selectSearchCategory("Keywords");
        mainPage.searchFor("comedy");
        searchResultsPage.checkResultsContain("comedy");
    }

    @Test
    @DisplayName("Поиск по актеру")
    void actorSearchTest() {
        mainPage.openMainPage();
        mainPage.selectSearchCategory("Celebs");
        mainPage.searchFor("mickey rourke");
        searchResultsPage.checkResultsContain("rourke");
    }
}