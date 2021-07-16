package PageObjects.Grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class loginPage
{
    @FindBy(how = How.NAME, using = "user")
    public WebElement txt_user_Name;
    @FindBy(how = How.NAME, using = "password")
    public WebElement txt_user_Pass;
    @FindBy(how = How.CSS, using = "button[type='submit']")
    public WebElement log_In_Btn;
    @FindBy(how = How.CSS, using = "a[class='btn btn-link']")
    public WebElement skip_Btn;
}
