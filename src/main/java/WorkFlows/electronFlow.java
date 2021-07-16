package WorkFlows;

import Extensions.uiActions;
import Utilities.commonOps;
import io.qameta.allure.Step;

public class electronFlow extends commonOps
{
    @Step("Get Screen Info (Resolution)")
    public static void screenInfo()
    {
        uiActions.click(electronMain.btn_windows);
        uiActions.click(electronMain.btn_Info);
        uiActions.click(electronMain.screen_info_toggle);
        uiActions.click(electronMain.viewScreen_demo_btn);
    }
}
