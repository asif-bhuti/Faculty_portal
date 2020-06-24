package ui;

import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.text.*;
import javafx.collections.*;

public class SelectCourses {

    public Button btn = new Button("Continue");

    public ComboBox<String> comboBoxCourse1 = new ComboBox<String>();
    public ComboBox<String> comboBoxCourse2 = new ComboBox<String>();
    public ComboBox<String> comboBoxCourse3 = new ComboBox<String>();

    private Label getSelectCourses() {
        Label label = new Label("Select Courses");

        label.setFont(Font.font("Metropolis Extra Bold", 24));
        label.setTextFill(javafx.scene.paint.Color.WHITESMOKE);

        return label;
    }


    private HBox getHBox() {
        HBox hBox = new HBox();

        hBox.getChildren().add(getSelectCourses());
        hBox.setAlignment(javafx.geometry.Pos.CENTER);
        hBox.setStyle("-fx-background-color:#424242;");
        hBox.setPrefWidth(850);
        hBox.setPrefHeight(100);

        return hBox;
    }


    public BorderPane customBorderPane() {
        BorderPane borderPane = new BorderPane();

        VBox vBox = new VBox(15);


        //===========================ComboBox
        comboBoxCourse1.setPromptText("Course 1");
        comboBoxCourse2.setPromptText("Course 2");
        comboBoxCourse3.setPromptText("Course 3");

        comboBoxCourse1.setPrefWidth(200);
        comboBoxCourse2.setPrefWidth(200);
        comboBoxCourse3.setPrefWidth(200);

        comboBoxCourse1.setStyle("-fx-background-color: #e0e0e0;");
        comboBoxCourse2.setStyle("-fx-background-color: #e0e0e0;");
        comboBoxCourse3.setStyle("-fx-background-color: #e0e0e0;");

        comboBoxCourse1.setItems(FXCollections.observableArrayList("CSE 215.1", "CSE 215.1L", "MAT 116.1", "ENG 105.1"));
        comboBoxCourse2.setItems(FXCollections.observableArrayList("CSE 215.2", "CSE 215.2L", "MAT 116.2", "ENG 105.2"));
        comboBoxCourse3.setItems(FXCollections.observableArrayList("CSE 215.3", "CSE 215.3L", "MAT 116.3", "ENG 105.3"));

        //===========================VBox
        vBox.setAlignment(javafx.geometry.Pos.CENTER);
        vBox.setPrefHeight(500);
        vBox.setPrefWidth(850);
        vBox.getChildren().addAll(comboBoxCourse1, comboBoxCourse2, comboBoxCourse3, btn);
        javafx.scene.layout.VBox.setMargin(btn, new javafx.geometry.Insets(50));

        //===========================Button
        btn.setPrefHeight(30);
        btn.setPrefWidth(200);
        btn.setStyle("-fx-background-color: #424242; -fx-font-family:'Metropolis Extra Bold';");
        btn.setTextFill(javafx.scene.paint.Color.WHITE);
        /*btn.setOnAction(event -> {
            String value1 = (String) comboBoxCourse1.getValue();
            String value2 = (String) comboBoxCourse2.getValue();
            String value3 = (String) comboBoxCourse3.getValue();
            String value4 = (String) comboBoxCourse4.getValue();

            System.out.println(value1);
            System.out.println(value2);
            System.out.println(value3);
            System.out.println(value4);
        });*/

        //===========================borderPane
        borderPane.setPrefHeight(600);
        borderPane.setPrefHeight(850);
        javafx.scene.layout.BorderPane.setAlignment(getHBox(), javafx.geometry.Pos.CENTER);
        borderPane.setTop(getHBox());
        borderPane.setCenter(vBox);

        return borderPane;
    }


    public void storeData() throws java.io.FileNotFoundException {

        backend.Courses courses = new backend.Courses();
        backend.SignUp signUpBE = new backend.SignUp();


    }
}
