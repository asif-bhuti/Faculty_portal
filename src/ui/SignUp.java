package ui;

import javafx.scene.control.*;
import javafx.scene.paint.*;
import javafx.scene.effect.*;
import javafx.scene.layout.*;
import javafx.scene.image.*;
import javafx.scene.text.*;
import java.io.*;

public class SignUp {

    javafx.scene.control.Alert alertUserAlreadyExists = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.NONE,"User already Exists", javafx.scene.control.ButtonType.OK);

    private TextField initial = new TextField();
    private TextField ID = new TextField();
    public TextField userName = new TextField();
    private TextField passWord = new javafx.scene.control.PasswordField();
    private TextField confirmPassWord = new javafx.scene.control.PasswordField();
    public Button btnSignup = new Button("Sign Up");
    public Button btnLogin = new Button("Login");
    private DropShadow dropShadow1 = new DropShadow(10, - 5, - 5, Color.WHITE);
    private DropShadow dropShadow2 = new DropShadow(10, 5, 5, Color.rgb(0, 0, 0, 0.1));
    private InnerShadow innerShadow1 = new InnerShadow(10, - 5, - 5, Color.WHITE);
    private InnerShadow innerShadow2 = new InnerShadow(10, 5, 5, Color.rgb(0, 0, 0, 0.1));


    public javafx.scene.layout.GridPane customGridPane() throws java.io.FileNotFoundException {


        //Create UI
        GridPane gridPane = new javafx.scene.layout.GridPane();
        HBox hbox = new javafx.scene.layout.HBox();
        HBox hbox1 = new javafx.scene.layout.HBox();
        VBox vBox = new javafx.scene.layout.VBox();
        Image userImage = new javafx.scene.image.Image(new java.io.FileInputStream("src/ui/images/User.png"));
        ImageView imageView = new javafx.scene.image.ImageView(userImage);
        Text headerText = new javafx.scene.text.Text("Sign Up");


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
        GridPane.setHalignment(btnSignup, javafx.geometry.HPos.CENTER);


        headerText.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        headerText.setFont(javafx.scene.text.Font.font("Metropolis Extra Bold"));
        headerText.setFont(javafx.scene.text.Font.font(30));

        imageView.setFitHeight(60);
        imageView.setFitWidth(60);
        imageView.setPreserveRatio(true);

        btnSignup.setPrefHeight(32);
        btnSignup.setPrefWidth(224);
        btnLogin.setPrefHeight(32);
        btnLogin.setPrefWidth(224);

        userName.setPromptText("Username");
        initial.setPromptText("Your Initial");
        initial.setText("Your Initial");
        ID.setPromptText("Your ID");
        userName.setAlignment(javafx.geometry.Pos.CENTER);
        initial.setAlignment(javafx.geometry.Pos.CENTER);
        ID.setAlignment(javafx.geometry.Pos.CENTER);
        passWord.setPromptText("Password");
        confirmPassWord.setPromptText("Confirm Password");
        passWord.setAlignment(javafx.geometry.Pos.CENTER);
        confirmPassWord.setAlignment(javafx.geometry.Pos.CENTER);

        hbox.getChildren().addAll(imageView, headerText);
        hbox.setAlignment(javafx.geometry.Pos.CENTER);
        hbox.setPrefHeight(100);
        hbox.setPrefWidth(200);
        hbox.setSpacing(20);

        hbox1.getChildren().add(vBox);
        hbox1.setAlignment(javafx.geometry.Pos.CENTER);

        vBox.getChildren().addAll(initial, ID, userName, passWord, confirmPassWord, btnSignup, btnLogin);
        vBox.setMaxHeight(400);
        vBox.setMaxWidth(400);
        vBox.prefHeight(100);
        vBox.prefWidth(300);
        vBox.setSpacing(20);


        //Set style
        gridPane.setStyle("-fx-background-color: #f5f5f5; -fx-font-family:'Metropolis Bold';");
        userName.setStyle("-fx-background-color: #eeeeee;");
        initial.setStyle("-fx-background-color: #eeeeee;");
        ID.setStyle("-fx-background-color: #eeeeee;");
        initial.setEffect(innerShadow1);
        ID.setEffect(innerShadow1);
        userName.setEffect(innerShadow1);
        passWord.setStyle("-fx-background-color: #eeeeee;");
        confirmPassWord.setStyle("-fx-background-color: #eeeeee;");
        passWord.setEffect(innerShadow1);
        confirmPassWord.setEffect(innerShadow1);
        btnSignup.setStyle("-fx-background-color: #424242; -fx-max-width: 400;-fx-font-family:'Metropolis Extra Bold';");
        btnSignup.setTextFill(javafx.scene.paint.Color.WHITE);
        btnLogin.setStyle("-fx-background-color:#e0e0e0;-fx-max-width: 400;-fx-font-family:'Metropolis Extra Bold';");
        btnLogin.setTextFill(javafx.scene.paint.Color.GRAY);

        return gridPane;
    }

    public boolean textFieldIsEmpty() {
        return initial.getText().equals("") || ID.getText().equals("") || userName.getText().equals("") || passWord.getText().equals("") || confirmPassWord.getText().equals("");
    }


    public boolean passwordConformation() {
        String password1 = passWord.getText();
        String password2 = confirmPassWord.getText();

        return password1.equals(password2);
    }

    public boolean passwordIsShort() {
        return passWord.getText().length() < 4;
    }

    public void storeData() throws java.io.FileNotFoundException {

        backend.SignUp signUp  = new backend.SignUp(initial.getText(),ID.getText(),userName.getText(),passWord.getText());

        boolean makeFile = new java.io.File("src/files/" + userName.getText()).mkdirs();
        if (makeFile) System.out.println("File created");
        else alertUserAlreadyExists.show();

        java.io.File file = new java.io.File("src/files/" + userName.getText() + "/user.txt");


        try {
            java.io.ObjectOutputStream output = new java.io.ObjectOutputStream(new java.io.FileOutputStream("src/files/"+userName.getText()+"/user.txt"));
            output.writeObject(signUp);
            output.close();

        } catch (java.io.IOException e) {
            System.out.println("IOException found");
        }
    }

}
