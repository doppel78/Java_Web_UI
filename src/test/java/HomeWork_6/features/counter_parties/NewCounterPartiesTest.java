package HomeWork_6.features.counter_parties;

import org.junit.jupiter.api.Test;
import HomeWork_6.base.BaseUITest;
import HomeWork_6.common.Configuration;
import HomeWork_6.enums.CounterPartiesSubMenuButtons;
import HomeWork_6.enums.ExpenseSubMenuButtons;
import HomeWork_6.enums.NavigationBarTabs;
import HomeWork_6.enums.ProjectSubMenuButtons;
import HomeWork_6.pages.AllExpensesPage;
import HomeWork_6.pages.CounterPartiesPage;
import HomeWork_6.pages.LoginPage;
import HomeWork_6.pages.ProjectsPage;

public class NewCounterPartiesTest extends BaseUITest {
    @Test
    public void createNewCounterPartiesPositiveTest() {
        CounterPartiesPage counterPartiesFrame = (CounterPartiesPage) new LoginPage(driver)
                .authoriseScenario(Configuration.STUDENT_LOGIN, Configuration.STUDENT_PASSWORD)
                .getPageNavigation()
                .moveCursorToNavigationTab(NavigationBarTabs.COUNTER_PARTIES)
                .clickSubMenuButton(CounterPartiesSubMenuButtons.CONTACT);

        counterPartiesFrame
                .clickOnCreateNewCounterPartiesButton()
                .enterNewLastNameCounterParties("John")
                .enterNewFirstNameCounterParties("Smith")
                .selectOrganizationOfProject()
                .enterNewJobTitleCounterParties("Detective")
                .clickSubmit()
                .checkNewCounterPartiesPopUp();

    }
}
