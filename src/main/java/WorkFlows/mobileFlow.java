package WorkFlows;

import Extensions.uiActions;
import Utilities.commonOps;
import io.qameta.allure.Step;

public class mobileFlow extends commonOps
{
    @Step("Fill in Form and Calculate monthly repayment")
    public static void calculate(String amount , String term , String rate)
    {
        uiActions.updateText(mortgageCalculator.amount_field,amount);
        uiActions.updateText(mortgageCalculator.term_field,term);
        uiActions.updateText(mortgageCalculator.rate_field,rate);
        uiActions.click(mortgageCalculator.calculate_btn);
    }
}
