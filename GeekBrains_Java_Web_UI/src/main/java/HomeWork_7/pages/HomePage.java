package HomeWork_7.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

import HomeWork_7.base.BaseView;
import HomeWork_7.views.NavigationBar;

public class HomePage extends BaseView {
    private NavigationBar navigationBar;

    public HomePage(WebDriver driver) {
        super(driver);
        this.navigationBar = new NavigationBar(driver);
    }

    @Step(value = "Проверить URL'")
    public void checkUrl(String url) {

        assertEquals(driver.getCurrentUrl(), url);
    }

    public NavigationBar getPageNavigation() {

        return navigationBar;
    }
}
