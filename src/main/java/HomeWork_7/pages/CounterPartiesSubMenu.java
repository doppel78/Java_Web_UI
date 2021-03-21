package HomeWork_7.pages;

import io.qameta.allure.Step;
import HomeWork_7.base.BaseView;
import HomeWork_7.base.SubMenu;
import HomeWork_7.base.SubMenuButtons;
import HomeWork_7.enums.CounterPartiesSubMenuButtons;
import org.openqa.selenium.WebDriver;


public class CounterPartiesSubMenu extends SubMenu {

    public CounterPartiesSubMenu(WebDriver driver) {

        super(driver);
    }

    @Override
    @Step(value = "Кликнуть на элемент сабменю из 'Контрагенты'")
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
