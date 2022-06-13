package com.voglic.javaFX;

import com.voglic.backend.Time;
import com.voglic.backend.Weather;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

public class Controller implements Initializable {

    /**
     * Clock Label
     */
    @FXML
    private Label clock;

    /**
     * Date Label
     */
    @FXML
    private Label date;

    /**
     * Icon Label
     */
    @FXML
    private ImageView icon;

    /**
     * Conditions Label
     */
    @FXML
    private Label condition;

    /**
     * Temperature Label
     */
    @FXML
    private Label temp;


    /**
     * Clock and Date Thread Loop
     */
    private void clockLoop(){
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                    clock.setText(Time.getTime()); //set Clock
                    date.setText(Time.getDate()); // set Date
                });
            }
        };

        Timer t = new Timer();
        t.scheduleAtFixedRate(
                task,    //called Method
                0, //delay before first execution
                1000L); //time between executions 1000 ms = 1s
    }

    /**
     * Weather Thread Loop
     */
    private void checkWeather(){
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                    Path imageFile = Paths.get( Weather.getIcon("Vienna")); // make Path
                    try {
                        icon.setImage(new Image(imageFile.toUri().toURL().toExternalForm())); // set new Icon
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    condition.setText(Weather.getWeather("Vienna")); //set Condition
                    temp.setText(Weather.getTempString("Vienna") + "°C"); // set Temperature
                });
            }
        };

        Timer t = new Timer();
        t.scheduleAtFixedRate(
                task,    //called Method
                0, //delay before first execution
                60000L); //time between executions 60000 ms = 60s
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        clockLoop();
        checkWeather();
    }
}

