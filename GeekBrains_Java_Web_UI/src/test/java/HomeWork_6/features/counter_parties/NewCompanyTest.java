package HomeWork_6.features.counter_parties;

import org.junit.jupiter.api.Test;
import HomeWork_6.base.BaseUITest;
import HomeWork_6.common.Configuration;
import HomeWork_6.enums.CounterPartiesSubMenuButtons;
import HomeWork_6.enums.NavigationBarTabs;
import HomeWork_6.pages.CounterPartiesPage;
import HomeWork_6.pages.LoginPage;

public class NewCompanyTest extends BaseUITest {
    @Test
    public void createNewCompanyPositiveTest() {
        CounterPartiesPage companyFrame = (CounterPartiesPage) new LoginPage(driver)
                .authoriseScenario(Configuration.STUDENT_LOGIN, Configuration.STUDENT_PASSWORD)
                .getPageNavigation()
                .moveCursorToNavigationTab(NavigationBarTabs.COUNTER_PARTIES)
                .clickSubMenuButton(CounterPartiesSubMenuButtons.COMPANY);

        companyFrame
                .clickOnCreateNewCompanyButton()
                .enterNewCompanyName()
                .enterNewCompanyShortName("Pepsi Co.")
                .selectOwnershipType(5)
                .selectCompanyStatus(1)
                .defineOfNewCompanyType()
                .selectIndustryType(10)
                .addressNewCompanyFieldActivation()
                .enterNewCompanyStreetAddress("Avvenu")
                .enterNewCompanyBuildingAddress("2021")
                .telephoneNewCompanyFieldActivation()
                .selectPhoneType("mobile")
                .enterNewCompanyPrefixCode("999")
                .enterNewCompanyPhone("888")
                .enterNewCompanyInternalCode("777")
                .enterNewCompanyEmail("info@Pepsi.com")
                .selectNewCompanyManager(6)
                .clickSubmit()
                .checkNewCompanyPopUp();


    }
}
