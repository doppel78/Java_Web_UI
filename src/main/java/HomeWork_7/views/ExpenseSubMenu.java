package HomeWork_7.views;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import HomeWork_7.base.BaseView;
import HomeWork_7.base.SubMenu;
import HomeWork_7.base.SubMenuButtons;
import HomeWork_7.enums.ExpenseSubMenuButtons;
import HomeWork_7.pages.AllExpensesPage;

public class ExpenseSubMenu extends SubMenu {

    public ExpenseSubMenu(WebDriver driver) {

        super(driver);
    }

    @Override
    @Step(value = "Кликнуть на элемент сабменю из 'Расходы'")
    public BaseView clickSubMenuButton(SubMenuButtons buttons) {
        if (buttons instanceof ExpenseSubMenuButtons) {
            switch ((ExpenseSubMenuButtons) buttons) {
                case EXPENSE_REQUEST:
                    driver.findElement(((ExpenseSubMenuButtons) buttons).getBy()).click();
                    return new AllExpensesPage(driver);
                case BUSINESS_TRIPS:
                    driver.findElement(((ExpenseSubMenuButtons) buttons).getBy()).click();
                    return new AllExpensesPage(driver);
                case BUSINESS_CONTRACTS:
                    driver.findElement(((ExpenseSubMenuButtons) buttons).getBy()).click();
                    return new AllExpensesPage(driver);
                default:
                    throw new IllegalArgumentException("Not implemented yet");
            }
        } else {
            throw new IllegalArgumentException("Incorrect button type");
        }
    }
}
