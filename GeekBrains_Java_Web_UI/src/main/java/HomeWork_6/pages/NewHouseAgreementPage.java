package HomeWork_6.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import HomeWork_6.base.BaseView;

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

    public NewHouseAgreementPage enterHouseAgreementName() {
        Random r = new Random();
        int x = r.nextInt(100 - 50);
        String name = "Agreement for cleaning service №_" + x;
        newAgreementNameTextInput.sendKeys(name);
        return this;
    }

    public NewHouseAgreementPage enterHouseAgreementNumber(String number) {
        newAgreementNumberTextInput.sendKeys(number);
        return this;
    }

    public NewHouseAgreementPage enterHouseAgreementComment(String comment) {
        newAgreementCommentsTextInput.sendKeys(comment);
        return this;
    }

    public NewHouseAgreementPage chooseNewAgreementDate() {
        newAgreementDateFieldOpen.click();
        newAgreementDateChoose.click();
        return this;
    }

    public NewHouseAgreementPage selectContractor(int value) {
        Select contractorDropDown = new Select(domcontractDropDownSelect);
        contractorDropDown.selectByValue(String.valueOf(value));
        return this;
    }

    public NewHouseAgreementPage selectExpenditure(int value) {
        Select expenditureDropDown = new Select(expenditureDropDownSelect);
        expenditureDropDown.selectByValue(String.valueOf(value));
        return this;
    }

    public AllExpensesPage clickSubmit() {
        submitButton.click();
        return new AllExpensesPage(driver);
    }
}
