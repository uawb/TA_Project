package Utilities;

import java.sql.DriverManager;

public class manageDataBase extends commonOps
{
    public static void initDBConnection(String dbURL , String user , String password)
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(dbURL,user,password);
            stm = con.createStatement();
        }
        catch (Exception e )
        {
            System.out.println("Error during Connection to DB , see details : " + e);

        }
    }
    public static void closeConnection()
    {
        try
        {
            con.close();
        }
        catch (Exception e)
        {
            System.out.println("Error Occur While Closing DB : " + e);
        }
    }
}
