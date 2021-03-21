package HomeWork_7.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BaseView {


    protected WebDriver driver;
    protected WebDriverWait wait10second;
    protected WebDriverWait wait20second;
    protected WebDriverWait wait30second;

    public BaseView(WebDriver driver) {
        this.driver = driver;
        this.wait10second = new WebDriverWait(driver, 10);
        this.wait20second = new WebDriverWait(driver, 20);
        this.wait30second = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }
}
