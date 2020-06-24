package ui;

import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;

public class ControlPanel {

    private String initial;

    private Label lableWelcome = new Label("Welcome" + getInitial());

    public Button btn1 = new Button("Schedule");
    public Button btn2 = new Button("View & Edit");
    public Button btn3 = new Button("Mark Calculator");
    public Button btn4 = new Button("Log Out");


    public BorderPane customBorderPane() {
        RowConstraints rowConstraints = new RowConstraints();
        RowConstraints rowConstraints1 = new RowConstraints();
        BorderPane borderPane = new BorderPane();
        AnchorPane anchorPane = new javafx.scene.layout.AnchorPane();
        VBox vBox = new VBox();
        VBox vBoxLabel = new VBox();

        /*==========label==========*/
        lableWelcome.setStyle("-fx-font-family:'Metropolis Extra Bold'; -fx-font-size:18px;");

        /*==========rowConstraints==========*/
        rowConstraints.setPrefHeight(100);
        rowConstraints1.setPrefHeight(340);

        /*==========vBox==========*/
        vBox.setPrefHeight(800);
        vBox.setPrefWidth(200);
        vBox.setSpacing(25);
        vBox.setAlignment(javafx.geometry.Pos.CENTER);
        vBox.setPadding(new Insets(20));
        vBox.getChildren().addAll(btn1, btn2, btn3, btn4);
        vBox.setStyle("-fx-background-color:#f5f5f5;-fx-border-color:#e0e0e0;");

        /*==========vBoxLabel==========*/
        vBoxLabel.setPrefHeight(50);
        vBoxLabel.setPrefWidth(850);
        vBoxLabel.setSpacing(5);
        vBoxLabel.getChildren().add(lableWelcome);
        vBoxLabel.setAlignment(javafx.geometry.Pos.CENTER);
        vBoxLabel.setStyle("-fx-background-color:#e0e0e0;");

        /*==========anchorPane==========*/
        anchorPane.setPrefHeight(400);
        anchorPane.setPrefWidth(850);
        anchorPane.setStyle("-fx-background-color:#f5f5f5; -fx-border-color:#e0e0e0;");

        /*==========buttons==========*/
        btn1.setPrefHeight(32);
        btn2.setPrefHeight(32);
        btn3.setPrefHeight(32);
        btn4.setPrefHeight(32);
        btn1.setPrefWidth(220);
        btn2.setPrefWidth(220);
        btn3.setPrefWidth(220);
        btn4.setPrefWidth(220);

        //**********style**********
        btn1.setStyle("-fx-background-color: #424242; -fx-max-width: 400;-fx-font-family:'Metropolis Extra Bold';");
        btn1.setTextFill(javafx.scene.paint.Color.WHITE);
        btn2.setStyle("-fx-background-color: #424242; -fx-max-width: 400;-fx-font-family:'Metropolis Extra Bold';");
        btn2.setTextFill(javafx.scene.paint.Color.WHITE);
        btn3.setStyle("-fx-background-color: #424242; -fx-max-width: 400;-fx-font-family:'Metropolis Extra Bold';");
        btn3.setTextFill(javafx.scene.paint.Color.WHITE);
        btn4.setStyle("-fx-background-color: #424242; -fx-max-width: 400;-fx-font-family:'Metropolis Extra Bold';");
        btn4.setTextFill(javafx.scene.paint.Color.WHITE);

        btn4.setOnAction(event -> System.exit(1));

        /*==========borderPane==========*/
        borderPane.setPrefWidth(850);
        borderPane.setPrefHeight(600);
        borderPane.setTop(vBoxLabel);
        borderPane.setLeft(vBox);
        borderPane.setCenter(anchorPane);


        return borderPane;
    }

    public void setInitial(String userName) throws java.io.FileNotFoundException {


        try {


            java.io.ObjectInputStream input = new java.io.ObjectInputStream(new java.io.FileInputStream("src/files/" + userName + "/user.txt"));
            backend.SignUp dataObjectSignUp = (backend.SignUp) (input.readObject());


            this.initial = dataObjectSignUp.getInitial();
            System.out.println("ControlPanel setInitial"+this.initial);


        } catch (java.io.IOException | ClassNotFoundException e) {
            System.out.println("Control Panel: getInitial method");
            e.printStackTrace();
        }

    }

    private String getInitial(){
        System.out.println("ControlPanel getInitial"+this.initial);
        return this.initial;
    }

    public ControlPanel(){}


}
