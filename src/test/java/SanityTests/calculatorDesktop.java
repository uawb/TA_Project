package SanityTests;

import Extensions.verifications;
import Utilities.commonOps;
import WorkFlows.calculatorFlow;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Utilities.listeners.class)
public class calculatorDesktop extends commonOps
{
    @Test(description = "Test_01 : Verify Divide Command")
    @Description("Test Description : Verify Divide Command In Calculator")
    public void test_01_divide()
    {
        calculatorFlow.getDividingResults();
        verifications.elementText(calculatorMain.results,"3");
    }
}
