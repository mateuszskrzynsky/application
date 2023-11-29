package org.example.services;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.example.api.open_weather.CityOwResponse;
import org.example.api.weather_stack.CityWsResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeatherServiceTest {

    @Test
    void getWeatherFromOpenWeather() {
        //given
        final String cityNameToFind = "Warsaw";
        final var weatherService = new WeatherService();
        //when
        final CityOwResponse response = weatherService.getWeatherFromOpenWeather(cityNameToFind);
        //then
        final String resultCityName = response.getName();
        Assertions.assertEquals(resultCityName, cityNameToFind);
    }

    @Test
    void getWeatherFromWeatherStack(){
        //given
        final String cityNameToFind = "Warsaw";
        final var weatherService = new WeatherService();
        //when
        final CityWsResponse response = weatherService.getWeatherFromWeatherStack(cityNameToFind);
        //then
        final String resultCityName = response.getLocation().getName();
        Assertions.assertEquals(resultCityName, cityNameToFind);
    }
}