package HomeWork_6.pages;

import HomeWork_6.base.BaseView;
import HomeWork_6.base.SubMenu;
import HomeWork_6.base.SubMenuButtons;
import HomeWork_6.enums.CounterPartiesSubMenuButtons;
import org.openqa.selenium.WebDriver;


public class CounterPartiesSubMenu extends SubMenu {

    public CounterPartiesSubMenu(WebDriver driver) {

        super(driver);
    }

    @Override
    public BaseView clickSubMenuButton(SubMenuButtons buttons) {
        if (buttons instanceof CounterPartiesSubMenuButtons) {
            switch ((CounterPartiesSubMenuButtons) buttons) {
                case COMPANY:
                    driver.findElement(((CounterPartiesSubMenuButtons) buttons).getBy()).click();
                    return new CounterPartiesPage(driver);
                case CONTACT:
                    driver.findElement(((CounterPartiesSubMenuButtons) buttons).getBy()).click();
                    return new CounterPartiesPage(driver);
                default:
                    throw new IllegalArgumentException("Not implemented yet");
            }
        } else {
            throw new IllegalArgumentException("Incorrect button type");
        }
    }
}
