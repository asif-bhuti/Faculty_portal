package ui;

import javafx.scene.control.*;
import javafx.scene.paint.*;
import javafx.scene.effect.*;

import java.io.*;

public class LoginPage {

    public static String initial;
    private String ID;

    private TextField userName = new TextField();
    private TextField passWord = new javafx.scene.control.PasswordField();
    public Button btnLogin = new Button("Login");
    public Button btnSignup = new Button("Sign Up");
    private DropShadow dropShadow1 = new DropShadow(10, - 5, - 5, Color.WHITE);
    private DropShadow dropShadow2 = new DropShadow(10, 5, 5, Color.rgb(0, 0, 0, 0.1));
    private InnerShadow innerShadow1 = new InnerShadow(10, - 5, - 5, Color.WHITE);
    private InnerShadow innerShadow2 = new InnerShadow(10, 5, 5, Color.rgb(0, 0, 0, 0.1));


    public javafx.scene.layout.GridPane customGridPane() throws java.io.FileNotFoundException {


        //Create UI
        javafx.scene.layout.GridPane gridPane = new javafx.scene.layout.GridPane();
        javafx.scene.layout.HBox hbox = new javafx.scene.layout.HBox();
        javafx.scene.layout.HBox hbox1 = new javafx.scene.layout.HBox();
        javafx.scene.layout.VBox vBox = new javafx.scene.layout.VBox();
        javafx.scene.image.Image userImage = new javafx.scene.image.Image(new java.io.FileInputStream("src/ui/images/User.png"));
        javafx.scene.image.ImageView imageView = new javafx.scene.image.ImageView(userImage);
        javafx.scene.text.Text headerText = new javafx.scene.text.Text("Login");


        dropShadow1.setInput(dropShadow2);
        innerShadow1.setInput(innerShadow2);

        gridPane.setHgap(50);
        gridPane.setVgap(5);
        gridPane.setPrefWidth(600);
        gridPane.setPrefHeight(400);
        gridPane.add(hbox, 0, 0);
        gridPane.add(hbox1, 0, 1);
        javafx.scene.layout.GridPane.setRowSpan(hbox1, 3);
        gridPane.setAlignment(javafx.geometry.Pos.CENTER);
        gridPane.setPrefHeight(400);
        gridPane.setPrefWidth(600);
        javafx.scene.layout.GridPane.setHalignment(btnSignup, javafx.geometry.HPos.CENTER);


        headerText.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        headerText.setFont(javafx.scene.text.Font.font("Metropolis Extra Bold"));
        headerText.setFont(javafx.scene.text.Font.font(30));

        imageView.setFitHeight(60);
        imageView.setFitWidth(60);
        imageView.setPreserveRatio(true);

        btnLogin.setPrefHeight(32);
        btnLogin.setPrefWidth(224);
        btnSignup.setPrefHeight(32);
        btnSignup.setPrefWidth(224);

        userName.setPromptText("Username");
        userName.setAlignment(javafx.geometry.Pos.CENTER);
        passWord.setPromptText("Password");
        passWord.setAlignment(javafx.geometry.Pos.CENTER);

        hbox.getChildren().addAll(imageView, headerText);
        hbox.setAlignment(javafx.geometry.Pos.CENTER);
        hbox.setPrefHeight(100);
        hbox.setPrefWidth(200);
        hbox.setSpacing(20);

        hbox1.getChildren().add(vBox);
        hbox1.setAlignment(javafx.geometry.Pos.CENTER);

        vBox.getChildren().addAll(userName, passWord, btnLogin, btnSignup);
        vBox.setMaxHeight(400);
        vBox.setMaxWidth(400);
        vBox.prefHeight(100);
        vBox.prefWidth(300);
        vBox.setSpacing(20);


        //Set style
        gridPane.setStyle("-fx-background-color: #f5f5f5; -fx-font-family:'Metropolis Bold';");
        userName.setStyle("-fx-background-color: #eeeeee;");
        userName.setEffect(innerShadow1);
        passWord.setStyle("-fx-background-color: #eeeeee;");
        passWord.setEffect(innerShadow1);
        btnLogin.setStyle("-fx-background-color: #607d8b; -fx-max-width: 400;-fx-font-family:'Metropolis Extra Bold';");
        btnLogin.setEffect(dropShadow1);
        btnLogin.setTextFill(javafx.scene.paint.Color.WHITE);
        btnSignup.setStyle("-fx-background-color:#e0e0e0;-fx-max-width: 400;-fx-font-family:'Metropolis Extra Bold';");
        btnSignup.setTextFill(javafx.scene.paint.Color.GRAY);


        return gridPane;
    }

    public boolean userNameIsEmpty() {
        return userName.getText().equals("");
    }

    public boolean passwordIsEmpty() {
        return passWord.getText().equals("");
    }

    public boolean userDateAuthenticate() throws java.io.FileNotFoundException {


        try {


            ObjectInputStream input = new ObjectInputStream(new FileInputStream("src/files/" + userName.getText() + "/user.txt"));
            ControlPanel controlPanel = new ControlPanel();

            backend.SignUp dataObjectSignUp = (backend.SignUp) (input.readObject());
            String username = dataObjectSignUp.getUsername();
            String password = dataObjectSignUp.getPassword();
            controlPanel.setInitial(username);




            return username.equals(userName.getText()) && password.equals(passWord.getText());

        } catch (java.io.IOException | ClassNotFoundException e) {
            System.out.println("Validation method");
            e.printStackTrace();
            return false;
        }

    }


    //===============================Modifiers


    //===============================Accessors


}
