package org.example.api.open_weather;

public class Wind {
    private Float speed;

    public Wind(Float speed) {
        this.speed = speed;
    }

    public Float getSpeed() {
        return speed;
    }

    public void setSpeed(Float speed) {
        this.speed = speed;
    }
}