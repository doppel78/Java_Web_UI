package HomeWork_6.pages;

import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

import HomeWork_6.base.BaseView;
import HomeWork_6.views.NavigationBar;

public class HomePage extends BaseView {
    private NavigationBar navigationBar;

    public HomePage(WebDriver driver) {
        super(driver);
        this.navigationBar = new NavigationBar(driver);
    }

    public void checkUrl(String url) {

        assertEquals(driver.getCurrentUrl(), url);
    }

    public NavigationBar getPageNavigation() {

        return navigationBar;
    }
}
