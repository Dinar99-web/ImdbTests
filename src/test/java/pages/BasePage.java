package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class BasePage {
    protected SelenideElement searchInput = $("#suggestion-search");
    protected SelenideElement menuButton = $("#imdbHeader-navDrawerOpen");
    protected SelenideElement categorySelector = $("[data-testid=category-selector-button]");

    @Step("Открыть главную страницу IMDb")
    public void openMainPage() {
        Selenide.open("/");
    }
}
