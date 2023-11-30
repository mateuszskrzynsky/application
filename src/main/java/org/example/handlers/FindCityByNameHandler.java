package org.example.handlers;

import org.example.api.open_weather.CityOwResponse;
import org.example.api.weather_stack.CityWsResponse;
import org.example.db.CityDataEntity;
import org.example.db.CityDataEntityMapper;
import org.example.services.WeatherService;

import java.time.LocalDateTime;
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

        final CityWsResponse weatherFromWeatherStock;
        LocalDateTime owDt = weatherFromOpenWeather.getDt();
        String owName = weatherFromOpenWeather.getName();
        Float owSpeed = weatherFromOpenWeather.getWind().getSpeed();
        Float owTemp = weatherFromOpenWeather.getMain().getTemp();
        Float owPressure = weatherFromOpenWeather.getMain().getPressure();

        if (isThisCityCached(userInputCityToFind)) {
            final CityDataEntity cityByName = DATA_BASE.getCityByName(userInputCityToFind).orElseThrow();
            weatherFromWeatherStock = CityDataEntityMapper.toCityWsResponse(cityByName);
        } else {
            weatherFromWeatherStock = new WeatherService().getWeatherFromWeatherStack(userInputCityToFind);
            // TODO -> add new city into DB
        }
        Long wsTemp = weatherFromWeatherStock.getCurrent().getTemperature();
        String wsName = weatherFromWeatherStock.getLocation().getName();
        Float wsSpeed = weatherFromWeatherStock.getCurrent().getWind_speed();
        LocalDateTime wsDt = weatherFromWeatherStock.getLocation().getLocaltime();
        Float wsPressure = weatherFromWeatherStock.getCurrent().getPressure();

        Long averageTemp= (long) ((owTemp+wsTemp)/2);
        Float avarageWindSpeed = (owSpeed+wsSpeed)/2;
        Float avaragePressure = (wsPressure+owPressure)/2;

        String message = """
							------------------------------
							City weather data from [%s] :
							- city name: 		[%s]
							- wind speed:		[%s]
							- temp: 			[%s]
							- pressure: 		[%s]
							""".formatted(
                owDt,
                owName,
                avarageWindSpeed,
                averageTemp,
                avaragePressure
        );
        System.out.println(message);
    }

    private boolean isThisCityCached(String userInputCityToFind) {
        return DATA_BASE.existsByName(userInputCityToFind);
    }

}