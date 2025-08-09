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
@Owner("Dinar Aminev")
public class SearchTests extends BaseTest {
    private final MainPage mainPage = new MainPage();
    private final SearchResultsPage searchResultsPage = new SearchResultsPage();

    @Test
    @DisplayName("Поиск фильма по названию")
    @Severity(SeverityLevel.CRITICAL)
    void searchFilmTest() {
        mainPage.openMainPage()
                .searchFor("Interstellar");
        searchResultsPage.checkResultContains("Interstellar");
    }

    @Test
    @DisplayName("Поиск по ключевому слову")
    @Severity(SeverityLevel.NORMAL)
    void keyWordSearchTest() {
        mainPage.openMainPage()
                .selectSearchCategory("Keywords")
                .searchFor("comedy");
        searchResultsPage.checkResultsContain("comedy");
    }

    @Test
    @DisplayName("Поиск по актеру")
    @Severity(SeverityLevel.NORMAL)
    void actorSearchTest() {
        mainPage.openMainPage()
                .selectSearchCategory("Celebs")
                .searchFor("mickey rourke");
        searchResultsPage.checkResultsContain("rourke");
    }

    @Test
    @DisplayName("Поиск по компании")
    @Severity(SeverityLevel.NORMAL)
    void companySearchTest() {
        mainPage.openMainPage()
                .selectSearchCategory("Companies")
                .searchFor("marvel");
        searchResultsPage.checkResultsContain("marvel");
    }

    @Test
    @DisplayName("Поиск сериалов")
    @Severity(SeverityLevel.NORMAL)
    void tvEpisodesSearchTest() {
        mainPage.openMainPage()
                .selectSearchCategory("TV episodes")
                .searchFor("Boondocks");
        searchResultsPage.checkResultsContain("Boondocks");
    }
}