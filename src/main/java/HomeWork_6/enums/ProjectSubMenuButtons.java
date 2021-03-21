package HomeWork_6.enums;

import org.openqa.selenium.By;
import HomeWork_6.base.SubMenuButtons;

public enum ProjectSubMenuButtons implements SubMenuButtons {
    PROJECT("//span[@class='title' and text()='Все проекты']"),
    PROJECT_MY("//span[@class='title' and text()='Мои проекты']"),
    VALUE_CHANGE_REQUEST("//span[@class='title' and text()='Запросы на изменение ББ']");

    private final By by;

    ProjectSubMenuButtons(String xpath) {
        this.by = By.xpath(xpath);
    }

    public By getBy() {
        return by;
    }
}
