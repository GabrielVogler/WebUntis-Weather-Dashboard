package com.voglic.javaFX;

import com.voglic.backend.Subject;
import com.voglic.backend.Time;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Gui extends Application {
    static String clockString = Time.getTime();
    boolean running = false;
    static Text t = new Text(20,20,"Test");


    public static void main(String[] args) {
        Runnable clock = new Runnable() {
            public void run() {
                clockString = Time.getTime();
                t.setText(clockString);
                System.out.println(Time.getTime());
            }
        };

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(clock, 0, 1, TimeUnit.SECONDS);
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        /**
         * Stop Programm on Window Close
         */

        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent e) {
                Platform.exit();
                System.exit(0);
            }
        });

        /**
         * Get Current Subject
         */
        Subject sub = new Subject("../files/JSON_Stunden/timetable.json", 3);
        System.out.println(sub);
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
                0, 0, 1, 2, true,        //sizing
                CycleMethod.NO_CYCLE,                      //cycling
                new Stop(0, Color.web("#373B44")),      //colors
                new Stop(1, Color.web("#4286f4"))));

        Rectangle r = new Rectangle();
        r.setX(100);
        r.setY(100);
        r.setHeight(200);
        r.setWidth(400);
        r.setFill(sub.color);

        /**
         * Format Clock
         */
        t.setFont(Font.font(20));

        /**
         * Add Children and show on PrimaryStage
         */
        group.getChildren().addAll(t);
        primaryStage.show();
    }

}