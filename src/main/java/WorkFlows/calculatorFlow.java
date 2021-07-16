package WorkFlows;

import Extensions.uiActions;
import Utilities.commonOps;
import io.qameta.allure.Step;

public class calculatorFlow extends commonOps
{
    @Step("Calculate Divide")
    public static void getDividingResults()
    {
        uiActions.click(calculatorMain.btn_clear);
        uiActions.click(calculatorMain.btn_six);
        uiActions.click(calculatorMain.btn_divide);
        uiActions.click(calculatorMain.btn_two);
        uiActions.click(calculatorMain.equals_btn);
    }
}
