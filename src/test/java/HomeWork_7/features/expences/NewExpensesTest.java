package HomeWork_7.features.expences;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import HomeWork_7.base.BaseUITest;
import HomeWork_7.base.SubMenu;
import HomeWork_7.common.Configuration;
import HomeWork_7.enums.ExpenseSubMenuButtons;
import HomeWork_7.enums.NavigationBarTabs;
import HomeWork_7.pages.AllExpensesPage;
import HomeWork_7.pages.HomePage;
import HomeWork_7.pages.LoginPage;
import HomeWork_7.pages.NewExpensePage;
import HomeWork_7.views.NavigationBar;

@Feature("New Expenses Creation")
public class NewExpensesTest extends BaseUITest {

    @Story("Создание заявки на расход")
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
    @Disabled
    public void createNewExpensePositiveTest2() {
        LoginPage lp = new LoginPage(driver);
        HomePage hp = lp.authoriseScenario(Configuration.STUDENT_LOGIN, Configuration.STUDENT_PASSWORD);
        NavigationBar nb = hp.getPageNavigation();
        SubMenu sm = nb.moveCursorToNavigationTab(NavigationBarTabs.EXPENSES);
        sm.clickSubMenuButton(ExpenseSubMenuButtons.EXPENSE_REQUEST);

        AllExpensesPage expensesScreen = new AllExpensesPage(driver);

        NewExpensePage nep = expensesScreen.clickOnCreateNewExpenseButton();
        nep.enterDescription("qwerty");
        nep.selectBusinessUnit(1);
        nep.selectExpenditure(87);
        nep.setExpenseSum(10000);
        nep.clickNotifyDateChangedCheckBox();
        nep.selectDateInDatePicker(20);
        nep.clickSubmit();

        expensesScreen.checkNewExpensePopUp();
    }
}
