package org.example.api.weather_stack;

public class Current {
    String observation_time;
    Long temperature;
    Float wind_speed;

    public Current(String observation_time, Long temperature, Float wind_speed) {
        this.observation_time = observation_time;
        this.temperature = temperature;
        this.wind_speed = wind_speed;
    }

    public String getObservation_time() {
        return observation_time;
    }

    public void setObservation_time(String observation_time) {
        this.observation_time = observation_time;
    }

    public Long getTemperature() {
        return temperature;
    }

    public void setTemperature(Long temperature) {
        this.temperature = temperature;
    }

    public Float getWind_speed() {
        return wind_speed;
    }

    public void setWind_speed(Float wind_speed) {
        this.wind_speed = wind_speed;
    }
}
