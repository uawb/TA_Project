package SanityTests;

import Extensions.verifications;
import Utilities.commonOps;
import WorkFlows.electronFlow;
import WorkFlows.webFlows;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Utilities.listeners.class)
public class electronDemo extends commonOps

{
    @Test(description = "Verify Screen Resolution")
    @Description("Test Description: Extract Resolution from Electron and Verify it ")
    public void test_01_()
    {
       electronFlow.screenInfo();
       verifications.elementText(electronMain.field_screen_info,"Your screen is: 1920px x 1080px");
    }
}
