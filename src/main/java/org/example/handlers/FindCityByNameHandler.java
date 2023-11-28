package org.example.handlers;

import org.example.api.open_weather.CityOwResponse;
import org.example.db.CityDataEntity;
import org.example.db.CityDataEntityMapper;
import org.example.services.WeatherService;

import java.util.Scanner;

import static org.example.Main.DATA_BASE;

public class FindCityByNameHandler {

    public void handle() {
        System.out.println("Type a city to find");
        Scanner scCityToFind = new Scanner(System.in);
        String userInputCityToFind = scCityToFind.nextLine();

        final CityOwResponse weatherFromOpenWeather;
        if (isThisCityCached(userInputCityToFind)) {
            final CityDataEntity cityByName = DATA_BASE.getCityByName(userInputCityToFind).orElseThrow();
            weatherFromOpenWeather = CityDataEntityMapper.toCityOwResponse(cityByName);
        } else {
            weatherFromOpenWeather = new WeatherService().getWeatherFromOpenWeather(userInputCityToFind);
            // TODO -> add new city into DB
        }

        String message = """
							------------------------------
							City weather data from [%s] :
							- city name: 		[%s]
							- wind speed:		[%s]
							- temp: 			[%s]
							- pressure: 		[%s]
							""".formatted(
                weatherFromOpenWeather.getDt(),
                weatherFromOpenWeather.getName(),
                weatherFromOpenWeather.getWind().getSpeed(),
                weatherFromOpenWeather.getMain().getTemp(),
                weatherFromOpenWeather.getMain().getPressure()
        );
        System.out.println(message);
    }

    private boolean isThisCityCached(String userInputCityToFind) {
        return DATA_BASE.existsByName(userInputCityToFind);
    }

}
