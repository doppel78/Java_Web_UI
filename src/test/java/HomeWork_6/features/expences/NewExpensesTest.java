package HomeWork_6.features.expences;

import org.junit.jupiter.api.Test;
import HomeWork_6.base.BaseUITest;
import HomeWork_6.base.SubMenu;
import HomeWork_6.common.Configuration;
import HomeWork_6.enums.ExpenseSubMenuButtons;
import HomeWork_6.enums.NavigationBarTabs;
import HomeWork_6.pages.AllExpensesPage;
import HomeWork_6.pages.HomePage;
import HomeWork_6.pages.LoginPage;
import HomeWork_6.pages.NewExpensePage;
import HomeWork_6.views.NavigationBar;

public class NewExpensesTest extends BaseUITest {


    @Test
    public void createNewExpensePositiveTest() {
        AllExpensesPage expensesScreen = (AllExpensesPage) new LoginPage(driver)
                .authoriseScenario(Configuration.STUDENT_LOGIN, Configuration.STUDENT_PASSWORD)
                .getPageNavigation()
                .moveCursorToNavigationTab(NavigationBarTabs.EXPENSES)
                .clickSubMenuButton(ExpenseSubMenuButtons.EXPENSE_REQUEST);

        expensesScreen
                .clickOnCreateNewExpenseButton()
                .enterDescription("test 1234")
                .selectBusinessUnit(1)
                .selectExpenditure(87)
                .setExpenseSum(10000)
                .clickNotifyDateChangedCheckBox()
                .selectDateInDatePicker(20)
                .clickSubmit()
                .checkNewExpensePopUp();
    }

    @Test
    public void createNewExpensePositiveTest2() {
        LoginPage lp = new LoginPage(driver);
        HomePage hp = lp.authoriseScenario(Configuration.STUDENT_LOGIN, Configuration.STUDENT_PASSWORD);
        NavigationBar nb = hp.getPageNavigation();
        SubMenu sm = nb.moveCursorToNavigationTab(NavigationBarTabs.EXPENSES);
        sm.clickSubMenuButton(ExpenseSubMenuButtons.EXPENSE_REQUEST);

        AllExpensesPage expensesScreen = new AllExpensesPage(driver);

        NewExpensePage nep = expensesScreen.clickOnCreateNewExpenseButton();
        nep.enterDescription("test 1234");
        nep.selectBusinessUnit(1);
        nep.selectExpenditure(87);
        nep.setExpenseSum(10000);
        nep.clickNotifyDateChangedCheckBox();
        nep.selectDateInDatePicker(20);
        nep.clickSubmit();

        expensesScreen.checkNewExpensePopUp();
    }

    @Test
    public void createNewBContractExpensePositiveTest() {
        AllExpensesPage expensesScreen = (AllExpensesPage) new LoginPage(driver)
                .authoriseScenario(Configuration.STUDENT_LOGIN, Configuration.STUDENT_PASSWORD)
                .getPageNavigation()
                .moveCursorToNavigationTab(NavigationBarTabs.EXPENSES)
                .clickSubMenuButton(ExpenseSubMenuButtons.BUSINESS_CONTRACTS);

        try {
            Thread.sleep(9000);

        } catch (Exception e) {
        }
    }
}
