package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$$;

public class SearchResultsPage {
    private ElementsCollection resultItems = $$("a.ipc-metadata-list-summary-item__t");

    @Step("Проверить наличие результата с текстом: {text}")
    public void checkResultContains(String text) {
        resultItems.findBy(Condition.text(text))
                .shouldBe(Condition.visible);
    }

    @Step("Проверить, что результаты содержат текст: {text}")
    public void checkResultsContain(String text) {
        resultItems.first()
                .shouldHave(Condition.text(text));
    }
}
