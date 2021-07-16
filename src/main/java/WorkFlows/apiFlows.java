package WorkFlows;

import Extensions.apiActions;
import Utilities.commonOps;
import io.qameta.allure.Step;
import io.restassured.response.Response;

public class apiFlows extends commonOps
{
    @Step("Get Team Info from Grafana")
    public static String getTeamInfo(String jPath)
    {
        Response response = apiActions.get("/api/teams/search");
        return apiActions.extractDataFromJSON(response,jPath);
    }
    @Step("Create New Team")
    public static void postTeam(String name , String email)
    {
        requestParameters.put("name" , name);
        requestParameters.put("email" , email);
        apiActions.post(requestParameters,"/api/teams");
    }
    @Step("Update Team in Grafana")
    public static void updateTeam(String name , String email, String id)
    {
        requestParameters.put("name" , name);
        requestParameters.put("email" , email);
        apiActions.put(requestParameters,"/api/teams/"+ id);
    }
    @Step("Delete Team in Grafana")
    public static void deleteTeam(String id)
    {
        apiActions.delete(id);
    }
}
