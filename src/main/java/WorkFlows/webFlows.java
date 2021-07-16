package WorkFlows;

import Extensions.dbActions;
import Extensions.uiActions;
import Utilities.commonOps;
import io.qameta.allure.Step;

import java.util.List;

public class webFlows extends commonOps
{
    @Step("Login Grafana")
    public static void login(String user , String pass)
    {
        uiActions.updateText(grafanaLogin.txt_user_Name,user);
        uiActions.updateText(grafanaLogin.txt_user_Pass,pass);
        uiActions.click(grafanaLogin.log_In_Btn);
        uiActions.click(grafanaLogin.skip_Btn);
    }
    @Step("Login Grafana Flow With DB Credentials")
    public static void loginDB()
    {
        List<String> cred = dbActions.getDBCredentials("SELECT user_name , password FROM Credentials WHERE id = '3'");
        uiActions.updateText(grafanaLogin.txt_user_Name, cred.get(0));
        uiActions.updateText(grafanaLogin.txt_user_Pass, cred.get(1));
        uiActions.click(grafanaLogin.log_In_Btn);
        uiActions.click(grafanaLogin.skip_Btn);
    }
    @Step("Add New User")
    public static void addNewUser(String name , String e_mail , String userName , String password)
    {
        uiActions.click(grafanaServerAdminPage.newUser_Btn);
        uiActions.updateText(grafanaAddNewUser.txt_name,name);
        uiActions.updateText(grafanaAddNewUser.txt_eMail, e_mail);
        uiActions.updateText(grafanaAddNewUser.txt_userName, userName);
        uiActions.updateText(grafanaAddNewUser.txt_password,password);
        uiActions.click(grafanaAddNewUser.createUser_Btn);
    }
    @Step("Delete Last User")
    public static void deleteUser()
    {
        uiActions.click(grafanaServerAdminPage.rows.get(grafanaServerAdminPage.rows.size()-1));
        uiActions.click(grafanaAddNewUser.delete_btn);
        uiActions.click(grafanaAddNewUser.confirm_Btn);
    }
}
