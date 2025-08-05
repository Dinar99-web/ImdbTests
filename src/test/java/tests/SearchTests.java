package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.SearchResultsPage;

@Epic("IMDb Web Application")
@Feature("Поиск контента")
@Story("Поиск фильмов, актеров, компаний")
@Tag("imdb")
public class SearchTests extends BaseTest {
    private final MainPage mainPage = new MainPage();
    private final SearchResultsPage searchResultsPage = new SearchResultsPage();

    @Test
    @DisplayName("Поиск фильма по названию")
    @Owner("Dinar Aminev")
    @Severity(SeverityLevel.CRITICAL)
    void searchFilmTest() {
        mainPage.openMainPage();
        mainPage.searchFor("Interstellar");
        searchResultsPage.checkResultContains("Interstellar");
    }

    @Test
    @DisplayName("Поиск по ключевому слову")
    @Owner("Dinar Aminev")
    @Severity(SeverityLevel.NORMAL)
    void keyWordSearchTest() {
        mainPage.openMainPage();
        mainPage.selectSearchCategory("Keywords");
        mainPage.searchFor("comedy");
        searchResultsPage.checkResultsContain("comedy");
    }

    @Test
    @DisplayName("Поиск по актеру")
    @Owner("Dinar Aminev")
    @Severity(SeverityLevel.NORMAL)
    void actorSearchTest() {
        mainPage.openMainPage();
        mainPage.selectSearchCategory("Celebs");
        mainPage.searchFor("mickey rourke");
        searchResultsPage.checkResultsContain("rourke");
    }

    @Test
    @DisplayName("Поиск по компании")
    @Owner("Dinar Aminev")
    @Severity(SeverityLevel.NORMAL)
    void companySearchTest() {
        mainPage.openMainPage();
        mainPage.selectSearchCategory("Companies");
        mainPage.searchFor("marvel");
        searchResultsPage.checkResultsContain("marvel");
    }

    @Test
    @DisplayName("Поиск сериалов")
    @Owner("Dinar Aminev")
    @Severity(SeverityLevel.NORMAL)
    void tvEpisodesSearchTest() {
        mainPage.openMainPage();
        mainPage.selectSearchCategory("TV episodes");
        mainPage.searchFor("Boondocks");
        searchResultsPage.checkResultsContain("Boondocks");
    }
}
