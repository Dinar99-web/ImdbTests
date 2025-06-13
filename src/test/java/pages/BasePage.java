package pages;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;


public class BasePage {

    @Step("Открыть главную страницу IMDb")
    public void openMainPage() {
        Selenide.open("/");
    }
}
