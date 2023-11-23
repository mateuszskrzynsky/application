package org.example.db;

public class CityDataEntity {
    private Long id;
    private String name;
    private WeatherDataEntity weatherDataEntity;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public WeatherDataEntity getWeatherDataEntity() {
        return weatherDataEntity;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeatherDataEntity(WeatherDataEntity weatherDataEntity) {
        this.weatherDataEntity = weatherDataEntity;
    }

    public CityDataEntity(Long id, String name, WeatherDataEntity weatherDataEntity) {
        this.id = id;
        this.name = name;
        this.weatherDataEntity = weatherDataEntity;
    }
}
