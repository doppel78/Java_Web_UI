package HomeWork_7.features.login;

import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

import io.qameta.allure.Story;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import HomeWork_7.base.BaseUITest;
import HomeWork_7.helpers.ScreenshotMaker;
import HomeWork_7.pages.HomePage;
import HomeWork_7.pages.LoginPage;

import static HomeWork_7.common.Configuration.*;

@Feature("Positive Login Test")
@Severity(SeverityLevel.BLOCKER)
public class PositiveLoginTest extends BaseUITest {

    @Story("Авторизация на сайте")
    @Test
    public void loginWithBaseUserTest() {
        new LoginPage(driver)
                .enterLogin(STUDENT_LOGIN)
                .enterPassword(STUDENT_PASSWORD)
                .clickLoginButton()
                .checkUrl(BASE_URL);
    }
}
