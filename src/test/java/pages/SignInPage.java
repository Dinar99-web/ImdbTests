package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class SignInPage {
    private SelenideElement imdbSignInOption = $("[data-testid='sign_in_option_IMDB']");
    private SelenideElement logo = $("img[alt='IMDb.com logo']");

    @Step("Выбрать способ входа через IMDb")
    public void selectSignInOption() {
        imdbSignInOption.click();
    }

    @Step("Проверить отображение логотипа")
    public void checkLogoIsVisible() {
        logo.shouldBe(Condition.visible);
    }
}