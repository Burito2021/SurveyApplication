package allure.test;


import application.com.MariaDbConnect;
import application.com.Result;
import io.qameta.allure.*;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import static org.junit.Assert.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayName("Storing info into DB check")
@Feature("Module SQL storage")
public class TestCases {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestCases.class.getName());
    MariaDbConnect app = new MariaDbConnect();

    @Test
    @DisplayName("Check the insertion of Customer")
    @Description("first test")
    @Story("Saving user story")
    @Attachment()
    public void user1() throws SQLException {
        String username;
        String note;
        String email;
        String phone;
        username = "GI";
        note = "GI";
        email = "GI@gmail.com";
        phone ="380679920266";
        ArrayList<String> list = new ArrayList<String>();
        list.add(username);
        list.add(note);
        list.add(email);
        list.add(phone);
        app.insertCustomer(username, note, email,phone);
        Methods method = new Methods();

       assertEquals(list, method.checkSelectUsers(username));


    }

    @Test
    @DisplayName("Check the display by name")
    @Story("Displaying")
    @Description("second test")
    public void user2() throws SQLException {
        try {
            String username1;
            String note1;
            String email1;
            String phone1;
            String inputName;
            String username2;
            String note2;
            String email2;
            String phone2;
            username1 = "Minki";
            note1 = "gewew";
            email1 = "barbar.shiva@gmail.com";
            phone1 = "380679920267";
            username2 = "Mike";
            note2 = "Mike";
            email2 = "Mike@gmail.com";
            phone2 = "380679920250";
            inputName ="Mi";
            ArrayList<String> expectedR = new ArrayList<String>();


            expectedR.add(username1);
            expectedR.add(note1);
            expectedR.add(email1);
            expectedR.add(phone1);
            expectedR.add(username2);
            expectedR.add(note2);
            expectedR.add(email2);
            expectedR.add(phone2);
            List<Result> resultsByName = app.customerDisplayByName(inputName);
            ArrayList<String> actualR = new ArrayList<String>();
            for(int x=0; x<app.customerDisplayByName(inputName).size(); x++)
            {
                actualR.add(resultsByName.get(x).getUserName());
                actualR.add(resultsByName.get(x).getNotes());
                actualR.add(resultsByName.get(x).getEmails());
                actualR.add(resultsByName.get(x).getPhone());

            }




             assertEquals(expectedR,actualR);


        } catch (Exception e) {
            throw new SQLException();
        }


    }


    @Test
    @DisplayName("Check the display by date")
    @Story("Displaying")
    @Description("third test")
    public void user3() throws SQLException {
        try {
            String username1;
            String note1;
            String email1;
            String phone1;
            username1 = "Barba Shiva";
            note1 = "gg";
            email1 = "alex@gmail.com";
            phone1 = "380679920267";

            String username2;
            String note2;
            String email2;
            String phone2;
            username2 = "GIg";
            note2 = "GIg";
            email2 = "GI@gmail.com";
            phone2 = "380679920266";
            String InputDate ="2022-12-15";
            ArrayList<String> expectedR = new ArrayList<String>();


            expectedR.add(username1);
            expectedR.add(note1);
            expectedR.add(email1);
            expectedR.add(phone1);
            expectedR.add(username2);
            expectedR.add(note2);
            expectedR.add(email2);
            expectedR.add(phone2);


            List<Result> resultsByName = app.customerDisplayByDate(InputDate);

            ArrayList<String> actualR = new ArrayList<String>();


           for(int x=0; x<app.customerDisplayByDate(InputDate).size(); x++)
            {
                actualR.add(resultsByName.get(x).getUserName());
                actualR.add(resultsByName.get(x).getNotes());
                actualR.add(resultsByName.get(x).getEmails());
                actualR.add(resultsByName.get(x).getPhone());

            }
          assertEquals(expectedR,actualR);
            System.out.println(actualR);
            System.out.println(expectedR);
        } catch (Exception e) {
            throw new SQLException();
        }


    }


   /* @Test
    @DisplayName("Check the display of ordered services")
    @Story("Saving service story")
    @Description("second test")
    public void user3() throws SQLException {
        int service_id;


        app.CustomerDisplay("MI");

        ArrayList<Object> listEntry = new ArrayList<Object>();
        listEntry.add("washing4");
        listEntry.add("washing4");
        listEntry.add("hijacking");
        listEntry.add("hijacking1");

        Methods method = new Methods();
        assertEquals(listEntry, app.CustomerDisplay("MI"));


    }*/

}
