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

    /**
     * start Stage
     */
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

        /**
         * Load FXML file
         * add FXML file to Scene
         */
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("view.fxml")));
        Scene sc = new Scene(root);     //Scene

        /**
         * set Scene to Stage
         * make Stage visible
         */
        stage.setTitle("WebUntis_Weather_Dashboard");
        stage.setScene(sc);
        stage.show();


    }
}