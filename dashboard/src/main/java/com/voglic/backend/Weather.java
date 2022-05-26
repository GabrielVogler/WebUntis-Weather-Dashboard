package com.voglic.backend;

import io.github.cdimascio.dotenv.Dotenv;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Scanner;

public class Weather {
    static Dotenv dotenv = Dotenv.load();
    private static String key = dotenv.get("KEY");
    private static String weather = "";
    private static float temp = 0;

    /**
     * interacts with the OpenWeatherAPI and gives Back the Current Weather Information
     * @param city      city where the weather is from
     * @return          Weather
     */
    private static void update(String city){
        try {
            URL url = new URL("https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + key);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            int responseCode = connection.getResponseCode();
            if (responseCode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responseCode);
            } else {
                StringBuilder informationString = new StringBuilder();
                Scanner scanner = new Scanner(url.openStream());

                while (scanner.hasNext()){
                    informationString.append(scanner.nextLine());
                }

                scanner.close();

                JSONParser parser = new JSONParser();
                JSONArray dataObject = (JSONArray) parser.parse(String.valueOf("[" + informationString + "]"));

                JSONObject countryData = (JSONObject) dataObject.get(0);
                //System.out.println(countryData);
                //System.out.println(countryData.get("main"));
                JSONObject tempr = (JSONObject) countryData.get("main");
                JSONObject weatherGet = (JSONObject) ((JSONArray) countryData.get("weather")).get(0);
                weather = (weatherGet.get("main")).toString();
                temp = (float)((double)tempr.get("temp") - 273.15);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getWeather(String city){
        update(city);
        return weather;
    }
    public static float getTemp(String city){
        update(city);
        return temp;
    }
}