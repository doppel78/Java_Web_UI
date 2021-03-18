package HomeWork_6.views;

import org.openqa.selenium.WebDriver;
import HomeWork_6.base.BaseView;
import HomeWork_6.base.SubMenu;
import HomeWork_6.base.SubMenuButtons;
import HomeWork_6.enums.ProjectSubMenuButtons;
import HomeWork_6.pages.ProjectsPage;

public class ProjectsSubMenu extends SubMenu {

    public ProjectsSubMenu(WebDriver driver) {
        super(driver);
    }

    @Override
    public BaseView clickSubMenuButton(SubMenuButtons buttons) {
        if (buttons instanceof ProjectSubMenuButtons) {
            switch ((ProjectSubMenuButtons) buttons) {
                case PROJECT:
                    driver.findElement(((ProjectSubMenuButtons) buttons).getBy()).click();
                    return new ProjectsPage(driver);
                case PROJECT_MY:
                    driver.findElement(((ProjectSubMenuButtons) buttons).getBy()).click();
                    return new ProjectsPage(driver);
                case VALUE_CHANGE_REQUEST:
                    driver.findElement(((ProjectSubMenuButtons) buttons).getBy()).click();
                    return new ProjectsPage(driver);
                default:
                    throw new IllegalArgumentException("Not implemented yet");
            }
        } else {
            throw new IllegalArgumentException("Incorrect button type");
        }
    }
}
