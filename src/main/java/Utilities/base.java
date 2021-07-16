package Utilities;


import io.restassured.path.json.JsonPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class base
{
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Actions action;
    public static String platform;

    public static Screenshot imageScreenShot;
    public static ImageDiffer imageDiffer = new ImageDiffer();
    public static ImageDiff diff;

    public static DesiredCapabilities dc = new DesiredCapabilities();

    public static PageObjects.ElectronDemo.electronMainPage electronMain;

    public static PageObjects.Calculator.calculatorMainPage calculatorMain;

    public static PageObjects.Grafana.loginPage grafanaLogin;
    public static PageObjects.Grafana.mainPage grafanaMainHeader;
    public static PageObjects.Grafana.sideMenu grafanaSideMenu;
    public static PageObjects.Grafana.serverAdminMenuPage grafanaServerAdminMenuPage;
    public static PageObjects.Grafana.serverAdminPage grafanaServerAdminPage;
    public static PageObjects.Grafana.addNewUser grafanaAddNewUser;

    public static PageObjects.MortgageCalc.mainPage mortgageCalculator;

    public static RequestSpecification httpRequest;
    public static Response response;
    public static JSONObject requestParameters = new JSONObject();
    public static JsonPath jp;

    public static Connection con;
    public static Statement stm;
    public static ResultSet rs;
}
