package org.example;

import org.example.api.open_weather.CityOwResponse;
import org.example.db.CityDataEntity;
import org.example.db.CityDataEntityMapper;
import org.example.db.CityWeatherDb;
import org.example.handlers.FindCityByNameHandler;
import org.example.services.WeatherService;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static final CityWeatherDb DATA_BASE = new CityWeatherDb();

    public static void main(String[] args) {
        System.out.println("Hello world!");

        final List<String> mostPopularCities = List.of("Warsaw", "Szczecin");

        mostPopularCities.stream()
                .forEach(cityName -> {
                    // get city
                    final CityOwResponse response = new WeatherService().getWeatherFromOpenWeather(cityName);
                    final CityDataEntity entity = CityDataEntityMapper.from(response);
                    // save city
                    DATA_BASE.add(entity);
                });



        var isRunning = true;
        var isFirstRun = true;
        while(isRunning) {
            isFirstRun = showWelcomeMenu(isFirstRun);

            Scanner sc = new Scanner(System.in);
            String userInput = sc.nextLine();

            switch (userInput) {
                case "X" -> isRunning = false;
                case "C" -> new FindCityByNameHandler().handle();
                default -> System.out.println("ERROR!!! INVALID INPUT");
            }
        }
    }

    private static boolean showWelcomeMenu(boolean isFirstRun) {
        if (isFirstRun) {
            System.out.println("""
				----------------------
				WELCOME!
				type X to quit
				type C to show what city you want to find
				----------------------
				""");
            isFirstRun = false;
        }
        return isFirstRun;
    }
}