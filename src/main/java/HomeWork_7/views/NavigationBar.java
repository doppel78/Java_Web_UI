package HomeWork_7.views;

import io.qameta.allure.Step;
import HomeWork_7.pages.CounterPartiesSubMenu;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import HomeWork_7.base.BaseView;
import HomeWork_7.base.SubMenu;
import HomeWork_7.enums.NavigationBarTabs;


public class NavigationBar extends BaseView {

    public NavigationBar(WebDriver driver) {

        super(driver);
    }

    @Step(value = "Навести мышкой на элемент основного меню навигации")
    public SubMenu moveCursorToNavigationTab(NavigationBarTabs tab) {
        Actions actions = new Actions(driver);
        actions
                .moveToElement(driver.findElement(tab.getBy()))
                .build()
                .perform();
        switch (tab) {
            case EXPENSES:
                return new ExpenseSubMenu(driver);
            case PROJECTS:
                return new ProjectsSubMenu(driver);
            case COUNTER_PARTIES:
                return new CounterPartiesSubMenu(driver);
            default:
                throw new IllegalArgumentException("Another tabs currently not implemented");
        }
    }

    @Step(value = "Проверить появление элемента меню навигации")
    public NavigationBar checkTabVisibility(NavigationBarTabs tab) {
        Assertions.assertTrue(driver.findElement(tab.getBy()).isDisplayed());
        return this;
    }
}
