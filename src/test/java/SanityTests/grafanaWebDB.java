package SanityTests;

import Extensions.verifications;
import Utilities.commonOps;
import WorkFlows.webFlows;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(Utilities.listeners.class)
public class grafanaWebDB extends commonOps
{
    @Test(description = "Test_01 : Login to Grafana with Data Base")
    @Description("Test Description: Login to Grafana Web Application  with DB")
    public void test_01_LoginDB()
    {
        webFlows.loginDB();
        verifications.elementText(grafanaMainHeader.header_ofMainPage, "Welcome to Grafana");
    }
}
