package org.example.api.weather_stack;

import java.time.LocalDateTime;

public class Location {
    String name;
    String country;
    LocalDateTime localtime;

    public Location(String name, String country, LocalDateTime localtime) {
        this.name = name;
        this.country = country;
        this.localtime = localtime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LocalDateTime getLocaltime() {
        return localtime;
    }

    public void setLocaltime(LocalDateTime localtime) {
        this.localtime = localtime;
    }
}
