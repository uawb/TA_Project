package Helpers;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class temp
{
    String url = "http://localhost:3000/";
    RequestSpecification httpRequest;
    Response response;
    @Test
    public void test()
    {
        JSONObject  param = new JSONObject();
        param.put("name" , "Nika");
        param.put("email" , "nika@grafana.com");

        RestAssured.baseURI = url;
        httpRequest = RestAssured.given().auth().preemptive().basic("admin","admin");

        httpRequest.header("Content-Type","application/json");
        httpRequest.body(param.toJSONString());
        response = httpRequest.delete("/api/teams/2");
        System.out.println(response.prettyPrint());
    }
}
