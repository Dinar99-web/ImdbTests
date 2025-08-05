package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class SignInPage {
    private final SelenideElement imdbSignInOption = $("[data-testid='sign_in_option_IMDB']");
    private final SelenideElement logo = $("img[alt='IMDb.com logo']");

    @Step("Открыть страницу входа")
    public SignInPage openSignInPage() {
        Selenide.open("/registration/signin");
        return this;
    }

    @Step("Выбрать способ входа через IMDb")
    public SignInPage selectSignInOption() {
        imdbSignInOption.click();
        return this;
    }

    @Step("Проверить отображение логотипа")
    public SignInPage checkLogoIsVisible() {
        logo.shouldBe(Condition.visible);
        return this;
    }
}