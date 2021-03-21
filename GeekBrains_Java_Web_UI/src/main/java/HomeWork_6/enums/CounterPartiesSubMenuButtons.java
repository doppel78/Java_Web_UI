package HomeWork_6.enums;

import HomeWork_6.base.SubMenuButtons;
import org.openqa.selenium.By;

public enum CounterPartiesSubMenuButtons implements SubMenuButtons {
    COMPANY("//ul/li[3]/a/span[@class='title' and text()='Организации']"),
    PAYER("//span[@class='title' and text()='Плательщики']"),
    CONTACT("//span[@class='title' and text()='Контактные лица']");

    private final By by;

    CounterPartiesSubMenuButtons(String xpath) {
        this.by = By.xpath(xpath);
    }

    public By getBy() {

        return by;
    }
}
