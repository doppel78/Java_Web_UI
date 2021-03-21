package HomeWork_7.features.expences;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import HomeWork_7.base.BaseUITest;
import HomeWork_7.common.Configuration;
import HomeWork_7.enums.ExpenseSubMenuButtons;
import HomeWork_7.enums.NavigationBarTabs;
import HomeWork_7.pages.AllExpensesPage;
import HomeWork_7.pages.LoginPage;

@Feature("New HouseHold Agreement Creation")
public class NewAgreementsTest extends BaseUITest {

    @Story("Создание хозяйственного договора")
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
