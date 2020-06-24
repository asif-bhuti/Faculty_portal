package ui;

import javafx.application.Platform;
import javafx.scene.control.*;
import javafx.scene.paint.*;
import javafx.scene.effect.*;
import javafx.scene.layout.*;
import javafx.scene.image.*;
import javafx.scene.text.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class Welcome {

    public Button welcomeSignUp = new javafx.scene.control.Button("Sign Up");
    public Button welcomeLogin = new javafx.scene.control.Button("Login");
    private DropShadow dropShadow1 = new javafx.scene.effect.DropShadow(10, - 5, - 5, javafx.scene.paint.Color.WHITE);
    private DropShadow dropShadow2 = new javafx.scene.effect.DropShadow(10, 5, 5, javafx.scene.paint.Color.rgb(0, 0, 0, 0.1));
    private javafx.scene.effect.InnerShadow innerShadow1 = new javafx.scene.effect.InnerShadow(10, - 5, - 5, javafx.scene.paint.Color.WHITE);
    private javafx.scene.effect.InnerShadow innerShadow2 = new javafx.scene.effect.InnerShadow(10, 5, 5, javafx.scene.paint.Color.rgb(0, 0, 0, 0.1));


    public javafx.scene.layout.GridPane customGridPane() throws java.io.FileNotFoundException {


        //Create UI
        javafx.scene.layout.GridPane gridPane = new javafx.scene.layout.GridPane();
        javafx.scene.layout.HBox hbox = new javafx.scene.layout.HBox();
        javafx.scene.layout.HBox hbox1 = new javafx.scene.layout.HBox();
        javafx.scene.layout.VBox vBox = new javafx.scene.layout.VBox();
        javafx.scene.image.Image userImage = new javafx.scene.image.Image(new java.io.FileInputStream("src/ui/images/User.png"));
        javafx.scene.image.ImageView imageView = new javafx.scene.image.ImageView(userImage);
        javafx.scene.text.Text headerText = new javafx.scene.text.Text("Sign Up");


        dropShadow1.setInput(dropShadow2);
        innerShadow1.setInput(innerShadow2);

        gridPane.setHgap(50);
        gridPane.setVgap(5);
        gridPane.setPrefWidth(600);
        gridPane.setPrefHeight(400);
        gridPane.add(hbox, 0, 0);
        gridPane.add(hbox1, 0, 1);
        gridPane.setRowSpan(hbox1, 3);
        gridPane.setAlignment(javafx.geometry.Pos.CENTER);
        gridPane.setPrefHeight(400);
        gridPane.setPrefWidth(600);
        javafx.scene.layout.GridPane.setHalignment(welcomeSignUp, javafx.geometry.HPos.CENTER);
        javafx.scene.layout.GridPane.setHalignment(welcomeLogin, javafx.geometry.HPos.CENTER);


        headerText.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        headerText.setFont(javafx.scene.text.Font.font("Metropolis Extra Bold"));
        headerText.setFont(javafx.scene.text.Font.font(30));

        imageView.setFitHeight(60);
        imageView.setFitWidth(60);
        imageView.setPreserveRatio(true);

        welcomeSignUp.setPrefHeight(32);
        welcomeSignUp.setPrefWidth(224);
        welcomeLogin.setPrefHeight(32);
        welcomeLogin.setPrefWidth(224);

        hbox.getChildren().addAll(imageView, headerText);
        hbox.setAlignment(javafx.geometry.Pos.CENTER);
        hbox.setPrefHeight(100);
        hbox.setPrefWidth(200);
        hbox.setSpacing(20);

        hbox1.getChildren().add(vBox);
        hbox1.setAlignment(javafx.geometry.Pos.CENTER);

        vBox.getChildren().addAll(welcomeLogin,welcomeSignUp);
        vBox.setMaxHeight(400);
        vBox.setMaxWidth(400);
        vBox.prefHeight(100);
        vBox.prefWidth(300);
        vBox.setSpacing(20);


        //Set style
        gridPane.setStyle("-fx-background-color: #f5f5f5; -fx-font-family:'Metropolis Bold';");
        welcomeSignUp.setStyle("-fx-background-color: #757575; -fx-max-width: 400;-fx-font-family:'Metropolis Extra Bold';");
        welcomeSignUp.setTextFill(javafx.scene.paint.Color.WHITE);
        welcomeLogin.setStyle("-fx-background-color: #607d8b; -fx-max-width: 400;-fx-font-family:'Metropolis Extra Bold';");
        welcomeLogin.setTextFill(javafx.scene.paint.Color.WHITE);


        return gridPane;
    }

}
