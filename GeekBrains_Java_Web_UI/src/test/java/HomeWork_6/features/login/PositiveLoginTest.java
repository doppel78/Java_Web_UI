package HomeWork_6.features.login;

import org.junit.jupiter.api.Test;
import HomeWork_6.base.BaseUITest;
import HomeWork_6.pages.LoginPage;

import static HomeWork_6.common.Configuration.*;

public class PositiveLoginTest extends BaseUITest {

    @Test
    public void loginWithBaseUserTest() {
        new LoginPage(driver)
                .enterLogin(STUDENT_LOGIN)
                .enterPassword(STUDENT_PASSWORD)
                .clickLoginButton()
                .checkUrl(BASE_URL);
    }
}
