package application.com;

import io.qameta.allure.Attachment;

import java.sql.SQLException;
import java.util.List;

public class Application {

    public static void main(String args[]) throws SQLException {
        //ConnectDB();
        MariaDbConnect connect = new MariaDbConnect();

    connect.insertCustomer("Barba Shiva","bring a cake to the room","barbar.shiva@gmail.com","380679920267");
      List<Result> resultsByDate = connect.customerDisplayByDate("2022-12-15");
        List<Result> resultsByName = connect.customerDisplayByName("Mike");
     //   System.out.println(resultsByDate);
        System.out.println(resultsByDate);



    }
}
