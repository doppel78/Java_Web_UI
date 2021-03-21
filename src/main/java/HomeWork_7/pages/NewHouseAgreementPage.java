package HomeWork_7.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import HomeWork_7.base.BaseView;

import java.util.Random;

public class NewHouseAgreementPage extends BaseView {

    @FindBy(xpath = "//div[2]/input[@name='crm_domcontract[name]']")
    private WebElement newAgreementNameTextInput;

    @FindBy(xpath = "//div[2]/input[@name='crm_domcontract[externalNumber]']")
    private WebElement newAgreementNumberTextInput;

    @FindBy(xpath = "//div[2]/input[@name='crm_domcontract[description]']")
    private WebElement newAgreementCommentsTextInput;

    @FindBy(xpath = "//div/div[5]/div[2]/input")
    private WebElement newAgreementDateFieldOpen;

    @FindBy(xpath = "//a[text()='26']")
    private WebElement newAgreementDateChoose;

    @FindBy(name = "crm_domcontract[contractor]")
    private WebElement domcontractDropDownSelect;

    @FindBy(name = "crm_domcontract[expenditure]")
    private WebElement expenditureDropDownSelect;

    @FindBy(css = "button[class='btn btn-success action-button']")
    private WebElement submitButton;

    public NewHouseAgreementPage(WebDriver driver) {

        super(driver);
    }

    @Step(value = "Ввести данные в поле 'Нименование'")
    public NewHouseAgreementPage enterHouseAgreementName() {
        Random r = new Random();
        int x = r.nextInt(100 - 50);
        String name = "Agreement for cleaning service №_" + x;
        newAgreementNameTextInput.sendKeys(name);
        return this;
    }

    @Step(value = "Ввести данные в поле 'Номер договора'")
    public NewHouseAgreementPage enterHouseAgreementNumber(String number) {
        newAgreementNumberTextInput.sendKeys(number);
        return this;
    }

    @Step(value = "Ввести данные в поле 'Комментарий'")
    public NewHouseAgreementPage enterHouseAgreementComment(String comment) {
        newAgreementCommentsTextInput.sendKeys(comment);
        return this;
    }

    @Step(value = "Выбрать и установить значение в меню 'Дата подписания'")
    public NewHouseAgreementPage chooseNewAgreementDate() {
        newAgreementDateFieldOpen.click();
        newAgreementDateChoose.click();
        return this;
    }

    @Step(value = "Выбрать значение в меню 'Подрядчик'")
    public NewHouseAgreementPage selectContractor(int value) {
        Select contractorDropDown = new Select(domcontractDropDownSelect);
        contractorDropDown.selectByValue(String.valueOf(value));
        return this;
    }

    @Step(value = "Выбрать значение в меню 'Статья расхода'")
    public NewHouseAgreementPage selectExpenditure(int value) {
        Select expenditureDropDown = new Select(expenditureDropDownSelect);
        expenditureDropDown.selectByValue(String.valueOf(value));
        return this;
    }

    @Step(value = "Нажать на кнопку 'Сохранить и закрыть'")
    public AllExpensesPage clickSubmit() {
        submitButton.click();
        return new AllExpensesPage(driver);
    }
}
