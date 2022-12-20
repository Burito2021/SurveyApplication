package application.com;
import java.util.List;

public class Result {
    String username;
    String note;
    String email;
    String phone;


    public String getUserName (){
        return username;
    }


    public void setUserName(String username) {
        this.username = username;
    }



    public String getNotes() {
        return note;
    }
    public void setNotes(String note) {
        this.note = note;
    }

    public String getEmails() {
        return email;
    }
    public void setEmails(String email) {
        this.email = email;
        System.out.println(email);
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }



    @Override
    public String toString() {
        return "Result{" +
                "username='" + username + '\'' +
                ", note='" + note + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }
}
