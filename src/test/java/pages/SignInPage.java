package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SignInPage {
    private ElementsCollection signInOptions = $$("a.list-group-item");
    private SelenideElement logo = $("img[alt='IMDb.com logo']");

    @Step("Выбрать способ входа: {option}")
    public void selectSignInOption(String option) {
        signInOptions.findBy(Condition.text(option)).click();
    }

    @Step("Проверить отображение логотипа")
    public void checkLogoIsVisible() {
        logo.shouldBe(Condition.visible);
    }
}
