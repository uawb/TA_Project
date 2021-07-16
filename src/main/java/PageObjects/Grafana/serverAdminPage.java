package PageObjects.Grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class serverAdminPage
{
    @FindBy(how = How.XPATH, using = "//div/div/div/div[2]/table/tbody/tr")
    public List <WebElement> rows;

    @FindBy(how = How.XPATH, using = "//div/div/div/div[1]/a")
    public WebElement newUser_Btn;
}
