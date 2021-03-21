package HomeWork_7.pages;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import HomeWork_7.base.BaseView;

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

    @Step("Ввести данные в поле 'Название'")
    public NewCompanyPage enterNewCompanyName() {
        Faker coName = new Faker();                // сделал Имя Компании случайным
        companyNameNewCompanyTextInput.sendKeys(coName.company().name());
        return this;
    }

    @Step("Ввести данные в поле 'Краткое название'")
    public NewCompanyPage enterNewCompanyShortName(String firstName) {
        companyShortNameNewCompanyTextInput.sendKeys(firstName);
        return this;
    }

    @Step(value = "Выбрать значение в меню 'Форма собственности'")
    public NewCompanyPage selectOwnershipType(int value) {
        Select ownershipTypeDropDown = new Select(ownershipTypeDropDownSelect);
        ownershipTypeDropDown.selectByValue(String.valueOf(value));
        return this;
    }

    @Step(value = "Выбрать значение в меню 'Статус'")
    public NewCompanyPage selectCompanyStatus(int value) {
        Select companyStatusDropDown = new Select(statusDropDownSelect);
        companyStatusDropDown.selectByValue(String.valueOf(value));
        return this;
    }

    @Step(value = "Поставить флажок в чекбоксе 'Тип организации'")
    public NewCompanyPage defineOfNewCompanyType() {
        typeOfCompanyCheckBox.click();
        return this;
    }

    @Step(value = "Выбрать значение в меню 'Отрасль'")
    public NewCompanyPage selectIndustryType(int value) {
        Select industryTypeDropDown = new Select(industryDropDownSelect);
        industryTypeDropDown.selectByValue(String.valueOf(value));
        return this;
    }

    @Step(value = "Активировать появление окна 'Адреса'")
    public NewCompanyPage addressNewCompanyFieldActivation() {
        addressNewCompanyFieldActivation.click();
        return this;
    }

    @Step(value = "Ввести данные в поле 'Улица'")
    public NewCompanyPage enterNewCompanyStreetAddress(String address) {
        streetAddressNewCompanyTextInput.sendKeys(address);
        return this;
    }

    @Step(value = "Ввести данные в поле 'Дом'")
    public NewCompanyPage enterNewCompanyBuildingAddress(String building) {
        buildingAddressNewCompanyTextInput.sendKeys(building);
        return this;
    }

    @Step(value = "Активировать появление окна 'Телефоны'")
    public NewCompanyPage telephoneNewCompanyFieldActivation() {
        telephoneNewCompanyFieldActivation.click();
        return this;
    }

    @Step(value = "Выбрать значение в меню 'Укажите тип'")
    public NewCompanyPage selectPhoneType(String phone_type) {
        Select phoneTypeDropDown = new Select(phoneTypeDropDownSelect);
        phoneTypeDropDown.selectByValue(phone_type);
        return this;
    }

    @Step(value = "Ввести данные в поле 'Код'")
    public NewCompanyPage enterNewCompanyPrefixCode(String prefix_code) {
        prefixCodePhoneTextInput.sendKeys(prefix_code);
        return this;
    }

    @Step(value = "Ввести данные в поле 'Номер'")
    public NewCompanyPage enterNewCompanyPhone(String phone) {
        phonePhoneTextInput.sendKeys(phone);
        return this;
    }

    @Step(value = "Ввести данные в поле 'Доб.'")
    public NewCompanyPage enterNewCompanyInternalCode(String internal_code) {
        internalCodePhoneTextInput.sendKeys(internal_code);
        return this;
    }

    @Step(value = "Ввести данные в поле 'E-mail'")
    public NewCompanyPage enterNewCompanyEmail(String e_mail) {
        emailNewCompanyTextInput.sendKeys(e_mail);
        return this;
    }

    @Step(value = "Выбрать значение в меню 'Менеджер'")
    public NewCompanyPage selectNewCompanyManager(int value) {
        Select newCompanyManagerDropDown = new Select(managerNewCompanyDropDownSelect);
        newCompanyManagerDropDown.selectByValue(String.valueOf(value));
        return this;
    }

    @Step(value = "Нажать на кнопку 'Сохранить и закрыть'")
    public CounterPartiesPage clickSubmit() {
        submitButton.click();
        return new CounterPartiesPage(driver);
    }
}
