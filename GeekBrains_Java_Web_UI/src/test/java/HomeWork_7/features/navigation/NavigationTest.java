package HomeWork_7.features.navigation;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import HomeWork_7.base.BaseUITest;
import HomeWork_7.common.Configuration;
import HomeWork_7.enums.NavigationBarTabs;
import HomeWork_7.pages.LoginPage;

@Feature("Navigation Positive Test")
public class NavigationTest extends BaseUITest {

    @Story("Проверка на успешную авторизацию")
    @ParameterizedTest
    @MethodSource("navigationTabProvider")

    public void checkMainNavigationTabsTest(NavigationBarTabs barTab) {
        new LoginPage(driver)
                .authoriseScenario(Configuration.STUDENT_LOGIN, Configuration.STUDENT_PASSWORD)
                .getPageNavigation()
                .checkTabVisibility(barTab);

    }

    static NavigationBarTabs[] navigationTabProvider() {
        return NavigationBarTabs.values();
    }
}
