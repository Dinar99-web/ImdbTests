import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$$;

public class ImdbTests {
    @BeforeAll
    static void BrowserSetup() {
        Configuration.baseUrl = "https://s.media-imdb.com/";
        Configuration.browserSize = "1920x1080";
    }
    @Test
    @DisplayName("Поиск фильма по названию")
    void searchImdbFilmTest(){
        open("https://s.media-imdb.com/");
        $("#suggestion-search").setValue("Interstellar").pressEnter();
        $$("a.ipc-metadata-list-summary-item__t").findBy(text("Интерстеллар"))
                .shouldBe(visible);
    }
    @Test
    @DisplayName("Проверка названия поля виджета")
    void widgetTextTest(){
        open("https://s.media-imdb.com/");
        $("#imdbHeader-navDrawerOpen").click();
        $("span.navlinkcat__itemTitle")
                .shouldBe(visible)
                .shouldHave(Condition.text("Movies"));
    }
    @Test
    @DisplayName("Способы аутинтификации")
    void checkinVariantsTest(){
        open("https://s.media-imdb.com/registration/signin");
        $$("a.list-group-item").findBy(text("Sign in with IMDb")).click();
        $("img[alt='IMDb.com logo']").shouldBe(visible);
    }
    @Test
    @DisplayName("Поиск по ключевому слову")
    void keyWordSearchTest(){
        open("https://s.media-imdb.com/");
        $("[data-testid=category-selector-button]").click();
        $$(".ipc-list-item__text").findBy(exactText("Keywords")).click();
        $("#suggestion-search").setValue("comedy").pressEnter();
        $("a.ipc-metadata-list-summary-item__t").shouldHave(text("comedy"));
    }
    @Test
    @DisplayName("Поиск по актеру")
    void actorSearchTest(){
        open("https://s.media-imdb.com/");
        $("[data-testid=category-selector-button]").click();
        $$(".ipc-list-item__text").findBy(exactText("Celebs")).click();
        $("#suggestion-search").setValue("mickey rourke").pressEnter();
        $("a.ipc-metadata-list-summary-item__t").shouldHave(text("rourke"));
    }
}
