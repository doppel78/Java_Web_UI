package HomeWork_6.enums;

import org.openqa.selenium.By;
import HomeWork_6.base.SubMenuButtons;

public enum ExpenseSubMenuButtons implements SubMenuButtons {
    EXPENSE_REQUEST(".//span[@class='title' and text()='Заявки на расходы']"),
    BUSINESS_TRIPS(".//span[@class='title' and text()='Командировки']"),
    CENTER_COSTS("//li[5]/a/span[@class='title' and text()='Затраты центров']"),
    BUSINESS_CONTRACTS("//span[@class='title' and text()='Хоз. договоры']");

    private final By by;

    ExpenseSubMenuButtons(String xpath) {
        this.by = By.xpath(xpath);
    }

    public By getBy() {
        return by;
    }
}
