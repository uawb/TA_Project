package Extensions;

import Utilities.commonOps;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

public class apiActions extends commonOps
{
    @Step("Get Data from Server")
    public static Response get(String parametersValue)
    {
        response = httpRequest.get(parametersValue);
        return response;
    }
    @Step("Extract value from JSON Format")
    public static String extractDataFromJSON(Response response , String path)
    {
        jp = response.jsonPath();
        return jp.get(path).toString();
    }
    @Step("Post Data to Server")
    public static void post(JSONObject param, String resource)
    {
        httpRequest.header("Content-Type","application/json");
        httpRequest.body(param.toJSONString());
        response = httpRequest.post(resource);
        System.out.println(response.prettyPrint());
    }
    @Step("Update Data in Server")
    public static void put(JSONObject param,String resource )
    {
        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(param.toJSONString());
        response = httpRequest.put(resource);
        System.out.println(response.prettyPrint());
    }
    @Step("Delete Data from Server")
    public static void delete(String id)
    {
        response = httpRequest.delete("/api/teams/"+ id);
        System.out.println(response.prettyPrint());
    }
}
