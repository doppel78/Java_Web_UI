package HomeWork_7.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import HomeWork_7.base.BaseView;

import java.util.Random;

public class NewProjectPage extends BaseView {

    @FindBy(xpath = "//div[1]/div[1]/div[2]/input[@type='text']")
    private WebElement nameOfProjectTextInput;

    @FindBy(xpath = "//div[2]/div/div[@class='select2-container select2 input-widget']")
    private WebElement organizationWindowClick;

    @FindBy(xpath = "//div[6]/ul[2]/li[5]/div")
    private WebElement organizationSelect;

    @FindBy(name = "crm_project[businessUnit]")
    private WebElement businessUnitDropDownSelect;

    @FindBy(name = "crm_project[curator]")
    private WebElement curatorDropDownSelect;

    @FindBy(name = "crm_project[administrator]")
    private WebElement administratorDropDownSelect;

    @FindBy(name = "crm_project[manager]")
    private WebElement managerDropDownSelect;

    @FindBy(name = "crm_project[rp]")
    private WebElement bossDropDownDownSelect;

    @FindBy(css = "button[class='btn btn-success action-button']")
    private WebElement submitButton;


    public NewProjectPage(WebDriver driver) {

        super(driver);
    }

    @Step(value = "Ввести данные в поле 'Нименование'")
    public NewProjectPage enterNewProjectName() {
        Random r = new Random();
        int x = r.nextInt(100 - 50);
        String name = "New Project_" + x;
        nameOfProjectTextInput.sendKeys(name);
        return this;
    }

    @Step(value = "Выбрать значение в меню 'Организация'")
    public NewProjectPage selectOrganizationOfProject() {
        organizationWindowClick.click();
        organizationSelect.click();
        return this;
    }

    @Step(value = "Выбрать значение в меню 'Подразделение'")
    public NewProjectPage selectBusinessUnit(int value) {
        Select businessUnitDropDown = new Select(businessUnitDropDownSelect);
        businessUnitDropDown.selectByValue(String.valueOf(value));
        return this;
    }

    @Step(value = "Выбрать значение в меню 'Куратор проекта'")
    public NewProjectPage selectCurator(int value) {
        Select curatorDropDown = new Select(curatorDropDownSelect);
        curatorDropDown.selectByValue(String.valueOf(value));
        return this;
    }

    @Step(value = "Выбрать значение в меню 'Администратор проекта'")
    public NewProjectPage selectAdministrator(int value) {
        Select administratorDropDown = new Select(administratorDropDownSelect);
        administratorDropDown.selectByValue(String.valueOf(value));
        return this;
    }

    @Step(value = "Выбрать значение в меню 'Менеджер'")
    public NewProjectPage selectManager(int value) {
        Select managerDropDown = new Select(managerDropDownSelect);
        managerDropDown.selectByValue(String.valueOf(value));
        return this;
    }

    @Step(value = "Выбрать значение в меню 'Руководитель проекта'")
    public NewProjectPage selectBoss(int value) {
        Select bosDropDown = new Select(bossDropDownDownSelect);
        bosDropDown.selectByValue(String.valueOf(value));
        return this;
    }

    @Step(value = "Нажать на кнопку 'Сохранить и закрыть'")
    public ProjectsPage clickSubmit() {
        submitButton.click();
        return new ProjectsPage(driver);
    }
}
