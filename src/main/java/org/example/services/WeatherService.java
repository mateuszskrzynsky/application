package org.example.services;

import org.example.api.CityWeatherDataResponse;
import org.example.api.HttpClientService;
import org.example.api.open_weather.CityOwResponse;
import org.example.api.weather_stack.CityWsResponse;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class WeatherService {

    public CityOwResponse getWeatherFromOpenWeather(String cityName){
        String baseUrl="https://api.openweathermap.org/data/2.5/weather?";
        String appIdQuery= "appid=716238e6166ce6e1315daf3232959cd3";
        String cityNameQuery="q="+cityName;
        String unitsQuery= "units=metric";

        //String openWeatherUrl = "https://api.openweathermap.org/data/2.5/weather?appid=716238e6166ce6e1315daf3232959cd3&q=Warsaw&units=metric";

        String openWeatherUrl= baseUrl+appIdQuery+"&"+cityNameQuery+"&"+unitsQuery;


        var httpClientService = new HttpClientService<CityOwResponse>();
        final CityOwResponse response = httpClientService.getWeather(
                openWeatherUrl,
                CityOwResponse.class,
                jsonElement -> {
                    var dateTimeJson = jsonElement.getAsJsonPrimitive().getAsLong();
                    return LocalDateTime.ofInstant(Instant.ofEpochSecond(dateTimeJson), ZoneId.systemDefault());
                }
        );
        return response;
    }

    public CityWsResponse getWeatherFromWeatherStack(String cityName){
        String baseUrl="http://api.weatherstack.com/current?";
        String appIdQuery= "access_key=f1b9fe06f1a16e1647062531746b1c73";
        String cityNameQuery="query="+cityName;


        String weatherStackUrl = baseUrl+appIdQuery+"&"+cityNameQuery;
        var httpClientService = new HttpClientService<CityWsResponse>();
        final CityWsResponse response = httpClientService.getWeather(
                weatherStackUrl,
                CityWsResponse.class,
                jsonElement -> {
                    return  LocalDateTime.parse(jsonElement.getAsJsonPrimitive().getAsString(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
                }
        );

        return response;
    }
}