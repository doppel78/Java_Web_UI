package HomeWork_6.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import HomeWork_6.base.BaseView;


public class NewCounterPartiesPage extends BaseView {

    @FindBy(xpath = "//div[1]/div[1]/div[2]/input[@name='crm_contact[lastName]']")
    private WebElement lastNameCounterPartiesTextInput;

    @FindBy(xpath = "//div[1]/div[2]/div[2]/input[@name='crm_contact[firstName]']")
    private WebElement firstNameCounterPartiesTextInput;

    @FindBy(xpath = "//div[2]/div/div[@class='select2-container select2 input-widget']")
    private WebElement organizationWindowClick;

    @FindBy(xpath = "//*[@id='select2-drop']/ul[2]/li[5]/div")
    private WebElement organizationSelect;

    @FindBy(xpath = "//div[2]/div[2]/input[@name='crm_contact[jobTitle]']")
    private WebElement jobTitleCounterPartiesTextInput;

    @FindBy(css = "button[class='btn btn-success action-button']")
    private WebElement submitButton;


    public NewCounterPartiesPage(WebDriver driver) {

        super(driver);
    }

    public NewCounterPartiesPage enterNewLastNameCounterParties(String lastName) {
        lastNameCounterPartiesTextInput.sendKeys(lastName);
        return this;
    }

    public NewCounterPartiesPage enterNewFirstNameCounterParties(String firstName) {
        firstNameCounterPartiesTextInput.sendKeys(firstName);
        return this;
    }

    public NewCounterPartiesPage selectOrganizationOfProject() {
        organizationWindowClick.click();
        organizationSelect.click();
        return this;
    }

    public NewCounterPartiesPage enterNewJobTitleCounterParties(String jobTitle) {
        jobTitleCounterPartiesTextInput.sendKeys(jobTitle);
        return this;
    }

    public CounterPartiesPage clickSubmit() {
        submitButton.click();
        return new CounterPartiesPage(driver);
    }
}
