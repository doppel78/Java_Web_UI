package HomeWork_6.views;

import HomeWork_6.pages.CounterPartiesSubMenu;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import HomeWork_6.base.BaseView;
import HomeWork_6.base.SubMenu;
import HomeWork_6.enums.NavigationBarTabs;


public class NavigationBar extends BaseView {

    public NavigationBar(WebDriver driver) {

        super(driver);
    }

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

    public NavigationBar checkTabVisibility(NavigationBarTabs tab) {
        Assertions.assertTrue(driver.findElement(tab.getBy()).isDisplayed());
        return this;
    }
}
