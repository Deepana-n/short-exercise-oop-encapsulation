package com.techreturners.encapsulation.bankaccount.model;

import java.text.MessageFormat;
import java.util.HashMap;

public class WeatherReporter {

    private final String location;
    private final double temperature;
    private static final int HOT = 30;
    private static final int COLD = 10;
    private static final HashMap<String,String> weatherLocationMap = new HashMap<>();

    public WeatherReporter(String location, double temperature) {
        this.location = location;
        this.temperature = temperature;
        setWeatherLocationMap();
    }

    private void setWeatherLocationMap(){
        weatherLocationMap.put("london","🌦");
        weatherLocationMap.put("california","🌅");
        weatherLocationMap.put("cape town","🌤");
        weatherLocationMap.put("others","🔆");
    }

    public HashMap<String,String> getWeatherLocationMap(){
        return weatherLocationMap;
    }

    public String print() {
        return MessageFormat.format("I am in {0} and it is {1}. {2}. The temperature in Fahrenheit is {3}.", location.substring(0,1).toUpperCase() + location.substring(1).toLowerCase(), weatherBasedOnLocation(location), weatherBasedOnTemperature(temperature), newTemp(temperature));
    }

    private double newTemp(double temperature){
        return (9.0 / 5.0) * temperature + 32;
    }

    public String weatherBasedOnLocation(String location) {
        location = location.toLowerCase();
        return getWeatherLocationMap().containsKey(location) ? getWeatherLocationMap().get(location) : getWeatherLocationMap().get("others");
    }

    public String weatherBasedOnTemperature(double temperature) {
        String message;
        if (temperature > HOT) {
           message = "It's too hot 🥵!";
        }else if (temperature < COLD) {
            message = "It's too cold 🥶!";
        }else {
            message = "Ahhh...it's just right 😊!";
        }
        return message;
    }

}
