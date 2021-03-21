package HomeWork_6.features.expences;

import org.junit.jupiter.api.Test;
import HomeWork_6.base.BaseUITest;
import HomeWork_6.common.Configuration;
import HomeWork_6.enums.ExpenseSubMenuButtons;
import HomeWork_6.enums.NavigationBarTabs;
import HomeWork_6.pages.AllExpensesPage;
import HomeWork_6.pages.LoginPage;

public class NewAgreementsTest extends BaseUITest {
    @Test
    public void createNewAgrementPositiveTest() {
        AllExpensesPage agreementFrame = (AllExpensesPage) new LoginPage(driver)
                .authoriseScenario(Configuration.STUDENT_LOGIN, Configuration.STUDENT_PASSWORD).getPageNavigation()
                .moveCursorToNavigationTab(NavigationBarTabs.EXPENSES)
                .clickSubMenuButton(ExpenseSubMenuButtons.BUSINESS_CONTRACTS);

        agreementFrame
                .clickOnCreateNewHouseAgreementButton()
                .enterHouseAgreementName()
                .enterHouseAgreementNumber("789/01.03")
                .enterHouseAgreementComment("Срочные работы по ликвидации последствий снегопада в Анголе")
                .chooseNewAgreementDate()
                .selectContractor(151)
                .selectExpenditure(10)
                .clickSubmit()
                .checkNewHouseAgreementPopUp();
    }
}
