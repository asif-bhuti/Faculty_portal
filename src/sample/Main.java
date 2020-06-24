package sample;

import javafx.application.*;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class Main extends Application {

    private Stage window;

    @Override //Override the start method in the Application class
    public void start(Stage primaryStage) throws Exception {

        /*================================Objects==========================================*/
        ui.LoginPage login = new ui.LoginPage();
        ui.SignUp signUp = new ui.SignUp();
        ui.Welcome welcome = new ui.Welcome();
        ui.ControlPanel controlPanel = new ui.ControlPanel();
        ui.SelectCourses selectCourses = new ui.SelectCourses();
        backend.Courses courses = new backend.Courses();

        /*================================Alerts==========================================*/
        Alert alertLoginUsername = new Alert(Alert.AlertType.NONE, "Please Enter Username.", ButtonType.OK);
        Alert alertLoginPassword = new Alert(Alert.AlertType.NONE, "Please Enter Password.", ButtonType.OK);
        Alert alertLoginInvalidUserOrPass = new Alert(Alert.AlertType.NONE, "Invalid Username or Password.", ButtonType.OK);
        Alert alertSigUpTextFieldIsEmpty = new Alert(Alert.AlertType.NONE, "Please Enter All The Information.", ButtonType.OK);
        Alert alertSigUpPasswordMissMatch = new Alert(Alert.AlertType.NONE, "Confirmation Password Did Not Match.", ButtonType.OK);
        Alert alertSignUpPassword = new Alert(Alert.AlertType.NONE, "Password Is Too Short.", ButtonType.OK);


        /*===================================Buttons========================================*/

        /*++++++++++Welcome++++++++++*/
        welcome.welcomeLogin.setOnAction(e -> {
            try {
                window.setScene(new javafx.scene.Scene(login.customGridPane(), 850, 600));
            } catch (java.io.FileNotFoundException ex) {
                ex.printStackTrace();
            }
        });
        welcome.welcomeSignUp.setOnAction(e -> {
            try {
                window.setScene(new javafx.scene.Scene(signUp.customGridPane(), 850, 600));
            } catch (java.io.FileNotFoundException ex) {
                ex.printStackTrace();
            }
        });

        /*++++++++++SignUp++++++++++*/
        signUp.btnSignup.setOnAction(e -> {
            if (signUp.textFieldIsEmpty()) alertSigUpTextFieldIsEmpty.show();
            else if (! signUp.passwordConformation()) alertSigUpPasswordMissMatch.show();
            else if (signUp.passwordIsShort()) alertSignUpPassword.show();
            else {
                try {
                    signUp.storeData();
                } catch (java.io.FileNotFoundException ex) {
                    System.out.println("FileNotFoundException found");
                }
                window.setScene(new Scene(selectCourses.customBorderPane(), 850, 600));
            }
        });
        signUp.btnLogin.setOnAction(e -> {
            try {
                window.setScene(new javafx.scene.Scene(login.customGridPane(), 850, 600));
            } catch (java.io.FileNotFoundException ex) {
                ex.printStackTrace();
            }
        });

        /*++++++++++Login++++++++++*/
        login.btnSignup.setOnAction(e -> {
            try {
                window.setScene(new javafx.scene.Scene(signUp.customGridPane(), 850, 600));
            } catch (java.io.FileNotFoundException ex) {
                ex.printStackTrace();
            }
        });

        login.btnLogin.setOnAction(e -> {
            if (login.userNameIsEmpty()) alertLoginUsername.show();
            else if (login.passwordIsEmpty()) alertLoginPassword.show();
            else {
                try {
                    if (login.userDateAuthenticate())
                        window.setScene(new javafx.scene.Scene(controlPanel.customBorderPane(), 850, 600));
                    else alertLoginInvalidUserOrPass.show();
                } catch (java.io.FileNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });

        /*++++++++++selectCourses++++++++++*/
        selectCourses.btn.setOnAction(event -> {

            //collecting values
            new backend.Courses(selectCourses.comboBoxCourse1.getValue(), selectCourses.comboBoxCourse2.getValue(), selectCourses.comboBoxCourse3.getValue());

            //storing data
            try {
                java.io.ObjectOutputStream output = new java.io.ObjectOutputStream(new java.io.FileOutputStream("src/files/" + signUp.userName.getText() + "/courses.txt"));
                output.writeObject(courses);
                output.close();

            } catch (java.io.IOException e) {
                System.out.println("IOException found");
            }

            //creating new scene
            window.setScene(new Scene(controlPanel.customBorderPane(), 850, 600));
        });

        /*===================================Stage========================================*/
        window = primaryStage;
        window.setTitle("Faculty Portal");
        window.setScene(new Scene(welcome.customGridPane(), 850, 600));
        window.initStyle(javafx.stage.StageStyle.UTILITY);
        window.setResizable(false);
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}