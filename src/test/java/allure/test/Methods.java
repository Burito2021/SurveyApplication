package allure.test;
import java.util.ArrayList;

import java.sql.*;

public class Methods {


    public static Connection ConnectMariaDB(){

        String url = "jdbc:mariadb://localhost:3306/Application";
        String username = "root";
        String password = "password";

        System.out.println("Connecting database...");

        try {
            System.out.println("Connected to DB");
            Connection connection = DriverManager.getConnection(url, username, password);
            return connection;
            //connection.close();
        } catch (SQLException e) {
            System.out.println("ERROR CONNECTING MARIADB: "+e);

            return null;
        }
    }

    public ArrayList<String> checkSelectUsers(String t)  {
       try {
           String select = "selecting USERNAME  From USERS";
           System.out.println(select);
           String username = t;
           // our SQL SELECT query.
           // if you only need a few columns, specify them by name instead of using "*"
           String query = "SELECT ID, USERNAME, NOTE, EMAIL, PHONE FROM CLIENTS Where USERNAME = '" + username + "' ORDER BY ID DESC LIMIT 1";


           Connection conn = ConnectMariaDB();
           // create the java statement
           Statement st = conn.createStatement();

           // execute the query, and get a java resultset
           ResultSet rs = st.executeQuery(query);

           // iterate through the java resultset

           ArrayList<String> listActual = new ArrayList<String>();
           while (rs.next()) {
               listActual.add(rs.getString("USERNAME"));
               listActual.add(rs.getString("NOTE"));
               listActual.add(rs.getString("EMAIL"));
               listActual.add(rs.getString("PHONE"));

               // print the results

           }
           st.close();
           // return the results
           return listActual;
       }
       catch (SQLException e){
           System.out.println("SQL" +e);
       }

        return null;


    }



}
