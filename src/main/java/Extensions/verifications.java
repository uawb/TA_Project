package Extensions;

import Utilities.commonOps;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

import static org.testng.Assert.*;

public class verifications extends commonOps
{
    @Step("Verify Text in Element")
    public static void elementText(WebElement element , String expectedResult)
    {
        if(platform.equalsIgnoreCase("web"))
            wait.until(ExpectedConditions.visibilityOf(element));
        if(platform.equalsIgnoreCase("desktop"))
            assertEquals(element.getText().replaceAll("Display is","").trim(), expectedResult);
            else assertEquals(element.getText(), expectedResult);
    }
    @Step("Verify Amount of Elements")
    public static void amountOfElements(List<WebElement> elements , int expectedResult)
    {
        wait.until(ExpectedConditions.visibilityOf(elements.get(elements.size()-1)));
        assertEquals(elements.size(), expectedResult);
    }
    @Step("Verify Element Visually")
    public static void visualElement(WebElement imageElement , String expectedImageName)
    {
        BufferedImage expectedImage = null;
        try
        {
            expectedImage = ImageIO.read(new File(getData("ImageRepository") + expectedImageName + ".png"));
        }
        catch (Exception e)
        {
            System.out.println("Error reading Image File" + e);
        }
        Screenshot imageScreenShot = new AShot().coordsProvider(new WebDriverCoordsProvider()).takeScreenshot(driver, imageElement);
        BufferedImage actualImage = imageScreenShot.getImage();
        diff = imageDiffer.makeDiff(actualImage,expectedImage);
        assertFalse(diff.hasDiff(), "Different Images.");
    }
    @Step("Verify actual and expected Text")
    public static void text(String actualTXT , String expectedTXT )
    {
        assertEquals(actualTXT, expectedTXT);
    }
}
