package backend;

import java.util.*;
import java.io.*;

public class SignUp implements java.io.Serializable {
    private String initial;
    private String ID;
    private String username;
    private String password;

    public SignUp() {}

    public SignUp(String initial, String ID, String username, String password) throws java.io.FileNotFoundException {
        this.initial = initial;
        this.ID = ID;
        this.username = username;
        this.password = password;
    }

    /*================================================Accessors=============================================*/
    public String getInitial() {
        return initial;
    }

    public String getUsername() {
        return username;
    }

    public String getID() {
        return ID;
    }

    public String getPassword() {
        return password;
    }

}
