package HomeWork_7.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import HomeWork_7.base.BaseView;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AllExpensesPage extends BaseView {

    @FindBy(css = "div[class='pull-left btn-group icons-holder']")
    private WebElement createNewExpenseButton;

    @FindBy(css = "div[class='pull-left btn-group icons-holder']")
    private WebElement createNewBTExpenseButton;

    @FindBy(xpath = "//div[2]//a[@class='btn back icons-holder-text ']")
    private WebElement createNewHouseHoldAgreementButton;

    public AllExpensesPage(WebDriver driver) {

        super(driver);
    }

    @Step(value = "Нажать на кнопку 'Создать заявку на расход'")
    public NewExpensePage clickOnCreateNewExpenseButton() {
        createNewExpenseButton.click();
        return new NewExpensePage(driver);
    }

    @Step(value = "Нажать на кнопку 'Новый хозяйственный договор'")
    public NewHouseAgreementPage clickOnCreateNewHouseAgreementButton() {
        createNewHouseHoldAgreementButton.click();
        return new NewHouseAgreementPage(driver);
    }


    @Step(value = "Появление баннера 'Заявка на расход сохранена'")
    public AllExpensesPage checkNewExpensePopUp() {
        String message = wait30second.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
                "div[class='message']"))).getText();
        assertTrue(message.contains("Заявка на расход сохранена"));
        return this;
    }

    @Step(value = "Появление баннера 'Договор сохранен'")
    public AllExpensesPage checkNewHouseAgreementPopUp() {
        String message = wait30second.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
                "div[class='message']"))).getText();
        assertTrue(message.contains("Договор сохранен"));
        return this;
    }
}
