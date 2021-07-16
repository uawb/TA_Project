package Extensions;

import Utilities.commonOps;
import io.qameta.allure.Step;

import java.util.ArrayList;
import java.util.List;

public class dbActions extends commonOps
{
    @Step("Get Data Base Credentials")
    public static List<String> getDBCredentials(String queryInfo)
    {
        List<String> credentials = new ArrayList<String>();
        try
        {
            rs = stm.executeQuery(queryInfo);
            rs.next();
            credentials.add(rs.getString(1));
            credentials.add(rs.getString(2));
        }
        catch (Exception e )
        {
            System.out.println("Error occured  while taking Table Data , see details : " + e  );
        }
        return credentials;
    }

}
