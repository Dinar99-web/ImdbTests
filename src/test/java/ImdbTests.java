import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.MainPage;
import pages.SearchResultsPage;
import pages.SignInPage;
import io.qameta.allure.selenide.AllureSelenide;

import java.util.Map;

import static com.codeborne.selenide.Selenide.open;

@Epic("IMDb Tests")
@Feature("Поиск и навигация по IMDb")
@Tag("imdb")
public class ImdbTests {
    private MainPage mainPage = new MainPage();
    private SearchResultsPage searchResultsPage = new SearchResultsPage();
    private SignInPage signInPage = new SignInPage();

    @BeforeAll
    static void browserSetup() {
        // Добавляем Allure Listener для Selenide
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true)
        );

        Configuration.baseUrl = "https://www.imdb.com";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
    }
    @AfterEach
    void addAttachents() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
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
    @DisplayName("Проверка способов аутентификации")
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