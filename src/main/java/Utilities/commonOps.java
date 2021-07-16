package Utilities;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.windows.WindowsDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class commonOps extends base
{
    public static String getData (String nodeName)
    {
        DocumentBuilder dBuilder;
        Document doc = null;
        File fXmlFile = new File("./Configuration/DataConfiguration.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try
        {
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
        }
        catch(Exception e)
        {
            System.out.println("Exception in reading XML file: " + e);
        }
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(nodeName).item(0).getTextContent();
    }
    public static void initBrowser(String browserType)
    {
        if(browserType.equalsIgnoreCase("chrome"))
            driver = initChromeDriver();
        else if(browserType.equalsIgnoreCase("firefox"))
            driver = initFFDriver();
        else if(browserType.equalsIgnoreCase("ie"))
            driver = initIEDriver();
        else if(browserType.equalsIgnoreCase("edge"))
            driver = initEDriver();
        else
            throw new RuntimeException(("Invalid platform name."));
        driver.manage().window().maximize();
        driver.navigate().to(getData("URL"));
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("TimeOut")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,Long.parseLong(getData("TimeOut")));
        action = new Actions(driver);
    }
    public static WebDriver initChromeDriver()
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        return driver;
    }
    public static WebDriver initFFDriver()
    {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        return driver;
    }
    public static WebDriver initIEDriver()
    {
        WebDriverManager.iedriver().setup();
        WebDriver driver = new InternetExplorerDriver();
        return driver;
    }
    public static WebDriver initEDriver()
    {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        return driver;
    }
    public static void initAPI()
    {
        RestAssured.baseURI = getData("url_API");
        httpRequest = RestAssured.given().auth().preemptive().basic(getData("user"),getData("password"));
    }
    public static void initElectron()
    {
        System.setProperty("webdriver.chrome.driver",getData("ElectronDriverPath"));
        ChromeOptions opt = new ChromeOptions();
        opt.setBinary(getData("ElectronAppPath"));
        dc.setCapability("chromeOptions", opt);
        dc.setBrowserName("chrome");
        driver = new ChromeDriver(dc);
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("TimeOut")),TimeUnit.SECONDS);
    }
    public static void initDesktop()
    {
        dc.setCapability("app",getData("CalculatorApp"));
        try {
            driver = new WindowsDriver(new URL(getData("AppiumServer")), dc);
        }
        catch (Exception e)
        {
            System.out.println("Cannot Connect to Appium Server , see details :" +e );
        }
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("TimeOut")), TimeUnit.SECONDS);
    }
    public static void initMobile()
    {
        dc.setCapability(MobileCapabilityType.UDID,getData("UDID"));
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,getData("APP_PACKAGE"));
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,getData("APP_ACTIVITY"));
        try {
            driver = new RemoteWebDriver(new URL(getData("mobileURL")), dc);
        } catch (Exception e)
        {
            System.out.println("Can not Connect to Appium , see Details : " + e);
        }
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("TimeOut")),TimeUnit.SECONDS);
    }
    @BeforeClass
    @Parameters({"Platform"})
    public void start(String Platform)
    {
        platform = Platform;

        if(platform.equalsIgnoreCase("web"))
            initBrowser(getData("Browser"));
        else if (platform.equalsIgnoreCase("mobile"))
            initMobile();
        else if (platform.equalsIgnoreCase("api"))
            initAPI();
        else if (platform.equalsIgnoreCase("electron"))
            initElectron();
        else if(platform.equalsIgnoreCase(("desktop")))
            initDesktop();

        else
            throw new RuntimeException(("Invalid platform name."));

        managePages.init();

        manageDataBase.initDBConnection(getData("dbURL"),getData("dbUser"),getData("dbPassword"));
    }
    @AfterMethod
    public void after_method()
    {
        if(platform.equalsIgnoreCase("web"))
        driver.get(getData("AfterMethodURL"));
    }
    @AfterClass
    public void close()
    {
        if(!platform.equalsIgnoreCase("api"))
        driver.quit();
        manageDataBase.closeConnection();
    }
}
