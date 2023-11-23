package org.example.db;

import org.example.api.open_weather.Main;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class WeatherDataEntity {
    private Long id;
    private Long cityId;

    private LocalDateTime date;
    private Float temperature;
    private Float windSpeed;
    private Float pressure;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Float getTemperature() {
        return temperature;
    }

    public void setTemperature(Float temperature) {
        this.temperature = temperature;
    }

    public Float getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Float windSpeed) {
        this.windSpeed = windSpeed;
    }

    public Float getPressure() {
        return pressure;
    }

    public void setPressure(Float pressure) {
        this.pressure = pressure;
    }

    public WeatherDataEntity(Long id, Long cityId, LocalDateTime date, Float temperature, Float windSpeed, Float pressure) {
        this.id = id;
        this.cityId = cityId;
        this.date = date;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.pressure = pressure;
    }
}
