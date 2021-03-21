package HomeWork_7.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import HomeWork_7.base.BaseView;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProjectsPage extends BaseView {

    @FindBy(xpath = "//*[@id='container']/div[1]/div/div/div[2]/div/div/a")
    private WebElement createNewProjectButton;


    public ProjectsPage(WebDriver driver) {

        super(driver);
    }

    @Step(value = "Нажать на кнопку 'Создать проект'")
    public NewProjectPage clickOnCreateNewProjectButton() {
        createNewProjectButton.click();
        return new NewProjectPage(driver);
    }

    @Step(value = "Проверить появление баннера 'Проект сохранен'")
    public ProjectsPage checkNewProjectPopUp() {
        String message = wait30second.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
                "div[class='message']"))).getText();
        assertTrue(message.contains("Проект сохранен"));
        return this;
    }
}
