package HomeWork_6.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import HomeWork_6.base.BaseView;

import java.util.Random;

public class NewCompanyPage extends BaseView {

    @FindBy(xpath = "//div[1]/div[1]/div[2]/input[@name='crm_company[name]']")
    private WebElement companyNameNewCompanyTextInput;

    @FindBy(xpath = "//div[1]/div[2]/div[2]/input[@name='crm_company[shortName]']")
    private WebElement companyShortNameNewCompanyTextInput;

    @FindBy(name = "crm_company[ownershipType]")
    private WebElement ownershipTypeDropDownSelect;

    @FindBy(name = "crm_company[status]")
    private WebElement statusDropDownSelect;

    @FindBy(xpath = "//div/div[4]/input[@value='2']")
    private WebElement typeOfCompanyCheckBox;

    @FindBy(name = "crm_company[industry]")
    private WebElement industryDropDownSelect;

    @FindBy(xpath = "//a[@class='btn add-list-item' and text()='Добавить адрес']/i")
    private WebElement addressNewCompanyFieldActivation;

    @FindBy(xpath = "//div[2]/input[@name='crm_company[addresses][1][street]']")
    private WebElement streetAddressNewCompanyTextInput;

    @FindBy(xpath = "//div[2]/input[@name='crm_company[addresses][1][building]']")
    private WebElement buildingAddressNewCompanyTextInput;

    @FindBy(xpath = "//a[@class='btn add-list-item' and text()='Добавить телефон']/i")
    private WebElement telephoneNewCompanyFieldActivation;

    @FindBy(name = "crm_company[phones][1][type]")
    private WebElement phoneTypeDropDownSelect;

    @FindBy(xpath = "//div/div[1]/input[@name='crm_company[phones][1][prefixCode]']")
    private WebElement prefixCodePhoneTextInput;

    @FindBy(xpath = "//div/div/div[1]/input[@name='crm_company[phones][1][phone]']")
    private WebElement phonePhoneTextInput;

    @FindBy(xpath = "//div/div/div[1]/input[@name='crm_company[phones][1][internalCode]']")
    private WebElement internalCodePhoneTextInput;

    @FindBy(xpath = "//div[2]/div[2]/div[2]/input[@name='crm_company[email]']")
    private WebElement emailNewCompanyTextInput;

    @FindBy(name = "crm_company[manager]")
    private WebElement managerNewCompanyDropDownSelect;

    @FindBy(css = "button[class='btn btn-success action-button']")
    private WebElement submitButton;

    public NewCompanyPage(WebDriver driver) {
        super(driver);
    }

    public NewCompanyPage enterNewCompanyName() {
        Random r = new Random();
        int x = r.nextInt(100 - 50);
        String name = "JSC BigMac#__" + x;
        companyNameNewCompanyTextInput.sendKeys(name);
        return this;
    }

    public NewCompanyPage enterNewCompanyShortName(String firstName) {
        companyShortNameNewCompanyTextInput.sendKeys(firstName);
        return this;
    }

    public NewCompanyPage selectOwnershipType(int value) {
        Select ownershipTypeDropDown = new Select(ownershipTypeDropDownSelect);
        ownershipTypeDropDown.selectByValue(String.valueOf(value));
        return this;
    }

    public NewCompanyPage selectCompanyStatus(int value) {
        Select companyStatusDropDown = new Select(statusDropDownSelect);
        companyStatusDropDown.selectByValue(String.valueOf(value));
        return this;
    }

    public NewCompanyPage defineOfNewCompanyType() {
        typeOfCompanyCheckBox.click();
        return this;
    }

    public NewCompanyPage selectIndustryType(int value) {
        Select industryTypeDropDown = new Select(industryDropDownSelect);
        industryTypeDropDown.selectByValue(String.valueOf(value));
        return this;
    }

    public NewCompanyPage addressNewCompanyFieldActivation() {
        addressNewCompanyFieldActivation.click();
        return this;
    }

    public NewCompanyPage enterNewCompanyStreetAddress(String address) {
        streetAddressNewCompanyTextInput.sendKeys(address);
        return this;
    }

    public NewCompanyPage enterNewCompanyBuildingAddress(String building) {
        buildingAddressNewCompanyTextInput.sendKeys(building);
        return this;
    }

    public NewCompanyPage telephoneNewCompanyFieldActivation() {
        telephoneNewCompanyFieldActivation.click();
        return this;
    }

    public NewCompanyPage selectPhoneType(String phone_type) {
        Select phoneTypeDropDown = new Select(phoneTypeDropDownSelect);
        phoneTypeDropDown.selectByValue(phone_type);
        return this;
    }

    public NewCompanyPage enterNewCompanyPrefixCode(String prefix_code) {
        prefixCodePhoneTextInput.sendKeys(prefix_code);
        return this;
    }

    public NewCompanyPage enterNewCompanyPhone(String phone) {
        phonePhoneTextInput.sendKeys(phone);
        return this;
    }

    public NewCompanyPage enterNewCompanyInternalCode(String internal_code) {
        internalCodePhoneTextInput.sendKeys(internal_code);
        return this;
    }

    public NewCompanyPage enterNewCompanyEmail(String e_mail) {
        emailNewCompanyTextInput.sendKeys(e_mail);
        return this;
    }

    public NewCompanyPage selectNewCompanyManager(int value) {
        Select newCompanyManagerDropDown = new Select(managerNewCompanyDropDownSelect);
        newCompanyManagerDropDown.selectByValue(String.valueOf(value));
        return this;
    }

    public CounterPartiesPage clickSubmit() {
        submitButton.click();
        return new CounterPartiesPage(driver);
    }
}
