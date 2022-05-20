package com.voglic.javaFX;

import com.voglic.Subject;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class Test extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        /**
         * Get Current Subject
         */
        Subject sub = new Subject("files/JSON_Stunden/timetable.json", 3);
        System.out.println(sub.name);

        /**
         * Set Title, Width, Height
         */
        primaryStage.setTitle("TEST");
        primaryStage.setWidth(1000);
        primaryStage.setHeight(1000);

        /**
         * Init group and scene
         */
        Group group = new Group();
        Scene scene = new Scene(group);
        primaryStage.setScene(scene);

        /**
         * Set Background Gradient
         */
        scene.setFill(new LinearGradient(
                0, 0, 1, 2, true,                      //sizing
                CycleMethod.NO_CYCLE,                  //cycling
                new Stop(0, Color.web("#373B44")),     //colors
                new Stop(1, Color.web("#4286f4"))));

        Rectangle r = new Rectangle();
        r.setX(100);
        r.setY(100);
        r.setHeight(200);
        r.setWidth(400);
        r.setFill(sub.color);

        group.getChildren().addAll(r);
        primaryStage.show();
    }
}
