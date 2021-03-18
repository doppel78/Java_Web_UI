package HomeWork_6.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import HomeWork_6.base.BaseView;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProjectsPage extends BaseView {

    @FindBy(xpath = "//*[@id='container']/div[1]/div/div/div[2]/div/div/a")
    private WebElement createNewProjectButton;


    public ProjectsPage(WebDriver driver) {

        super(driver);
    }

    public NewProjectPage clickOnCreateNewProjectButton() {
        createNewProjectButton.click();
        return new NewProjectPage(driver);
    }

    public ProjectsPage checkNewProjectPopUp() {
        String message = wait10second.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
                "div[class='message']"))).getText();
        assertTrue(message.contains("Проект сохранен"));
        return this;
    }
}
