package PageObjects.Calculator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class calculatorMainPage
{
    @FindBy(how = How.NAME, using = "Clear")
    public WebElement btn_clear;
    @FindBy(how = How.NAME, using = "Six")
    public WebElement btn_six;
    @FindBy(how = How.NAME, using = "Divide by")
    public WebElement btn_divide;
    @FindBy(how = How.NAME, using = "Two")
    public WebElement btn_two;
    @FindBy(how = How.NAME, using = "Equals")
    public WebElement equals_btn;
    @FindBy(how = How.XPATH, using = "//*[@AutomationId='CalculatorResults']")
    public WebElement results;
}
