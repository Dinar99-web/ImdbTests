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
    public void searchFor(String query) {
        $(".imdb-header-search__input").setValue(query).pressEnter();
    }

    @Step("Выбрать категорию поиска: {category}")
    public void selectSearchCategory(String category) {
        categorySelector.click();
        menuItems.findBy(Condition.exactText(category)).click();
    }

    @Step("Открыть меню навигации")
    public void openNavigationMenu() {
        menuButton.click();
    }

    @Step("Проверить наличие пункта меню 'Movies'")
    public void checkMoviesMenuItem() {
        moviesMenuItem.shouldBe(Condition.visible)
                .shouldHave(Condition.text("Movies"));
    }

    @Step("Открыть главную страницу IMDb")
    public void openMainPage() {
        Selenide.open("/");
    }
}
