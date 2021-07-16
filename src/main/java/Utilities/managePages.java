package Utilities;

import org.openqa.selenium.support.PageFactory;

public class managePages extends base
{
    public static void init()
    {
        grafanaLogin = PageFactory.initElements(driver, PageObjects.Grafana.loginPage.class);
        grafanaMainHeader = PageFactory.initElements(driver,PageObjects.Grafana.mainPage.class);
        grafanaSideMenu = PageFactory.initElements(driver,PageObjects.Grafana.sideMenu.class);
        grafanaServerAdminMenuPage = PageFactory.initElements(driver,PageObjects.Grafana.serverAdminMenuPage.class);
        grafanaServerAdminPage = PageFactory.initElements(driver, PageObjects.Grafana.serverAdminPage.class);
        grafanaAddNewUser = PageFactory.initElements(driver, PageObjects.Grafana.addNewUser.class);

        mortgageCalculator = PageFactory.initElements(driver,PageObjects.MortgageCalc.mainPage.class);

        electronMain = PageFactory.initElements(driver,PageObjects.ElectronDemo.electronMainPage.class);

        calculatorMain = PageFactory.initElements(driver, PageObjects.Calculator.calculatorMainPage.class);
    }
}
