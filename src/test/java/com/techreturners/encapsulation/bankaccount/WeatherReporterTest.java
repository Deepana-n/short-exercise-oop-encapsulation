package com.techreturners.encapsulation.bankaccount;

import com.techreturners.encapsulation.bankaccount.model.WeatherReporter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WeatherReporterTest {

    private static WeatherReporter wr;

    @Test
    public void checkWeatherBasedOnLocationLondon(){
        String location = "London";
        double temperature = 15.0;
        wr = new WeatherReporter(location, temperature);
        assertEquals("🌦", wr.weatherBasedOnLocation(location));
    }

    @Test
    public void checkWeatherBasedOnLocationOthers(){
        String location = "Others";
        double temperature = 15.0;
        wr = new WeatherReporter(location, temperature);
        assertEquals("🔆", wr.weatherBasedOnLocation(location));
    }

    @Test
    public void checkWeatherBasedTemperature35Hot(){
        String location = "Others";
        double temperature = 35.0;
        wr = new WeatherReporter(location, temperature);
        assertEquals("It's too hot 🥵!", wr.weatherBasedOnTemperature(temperature));
    }

    @Test
    public void checkWeatherBasedTemperature8Cold(){
        String location = "Others";
        double temperature = 8.0;
        wr = new WeatherReporter(location, temperature);
        assertEquals("It's too cold 🥶!", wr.weatherBasedOnTemperature(temperature));
    }

    @Test
    public void checkPrintLondonCold(){
        String location = "London";
        double temperature = 8.0;
        wr = new WeatherReporter(location, temperature);
        assertEquals("I am in London and it is 🌦. It's too cold 🥶!. The temperature in Fahrenheit is 46.4.", wr.print());
    }

    @Test
    public void checkPrintLondonHot(){
        String location = "London";
        double temperature = 35.0;
        wr = new WeatherReporter(location, temperature);
        assertEquals("I am in London and it is 🌦. It's too hot 🥵!. The temperature in Fahrenheit is 95.", wr.print());
    }

    @Test
    public void checkPrintLondonJustNice(){
        String location = "London";
        double temperature = 22.0;
        wr = new WeatherReporter(location, temperature);
        assertEquals("I am in London and it is 🌦. Ahhh...it's just right 😊!. The temperature in Fahrenheit is 71.6.", wr.print());
    }

    @Test
    public void checkPrintLondonMixedcaseJustNice(){
        String location = "lOnDon";
        double temperature = 22.0;
        wr = new WeatherReporter(location, temperature);
        assertEquals("I am in London and it is 🌦. Ahhh...it's just right 😊!. The temperature in Fahrenheit is 71.6.", wr.print());
    }

}
