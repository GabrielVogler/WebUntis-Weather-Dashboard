package com.voglic.backend;

import net.aksingh.owmjapis.DailyForecast;
import net.aksingh.owmjapis.OpenWeatherMap;
import org.json.JSONException;

import java.io.IOException;

public class Weather {
    public static void main(String[] args) {
        boolean isMetric = true;
        String owmApiKey = "eec7beb9238441f1a2aee45f1b60fecf"; /* YOUR OWM API KEY HERE */
        String weatherCity = "Vienna,AT";
        byte forecastDays = 3;
        OpenWeatherMap.Units units = (isMetric)
                ? OpenWeatherMap.Units.METRIC
                : OpenWeatherMap.Units.IMPERIAL;
        OpenWeatherMap owm = new OpenWeatherMap(units, owmApiKey);
        try {
            DailyForecast forecast = owm.dailyForecastByCityName(weatherCity, forecastDays);
            System.out.println("Weather for: " + forecast.getCityInstance().getCityName());
            int numForecasts = forecast.getForecastCount();
            for (int i = 0; i < numForecasts; i++) {
                DailyForecast.Forecast dayForecast = forecast.getForecastInstance(i);
                DailyForecast.Forecast.Temperature temperature = dayForecast.getTemperatureInstance();
                System.out.println("\t" + dayForecast.getDateTime());
                System.out.println("\tTemperature: " + temperature.getMinimumTemperature() +
                        " to " + temperature.getMaximumTemperature() + "\n");
            }
        }
        catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }
}