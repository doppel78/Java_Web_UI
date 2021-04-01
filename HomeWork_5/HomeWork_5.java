package HomeWork_5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class HomeWork_5 {
    private final String LOGIN_PAGE_URL = "https://crm.geekbrains.space/user/login";
    private final String STUDENT_LOGIN = "Applanatest";
    private final String STUDENT_PASSWORD = "Student2020!";
    private WebDriver driver;
    private JavascriptExecutor jsExecutor;

    @BeforeAll
    public static void setupWebDriverManager() {

        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void beforeTest() {
        setUpDriverSession();
        login();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void createNewProject() {

        navigationTabsVisibilityTest();

        By btnLocator = By.xpath(
                "//*[@id='main-menu']/ul/li[3]/a/span");

        Actions actions = new Actions(driver);

        WebElement menuBtn = driver.findElement(btnLocator);
        actions.moveToElement(menuBtn);

        // Подменю "Мои проекты"
        WebElement subMenu = driver.findElement(By.xpath("//ul/li[3]/ul/li[4]/a/span"));
        actions.moveToElement(subMenu);
        actions.click().build().perform();

        // Кликаем на кнопку "Создать проект"
        driver.findElement(By.xpath("//*[@id='container']/div[1]/div/div/div[2]/div/div/a")).click();

        //  Ждем перехода на страницу "Создать проект", после появления в URL хвоста "/create"
        WebDriverWait waitSixSeconds = new WebDriverWait(driver, 6);
        waitSixSeconds.until(ExpectedConditions.urlContains("/create"));

        // Ввод в поле "Наименование"
        driver.findElement(By.xpath("//div[1]/div[1]/div[2]/input[@type='text']")).sendKeys("Leasing_march2030");

        // Кликаем на меню "Организация" и совершаем выбор (названия меняются постянно)
        driver.findElement(By.xpath("//div[2]/div/div[@class='select2-container select2 input-widget']")).click();
        driver.findElement(By.xpath("//div[6]/ul[2]/li[5]/div")).click();

        // Кликаем на меню "Подразделение" и выбираем "Research & Development"
        Select businessUnitDropDown = new Select(driver.findElement(By.name("crm_project[businessUnit]")));
        businessUnitDropDown.selectByValue("1");

        // Кликаем на меню "Куратор проекта" и выбираем "Ким Юрий"
        Select curatorDropDown = new Select(driver.findElement(By.name("crm_project[curator]")));
        curatorDropDown.selectByValue("40");

        // Кликаем на меню "Администратор" и выбираем "Исаева Анастасия"
        Select administratorDropDown = new Select(driver.findElement(By.name("crm_project[administrator]")));
        administratorDropDown.selectByValue("11");

        // Кликаем на меню "Менеджер" и выбираем "Амелина Светлана"
        Select managerDropDown = new Select(driver.findElement(By.name("crm_project[manager]")));
        managerDropDown.selectByValue("6");

        // Кликаем на меню "Руководитель проекта" и выбираем "Андреев Сергей"
        Select bossDropDown = new Select(driver.findElement(By.name("crm_project[rp]")));
        bossDropDown.selectByValue("57");

        // Нажимаем "Сохранить и закрыть"
        driver.findElement(By.cssSelector("button[class='btn btn-success action-button']")).click();

        //  ВОЗМОЖНЫ ДВА СЦЕНАРИЯ : C наличием дублирования наименования проекта и БЕЗ дублирования

        WebElement warningNonice1 = new WebDriverWait(driver, 15).until(ExpectedConditions.presenceOfElementLocated(By.xpath(
                "//div[1]/div[1]/div[2]/span[@class='validation-failed']")));
        boolean visibleNotice = warningNonice1.isDisplayed();

        if (visibleNotice) {
            // Ввод (повторный) в поле "Наименование" c добавлением случайного числа в "хвост" названия
            Random r = new Random();
            int x = r.nextInt(100 - 50);
            driver.findElement(By.xpath("//div[1]/div[1]/div[2]/input[@type='text']")).clear();
            driver.findElement(By.xpath("//div[1]/div[1]/div[2]/input[@type='text']")).sendKeys("Leasing_march2020" + x);
            // Нажимаем "Сохранить и закрыть"
            driver.findElement(By.cssSelector("button[class='btn btn-success action-button']")).click();
            // Поиск всплывающего сообщения-подтверждения, добавление Assert
            WebElement element = driver.findElement(By.xpath("//div[@class='alert alert-success fade in top-messages ']"));
            Assertions.assertTrue(element.isDisplayed());
            String message = new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath(
                    "//div[@class='alert alert-success fade in top-messages ']/div[@class='message']"))).getText();
            Assertions.assertEquals(message, "Проект сохранен");
        } else {
            // Поиск всплывающего сообщения-подтверждения, добавление Assert
            WebElement element = driver.findElement(By.xpath("//div[@class='alert alert-success fade in top-messages ']"));
            Assertions.assertTrue(element.isDisplayed());
            String message = new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath(
                    "//div[@class='alert alert-success fade in top-messages ']/div[@class='message']"))).getText();
            Assertions.assertEquals(message, "Проект сохранен");
        }
    }


    @Test
    public void createNewContactPerson() {

        navigationTabsVisibilityTest();

        // Наведение мыши на пункт меню "Контрагенты"
        By btnLocator = By.xpath("//*[@id='main-menu']/ul/li[1]/a/span");
        Actions actions = new Actions(driver);
        WebElement menuBtn = driver.findElement(btnLocator);
        actions.moveToElement(menuBtn);

        // Подменю "Контактные лица"
        WebElement subMenu = driver.findElement(By.xpath("//ul/li[1]/ul/li[4]/a/span"));
        actions.moveToElement(subMenu);
        actions.click().build().perform();

        // Кликаем на кнопку "Создать контактное лицо"
        driver.findElement(By.xpath("//*[@id='container']/div[1]/div/div/div[2]/div/div/a")).click();

        //  Ждем перехода на страницу "Создать контактное лицо", после появления в URL хвоста "/create"
        WebDriverWait waitSixSeconds = new WebDriverWait(driver, 6);
        waitSixSeconds.until(ExpectedConditions.urlContains("/create"));

        // Ввод в поле "Фамилия"
        driver.findElement(By.xpath("//div[1]/div[1]/div[2]/input[@name='crm_contact[lastName]']")).sendKeys("Васильев");

        // Ввод в поле "Имя"
        driver.findElement(By.xpath("//div[1]/div[2]/div[2]/input[@name='crm_contact[firstName]']")).sendKeys("Василий");

        // Выбираем позицию в меню "Организация"
        driver.findElement(By.xpath("//div[2]/div/div[@class='select2-container select2 input-widget']")).click();
        driver.findElement(By.xpath("//*[@id='select2-drop']/ul[2]/li[5]/div")).click();

        // Ввод в поле "Должность"
        driver.findElement(By.xpath("//div[2]/div[2]/input[@name='crm_contact[jobTitle]']")).sendKeys("Шахтер");

        // Нажимаем "Сохранить и закрыть"
        driver.findElement(By.cssSelector("button[class='btn btn-success action-button']")).click();

        // Поиск всплывающего сообщения-подтверждения, добавление Assert
        WebElement element = driver.findElement(By.xpath("//div[@class='alert alert-success fade in top-messages ']"));
        Assertions.assertTrue(element.isDisplayed());
        String message = new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath(
                "//div[@class='alert alert-success fade in top-messages ']/div[@class='message']"))).getText();
        Assertions.assertTrue(message.contains("Контактное лицо сохранено"));
    }

    @Test
    public void createNewOrganisation() {

        navigationTabsVisibilityTest();

        // Наведение мыши на пункт меню "Контрагенты"
        By btnLocator = By.xpath("//*[@id='main-menu']/ul/li[1]/a/span");
        Actions actions = new Actions(driver);
        WebElement menuBtn = driver.findElement(btnLocator);
        actions.moveToElement(menuBtn);

        // Подменю "Организации"
        WebElement subMenu = driver.findElement(By.xpath("//ul/li[1]/ul/li[3]/a/span"));
        actions.moveToElement(subMenu);
        actions.click().build().perform();

        // Кликаем на кнопку "Создать организацию"
        driver.findElement(By.xpath("//*[@id='container']/div[1]/div/div/div[2]/div[2]/div/a")).click();

        //  Ждем перехода на страницу "Создать организацию", после появления в URL хвоста "/create"
        WebDriverWait waitSixSeconds = new WebDriverWait(driver, 6);
        waitSixSeconds.until(ExpectedConditions.urlContains("/company/create"));

        // Ввод в поле "Название"
        driver.findElement(By.xpath("//div[1]/div[1]/div[2]/input[@name='crm_company[name]']")).sendKeys("Apple");

        // Ввод в поле "Краткое название"
        driver.findElement(By.xpath("//div[1]/div[2]/div[2]/input[@name='crm_company[shortName]']")).sendKeys("App");

        // Кликаем на меню "Форма собственности" и выбираем "ОАО"
        Select ownershipTypeDropDown = new Select(driver.findElement(By.name("crm_company[ownershipType]")));
        ownershipTypeDropDown.selectByValue("5");

        // Кликаем на меню "Статус" и выбираем "Активный"
        Select statusDropDown = new Select(driver.findElement(By.name("crm_company[status]")));
        statusDropDown.selectByValue("1");

        // находим чекбокс "Тип организации", кликаем на позицию "Партнер"
        WebElement notifyDateHasChangedCheckbox = driver.findElement(By.xpath("//div/div[4]/input[@value='2']"));
        notifyDateHasChangedCheckbox.click();

        // Кликаем на меню "Отрасль" и выбираем "Машиностроение"
        Select industryTypeDropDown = new Select(driver.findElement(By.name("crm_company[industry]")));
        industryTypeDropDown.selectByValue("10");

        // Кликаем на кнопку "Контактная информация" телефоны "+ Добавить адрес"
        driver.findElement(By.xpath("//a[@class='btn add-list-item' and text()='Добавить адрес']/i")).click();
        driver.findElement(By.xpath("//div[2]/input[@name='crm_company[addresses][1][street]']")).sendKeys("San Francisco");
        driver.findElement(By.xpath("//div[2]/input[@name='crm_company[addresses][1][building]']")).sendKeys("5 avenue");

        // Кликаем на кнопку "Контактная информация" телефоны "+ Добавить телефон"
        driver.findElement(By.xpath("//a[@class='btn add-list-item' and text()='Добавить телефон']/i")).click();
        // Ввод данных в поле "Контактная информация" телефоны
        Select phoneTypeDropDown = new Select(driver.findElement(By.name("crm_company[phones][1][type]")));
        phoneTypeDropDown.selectByValue("mobile");
        driver.findElement(By.xpath("//div/div[1]/input[@name='crm_company[phones][1][prefixCode]']")).sendKeys("+1999");
        driver.findElement(By.xpath("//div/div/div[1]/input[@name='crm_company[phones][1][phone]']")).sendKeys("+1888");
        driver.findElement(By.xpath("//div/div/div[1]/input[@name='crm_company[phones][1][internalCode]']")).sendKeys("+1777");

        // Ввод данных в поле "Контактная информация" E-mail
        driver.findElement(By.xpath("//div[2]/div[2]/div[2]/input[@name='crm_company[email]']")).sendKeys("info@apple.com");

        // Кликаем на менюшку "Менеджер" и выбираем "Амелина Светлана"
        Select curatorDropDown = new Select(driver.findElement(By.name("crm_company[manager]")));
        curatorDropDown.selectByValue("6");

        // Нажимаем "Сохранить и закрыть"
        driver.findElement(By.cssSelector("button[class='btn btn-success action-button']")).click();

        //  ВОЗМОЖНЫ ДВА СЦЕНАРИЯ : C наличием дублирования наименования организации и БЕЗ

        WebElement warningWindow = driver.findElement(By.name("crm_company[nameSimilarValuesCheck]"));
        boolean visible = warningWindow.isDisplayed();

        if (visible) {
            // Кликаем на чек "Все равно сохранить", при всплытии окна "Объекты с похожим значением поля "Название"
            WebElement notifySameNameCheckbox = driver.findElement(By.name("crm_company[nameSimilarValuesCheck]"));
            notifySameNameCheckbox.click();
            // Нажимаем "Сохранить и закрыть"
            driver.findElement(By.cssSelector("button[class='btn btn-success action-button']")).click();
            // Поиск всплывающего сообщения-подтверждения, добавление Assert
            WebElement element = driver.findElement(By.xpath("//div[@class='alert alert-success fade in top-messages ']"));
            Assertions.assertTrue(element.isDisplayed());
            String message = new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath(
                    "//div[@class='alert alert-success fade in top-messages ']/div[@class='message']"))).getText();
            Assertions.assertTrue(message.contains("Организация сохранена"));
        } else {
            // Поиск всплывающего сообщения-подтверждения, добавление Assert
            WebElement element = driver.findElement(By.xpath("//div[@class='alert alert-success fade in top-messages ']"));
            Assertions.assertTrue(element.isDisplayed());
            String message = new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath(
                    "//div[@class='alert alert-success fade in top-messages ']/div[@class='message']"))).getText();
            Assertions.assertTrue(message.contains("Организация сохранена"));
        }
    }

    @Test
    public void createHouseHoldAgreement() {

        navigationTabsVisibilityTest();

        // Наведение мыши на пункт меню "Расходы"
        By btnLocator = By.xpath("//*[@id='main-menu']/ul/li[6]/a/span");
        Actions actions = new Actions(driver);
        WebElement menuBtn = driver.findElement(btnLocator);
        actions.moveToElement(menuBtn);

        // Подменю "Хоз.договоры"
        WebElement subMenu = driver.findElement(By.xpath("//ul/li[6]/ul/li[6]/a/span"));
        actions.moveToElement(subMenu);
        actions.click().build().perform();

        // Ждем перехода на страницу "Все Хоз.договоры", после появления в URL хвоста "/create"
        WebDriverWait waitFiveSeconds = new WebDriverWait(driver, 5);
        waitFiveSeconds.until(ExpectedConditions.urlContains("/domcontract"));

        // Кликаем на кнопку "Новый хозяйственный договор"
        driver.findElement(By.xpath("//div[2]//a[@class='btn back icons-holder-text ']")).click();

        //  Ждем перехода на страницу "Договоры/Создать договор", после появления в URL хвоста "/create"
        WebDriverWait waitFewSeconds = new WebDriverWait(driver, 5);
        waitFewSeconds.until(ExpectedConditions.urlContains("/domcontract/create"));

        // Ввод в поле "Нименование" (именно без пропущенной буквы "а" )
        driver.findElement(By.xpath("//div[2]/input[@name='crm_domcontract[name]']"))
                .sendKeys("Договор на уборку снега в июле");

        // Ввод в поле "Внешний номер договора "
        driver.findElement(By.xpath("//div[2]/input[@name='crm_domcontract[externalNumber]']"))
                .sendKeys("123/4/2020");

        // Ввод в поле "Комментарий"
        driver.findElement(By.xpath("//div[2]/input[@name='crm_domcontract[description]']"))
                .sendKeys("Услуги");

        driver.findElement(By.xpath( // выбираем "Дата подписания"
                "//div/div[5]/div[2]/input")).click();
        driver.findElement(By.xpath("//a[text()='26']")).click();  // выбираем 26-е число марта

        // Кликаем на менюшку "Подрядчик" и выбираем "ИП Чебурашка"
        Select contractorDropDown = new Select(driver.findElement(By.name("crm_domcontract[contractor]")));
        contractorDropDown.selectByValue("151");

        // Выбираем "Cтатья расхода", выбираем 23601
        Select expenseDropDown = new Select(driver.findElement(By.name("crm_domcontract[expenditure]")));
        expenseDropDown.selectByValue("10");

        // Нажимаем "Сохранить и закрыть"
        driver.findElement(By.cssSelector("button[class='btn btn-success action-button']")).click();

        //  ВОЗМОЖНЫ ДВА СЦЕНАРИЯ : C наличием дублирования наименования договора и БЕЗ

        WebElement visio = new WebDriverWait(driver, 15).until(ExpectedConditions.presenceOfElementLocated(By.xpath(
                "//span[@class='validation-failed']")));
        boolean visibleAlert = visio.isDisplayed();

        if (visibleAlert) {
            // Ввод (повторный) в поле "Наименование" c добавлением случайного числа в "хвост" названия
            Random r = new Random();
            int x = r.nextInt(100 - 50);
            driver.findElement(By.xpath("//div[2]/input[@name='crm_domcontract[name]']")).clear();
            driver.findElement(By.xpath("//div[2]/input[@name='crm_domcontract[name]']")).sendKeys("Договор" + x);
            // Нажимаем "Сохранить и закрыть"
            driver.findElement(By.cssSelector("button[class='btn btn-success action-button']")).click();
            // Поиск всплывающего сообщения-подтверждения, добавление Assert
            WebElement element = driver.findElement(By.xpath("//div[@class='alert alert-success fade in top-messages ']"));
            Assertions.assertTrue(element.isDisplayed());
            String message = new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath(
                    "//div[@class='alert alert-success fade in top-messages ']/div[@class='message']"))).getText();
            Assertions.assertEquals(message, "Договор сохранен");
        } else {
            // Поиск всплывающего сообщения-подтверждения, добавление Assert
            WebElement element = driver.findElement(By.xpath("//div[@class='alert alert-success fade in top-messages ']"));
            Assertions.assertTrue(element.isDisplayed());
            String message = new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath(
                    "//div[@class='alert alert-success fade in top-messages ']/div[@class='message']"))).getText();
            Assertions.assertEquals(message, "Договор сохранен");
        }


    }

    private void login() {
        driver.get(LOGIN_PAGE_URL);

        WebElement loginTextInput = driver.findElement(By.cssSelector("input[id='prependedInput']"));
        loginTextInput.sendKeys(STUDENT_LOGIN);

        WebElement passwordTextInput = driver.findElement(By.cssSelector(".span2[name='_password']"));
        passwordTextInput.sendKeys(STUDENT_PASSWORD);

        WebElement loginButton = driver.findElement(By.xpath(".//button[@name='_submit']"));
        loginButton.click();

        String userName = driver.findElement(By.xpath("//li[@id='user-menu']/a")).getText();
        Assertions.assertEquals(userName, "Гикбрейнс Студент");
    }

    private void setUpDriverSession() {
        driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void navigationTabsVisibilityTest() {
        ArrayList<String> mainMenuXpathSelectors =
                new ArrayList(Arrays.asList(
                        ".//span[@class='title' and text()='Контрагенты']",
                        ".//span[@class='title' and text()='Проекты']",
                        ".//span[@class='title' and text()='Предпродажи']",
                        ".//span[@class='title' and text()='Продажи']",
                        ".//span[@class='title' and text()='Расходы']",
                        ".//span[@class='title' and text()='Премии']",
                        ".//span[@class='title' and text()='Справочники']",
                        ".//span[@class='title' and text()='Отчеты']",
                        ".//a/span[@class='title' and i[@class='icon-gear']]",
                        ".//span[@class='title' and text()='Помощь']"
                ));

        mainMenuXpathSelectors.forEach(menuItemXpathSelector -> {
            WebElement element = driver.findElement(By.xpath(menuItemXpathSelector));
            Assertions.assertTrue(element.isDisplayed());
        });
    }
}
