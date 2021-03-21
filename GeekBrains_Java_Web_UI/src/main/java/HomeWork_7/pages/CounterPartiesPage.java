package HomeWork_7.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import HomeWork_7.base.BaseView;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CounterPartiesPage extends BaseView {


    @FindBy(xpath = "//*[@id='container']/div[1]/div/div/div[2]/div/div/a")
    private WebElement createNewCounterPartiesButton;

    @FindBy(xpath = "//*[@id='container']/div[1]/div/div/div[2]/div[2]/div/a")
    private WebElement createNewCompanyButton;

    public CounterPartiesPage(WebDriver driver) {

        super(driver);
    }

    @Step(value = "Нажать на кнопку 'Создать контактное лицо'")
    public NewCounterPartiesPage clickOnCreateNewCounterPartiesButton() {
        createNewCounterPartiesButton.click();
        return new NewCounterPartiesPage(driver);
    }

    @Step(value = "Нажать на кнопку 'Создать организацию'")
    public NewCompanyPage clickOnCreateNewCompanyButton() {
        createNewCompanyButton.click();
        return new NewCompanyPage(driver);
    }

    @Step(value = "Проверить появление баннера 'Контактное лицо сохранено'")
    public CounterPartiesPage checkNewCounterPartiesPopUp() {
        String message = wait30second.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
                "div[class='message']"))).getText();
        assertTrue(message.contains("Контактное лицо сохранено"));
        return this;
    }

    @Step(value = "Проверить появление баннера 'Организация сохранена'")
    public CounterPartiesPage checkNewCompanyPopUp() {
        String message = wait30second.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
                "div[class='message']"))).getText();
        assertTrue(message.contains("Организация сохранена"));
        return this;
    }
}
