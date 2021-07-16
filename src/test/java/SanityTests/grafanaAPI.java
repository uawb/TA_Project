package SanityTests;

import Extensions.verifications;
import Utilities.commonOps;
import WorkFlows.apiFlows;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class grafanaAPI extends commonOps
{
    @Test(description = "Test_01: Add Team and Verify ")
    @Description("Test Description: Add and Verify Team")
    public void test_01_AddTeamAndVerify()
    {
        apiFlows.postTeam("GTeam", "GTeam@grafana.com");
        verifications.text(apiFlows.getTeamInfo("teams[0].name"),"GTeam");
    }
    @Test(description = "Test_02: Update Team and Verify ")
    @Description("Test Description: Update Team and Verify")
    public void test_02_UpdateTeamAndVerify()
    {
        apiFlows.updateTeam("MyTeam", "GTeam@grafana.com","3");
        verifications.text(apiFlows.getTeamInfo("teams[0].name"),"MyTeam");
    }
    @Test(description = "Test_03: Delete Team and Verify ")
    @Description("Test Description: Delete Team and Verify")
    public void test_03_DeleteTeamAndVerify()
    {
        apiFlows.deleteTeam("3");
        verifications.text(apiFlows.getTeamInfo("totalCount"),"0");
    }
}
