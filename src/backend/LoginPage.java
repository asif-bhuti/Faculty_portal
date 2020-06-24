package backend;

public class LoginPage implements java.io.Serializable {

    private String userName,passWord;


    public LoginPage(){}

    public LoginPage(String userName, String passWord) {

        this.userName = userName;
        this.passWord = passWord;
    }

}
