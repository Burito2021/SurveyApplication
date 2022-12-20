package application.com;

import io.qameta.allure.Attachment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class MariaDbConnect {


    //Connection conn=null;
    @Attachment()
    public static Connection ConnectMariaDB() {

        String url = "jdbc:mariadb://localhost:3306/Application";
        String username = "root";
        String password = "password";

        System.out.println("Connecting database...");

        try {
            System.out.println("Connected to DB");
            Connection connection = DriverManager.getConnection(url, username, password);
            connection.close();
            return connection;

        } catch (SQLException e) {
            System.out.println("ERROR CONNECTING MARIADB: " + e);

            return null;
        }
    }


    @Attachment()
    public void insertCustomer(String u, String n, String em, String p) {

        String username;
        String note;
        String email;
        String phone;
        username = u;
        note = n;
        email = em;
        phone = p;

        Connection conn = ConnectMariaDB();
        try {
            String query = "insert into CLIENTS (USERNAME,NOTE,EMAIL,PHONE) values ('" + username + "', '" + note + "', '" + email + "','" + phone + "')";

            // create the mysql insert prepared statement
            PreparedStatement preparedStmt = conn.prepareStatement(query);


            // execute the prepared statement

            preparedStmt.execute();
            System.out.println("user added");

        } catch (SQLException e) {
            System.out.println("ERROR INSERTING INTO USERS: " + e);
        }
    }

    public List<Result> customerDisplayByName(String n) throws SQLException {

        try {
            String name;
            name = n;
            String select = "selecting ID  From USERS";
            System.out.println(select);


            String query = "SELECT USERNAME,NOTE,EMAIL,PHONE FROM CLIENTS Where USERNAME LIKE '" + name + "%'";


            Connection conn = ConnectMariaDB();

            Statement st = conn.createStatement();


            ResultSet rs = st.executeQuery(query);
            List<Result> results = new ArrayList<Result>();


            while (rs.next()) {
                Result set = new Result();
                set.setUserName(rs.getString("USERNAME"));
                set.setNotes(rs.getString("NOTE"));
                set.setEmails(rs.getString("EMAIL"));
                set.setPhone(rs.getString("PHONE"));
                results.add(set);

                st.close();


            }
            return results;
        } catch (SQLException e){
            throw new SQLException();

        }
    }

    public List<Result> customerDisplayByDate(String u) throws SQLException {

        try {
            String date;
            date = u;
            String select = "selecting ID  From USERS";
            System.out.println(select);


            System.out.println(date);
            String query = "SELECT USERNAME,NOTE,EMAIL,PHONE FROM CLIENTS Where CREATE_DATE LIKE '%" + date + "%' ORDER BY USERNAME ";


            Connection conn = ConnectMariaDB();

            Statement st = conn.createStatement();


            ResultSet rs = st.executeQuery(query);
            List<Result> results = new ArrayList<Result>();


            while (rs.next()) {
                Result set = new Result();
                set.setUserName(rs.getString("USERNAME"));
                set.setNotes(rs.getString("NOTE"));
                set.setEmails(rs.getString("EMAIL"));
                set.setPhone(rs.getString("PHONE"));
                results.add(set);

                st.close();


            }
            return results;
        } catch (SQLException e){
            throw new SQLException();

        }
        }


    }