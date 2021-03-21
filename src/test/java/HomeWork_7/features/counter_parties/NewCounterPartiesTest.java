package HomeWork_7.features.counter_parties;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import HomeWork_7.base.BaseUITest;
import HomeWork_7.common.Configuration;
import HomeWork_7.enums.CounterPartiesSubMenuButtons;
import HomeWork_7.enums.ExpenseSubMenuButtons;
import HomeWork_7.enums.NavigationBarTabs;
import HomeWork_7.enums.ProjectSubMenuButtons;
import HomeWork_7.pages.AllExpensesPage;
import HomeWork_7.pages.CounterPartiesPage;
import HomeWork_7.pages.LoginPage;
import HomeWork_7.pages.ProjectsPage;

@Feature("New Counterpartie Creation")
public class NewCounterPartiesTest extends BaseUITest {

    @Story("Создание нового контрагента")
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
