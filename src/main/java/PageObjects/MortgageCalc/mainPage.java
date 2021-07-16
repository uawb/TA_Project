package PageObjects.MortgageCalc;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class mainPage
{
    @FindBy(how = How.ID, using = "etAmount")
    public WebElement amount_field;
    @FindBy(how = How.ID, using = "etTerm")
    public WebElement term_field;
    @FindBy(how = How.ID, using = "etRate")
    public WebElement rate_field;
    @FindBy(how = How.ID,using = "btnCalculate")
    public WebElement calculate_btn;
    @FindBy(how = How.ID,using = "tvRepayment")
    public WebElement repayment_amount;
}
