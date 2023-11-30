package org.example.db;

import org.example.api.open_weather.CityOwResponse;
import org.example.api.open_weather.Main;
import org.example.api.open_weather.Wind;
import org.example.api.weather_stack.CityWsResponse;
import org.example.api.weather_stack.Current;
import org.example.api.weather_stack.Location;
import org.example.api.weather_stack.Request;

import java.time.LocalDateTime;

public class CityDataEntityMapper {

    public static CityDataEntity from(CityOwResponse dto) {
        return new CityDataEntity(
                null,
                dto.getName(),
                new WeatherDataEntity(
                        null,
                        null,
                        dto.getDt(),
                        dto.getMain().getTemp(),
                        dto.getWind().getSpeed(),
                        dto.getMain().getPressure()
                )
        );
    }

    public static CityOwResponse toCityOwResponse(CityDataEntity entity) {
        final WeatherDataEntity weatherDataEntity = entity.getWeatherDataEntity();
        return new CityOwResponse(
                new Wind(weatherDataEntity.getWindSpeed()),
                new Main(weatherDataEntity.getTemperature(), weatherDataEntity.getPressure()),
                entity.getName(),
                weatherDataEntity.getDate()
        );
    }

    public static CityWsResponse toCityWsResponse(CityDataEntity entity){
        final WeatherDataEntity weatherDataEntity = entity.getWeatherDataEntity();
        return new CityWsResponse(
                new Request("empty"),
                new Location(entity.getName(), "Poland", LocalDateTime.now()),
                new Current("now",1L, weatherDataEntity.getWindSpeed(), weatherDataEntity.getPressure())
        );
    }

}