package SanityTests;

import Extensions.verifications;
import Utilities.commonOps;
import WorkFlows.mobileFlow;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Utilities.listeners.class)
public class mortgageMobile extends commonOps
{
    @Test(description = "Test 01 = Verify Mortgage Option")
    @Description("Test description: Fill in Fields and Calculate Mortgage Repayment")
    public void test_01_verify_repayment()
    {
        mobileFlow.calculate("10000","5","2");
        verifications.elementText(mortgageCalculator.repayment_amount,"£176,80");
    }
}
