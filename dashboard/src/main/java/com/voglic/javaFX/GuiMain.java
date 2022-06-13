package com.voglic.javaFX;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.util.Objects;

public class GuiMain extends Application {
    double x, y = 0;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {

        /**
         * Stop Programm on Window Close
         */

        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent e) {
                Platform.exit();
                System.exit(0);
            }
        });

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("view.fxml")));
        Scene sc = new Scene(root);     //Scene
        //    stage.initStyle(StageStyle.UNDECORATED);    //Stage
        //move around
        root.setOnMousePressed(evt -> {
            x = evt.getSceneX();
            y = evt.getSceneY();
        });
        root.setOnMouseDragged(evt -> {
            stage.setX(evt.getScreenX() - x);
            stage.setY(evt.getScreenY() - y);
        });

        //Stage
        stage.setTitle("WebUntis_Weather_Dashboard");
        stage.setScene(sc);
        stage.show();


    }
}