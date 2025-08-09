package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {
    private ElementsCollection menuItems = $$(".ipc-list-item__text");
    private SelenideElement moviesMenuItem = $("[data-testid=category-expando]");
    private SelenideElement menuButton = $(".ipc-responsive-button__text");
    private SelenideElement categorySelector = $(".ipc-btn--core-base");

    @Step("Поиск по запросу: {query}")
    public MainPage searchFor(String query) {
        $(".imdb-header-search__input").setValue(query).pressEnter();
        return this;
    }

    @Step("Выбрать категорию поиска: {category}")
    public MainPage selectSearchCategory(String category) {
        categorySelector.click();
        menuItems.findBy(Condition.exactText(category)).click();
        return this;
    }

    @Step("Открыть меню навигации")
    public MainPage openNavigationMenu() {
        menuButton.click();
        return this;
    }

    @Step("Проверить наличие пункта меню 'Movies'")
    public MainPage checkMoviesMenuItem() {
        moviesMenuItem.shouldBe(Condition.visible)
                .shouldHave(Condition.text("Movies"));
        return this;
    }

    @Step("Открыть главную страницу IMDb")
    public MainPage openMainPage() {
        Selenide.open("/");
        return this;
    }
}
