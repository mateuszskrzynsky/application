package org.example.db;

import org.example.api.open_weather.CityOwResponse;

public class CityDataEntityMapper {
    public static CityDataEntity from (CityOwResponse dto){
        return new CityDataEntity(
                null,
                dto.getName(),
                new WeatherDataEntity(
                        null,
                        null,
                        dto.getDt(),
                        dto.getWind().getSpeed(),
                        dto.getMain().getTemp(),
                        dto.getMain().getPressure()
                )
        );
    }
}
