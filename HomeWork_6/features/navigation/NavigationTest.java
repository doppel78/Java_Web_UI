package HomeWork_6.features.navigation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import HomeWork_6.base.BaseUITest;
import HomeWork_6.common.Configuration;
import HomeWork_6.enums.NavigationBarTabs;
import HomeWork_6.pages.LoginPage;

public class NavigationTest extends BaseUITest {

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
