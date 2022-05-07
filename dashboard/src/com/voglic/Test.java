package com.voglic;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class Test extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Subject sub = new Subject("../files/JSON_Stunden/timetable.json", 3);
        System.out.println(sub.name);

        primaryStage.setTitle("TEST");
        primaryStage.setWidth(1000);
        primaryStage.setHeight(1000);
        Group group = new Group();
        Scene scene = new Scene(group);
        primaryStage.setScene(scene);

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
