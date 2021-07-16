package Extensions;

import Utilities.commonOps;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class uiActions extends commonOps
{
    @Step("Click on element")
    public static void click(WebElement element)
    {
        if(platform.equalsIgnoreCase("web"))
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }
    @Step("Refill text rows")
    public static void updateText(WebElement element , String value)
    {
        if(platform.equalsIgnoreCase("web"))
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(value);
    }
    @Step("Update DropDown Field")
    public static void updateDropDown(WebElement element , String value)
    {
        wait.until(ExpectedConditions.visibilityOf(element));
        Select inputValue = new Select(element);
        inputValue.selectByVisibleText(value);
    }
    @Step("MouseHover to Element")
    public static void mouseHover(WebElement element1 , WebElement element2)
    {
        action.moveToElement(element1).moveToElement(element2).click().build().perform();
    }
}
