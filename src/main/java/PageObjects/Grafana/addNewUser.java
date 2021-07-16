package PageObjects.Grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class addNewUser
{
    @FindBy(how = How.XPATH, using = "//div[1]/div[2]/div[1]/div/input")
    public WebElement txt_name;
    @FindBy(how = How.XPATH, using = "//div[2]/div[2]/div/div/input")
    public WebElement txt_eMail;
    @FindBy(how = How.XPATH, using = "//div[3]/div[2]/div/div/input")
    public WebElement txt_userName;
    @FindBy(how = How.XPATH, using = "//div[4]/div[2]/div/div/input")
    public WebElement txt_password;
    @FindBy(how = How.CLASS_NAME, using = "css-1emkf9f-button")
    public WebElement createUser_Btn;

    @FindBy(how = How.XPATH, using = "//div[2]/div[1]/div[2]/button[1]")
    public WebElement delete_btn;
    @FindBy(how = How.XPATH, using = "//div/div[1]/div[2]/div/div[2]/div[1]")
    public WebElement confirm_Btn;

}
