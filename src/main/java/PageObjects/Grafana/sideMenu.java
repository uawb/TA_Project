package PageObjects.Grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class sideMenu
{
    @FindBy(how = How.XPATH,using = "//sidemenu[@class='sidemenu']/a")
    public WebElement sideMenu_LOGO;

    @FindBy(how = How.CLASS_NAME, using = "sidemenu-link")
    public WebElement serverAdmin_btn;

    @FindBy(how = How.XPATH, using = "//sidemenu/div[3]/div[1]/a/span/img")
    public WebElement image_Avatar;
}
