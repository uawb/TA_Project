package Helpers;

import Utilities.commonOps;
import Utilities.helperMethods;
import WorkFlows.webFlows;
import org.testng.annotations.Test;

public class visualTesting  extends commonOps
{
    @Test
    public void createScreenShot()
    {
        webFlows.login("admin","admin");

        helperMethods.createElementScreenShot(grafanaSideMenu.image_Avatar,"grafanaAvatar");
    }
}
