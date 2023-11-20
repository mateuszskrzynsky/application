package org.example.db;

import org.example.api.open_weather.Main;

import java.time.LocalDate;

public class WeatherDataEntity {
    private Long id;
    private Long cityId;

    private LocalDate date;
    private Long temperature;
    private Long windSpeed;
    private Long pressure;
}
