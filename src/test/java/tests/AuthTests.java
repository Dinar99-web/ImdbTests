package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.SignInPage;

@Epic("IMDb Web Application")
@Feature("Авторизация")
@Story("Проверка способов входа")
@Tag("imdb")
public class AuthTests extends BaseTest {
    private final SignInPage signInPage = new SignInPage();

    @Test
    @DisplayName("Проверка способов аутентификации")
    @Owner("Dinar Aminev")
    @Severity(SeverityLevel.CRITICAL)
    void checkSignInOptions() {
        signInPage.openSignInPage();
        signInPage.selectSignInOption();
        signInPage.checkLogoIsVisible();
    }
}
