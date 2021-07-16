package SanityTests;

import Extensions.uiActions;
import Extensions.verifications;
import Utilities.commonOps;
import WorkFlows.webFlows;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(Utilities.listeners.class)
public class grafanaWeb extends commonOps
{
    @Test(description = "Test_01 : Login to Grafana")
    @Description("Test Description: Login to Grafana Web Application ")
    public void test_01_Login()
    {
        webFlows.login(getData("user"), getData("password"));
        verifications.elementText(grafanaMainHeader.header_ofMainPage, "Welcome to Grafana");
    }
    @Test(description = "Test_02 : Verify Default Users")
    @Description("Test Description : Verify Default Number Of Users (Should be 1)")
    public void test_02_verifyUsers()
    {
        uiActions.mouseHover(grafanaSideMenu.serverAdmin_btn,grafanaServerAdminMenuPage.link_users);
        verifications.amountOfElements(grafanaServerAdminPage.rows,1);
    }
    @Test(description = "Test_03 : Add and Verify New Users")
    @Description("Test Description : Add new User , Verify Exact Amount of Users( Should be 2)")
    public void test_03_add_and_verify_newUser()
    {
        uiActions.mouseHover(grafanaSideMenu.serverAdmin_btn,grafanaServerAdminMenuPage.link_users);
        webFlows.addNewUser("user","user@gmail.com","user","1234");
        verifications.amountOfElements(grafanaServerAdminPage.rows,2);
    }
    @Test(description = "Test_04 : Delete Last User")
    @Description("Test Description : Delete Last User")
    public void test_04_delete_User()
    {
        uiActions.mouseHover(grafanaSideMenu.serverAdmin_btn,grafanaServerAdminMenuPage.link_users);
        webFlows.deleteUser();
    }
    @Test(description = "Test_05 : Verify Avatar")
    @Description("Test Description : Verify Grafana SideMenu Avatar")
    public void test_05_verify_grafana_icon()
    {
        verifications.visualElement(grafanaSideMenu.image_Avatar, "grafanaAvatar");
    }
}
