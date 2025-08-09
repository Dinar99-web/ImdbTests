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
@Owner("Dinar Aminev")
public class AuthTests extends BaseTest {
    private final SignInPage signInPage = new SignInPage();

    @Test
    @DisplayName("Проверка способов аутентификации")
    @Severity(SeverityLevel.CRITICAL)
    void checkSignInOptionsTest() {
        signInPage.openSignInPage()
                .selectSignInOption()
                .checkLogoIsVisible();
    }
}
