/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnectionTest;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Santosh
 */
public class SQLConnection 
{
    public static  Connection getConnection()throws Exception
    {
        String driver="com.mysql.jdbc.Driver";
        String url="jdbc:mysql://localhost:3306/inventory?autoReconnect=true&useSSL=false";        
        String uname="root";
        String pass="";
        Class.forName(driver);
        Connection con=(Connection) DriverManager.getConnection(url,uname,pass);
        return con;
    }   
}
