package org.example.handlers;

import org.example.api.open_weather.CityOwResponse;
import org.example.services.WeatherService;

import java.util.Scanner;

public class FindCityByNameHandler {

    public void handle(){

        System.out.println("Type city to find");
        Scanner scCityToFind = new Scanner(System.in);
        String userInputCityToFind= scCityToFind.nextLine();
        //wyszukać miasto
        final CityOwResponse weatherFromOpenWeather = new WeatherService().getWeatherFromOpenWeather(userInputCityToFind);
        String message = """
                            ************************************
                            City weather data:  [%s]
                            -City name:         [%s]
                            -wind speed:        [%s]
                            -temp:              [%s]
                            -pressure:          [%s]
                                                   
                            """.formatted(weatherFromOpenWeather.getDt(),
                weatherFromOpenWeather.getName(),
                weatherFromOpenWeather.getWind().getSpeed(),
                weatherFromOpenWeather.getMain().getTemp(),
                weatherFromOpenWeather.getMain().getPressure()
        );
        System.out.println(message);

    }
}
