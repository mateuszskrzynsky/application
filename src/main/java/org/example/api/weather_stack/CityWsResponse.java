package org.example.api.weather_stack;



public class CityWsResponse {
    Request request;
    Location location;

    Current current;

    public CityWsResponse(Request request, Location location, Current current) {
        this.request = request;
        this.location = location;
        this.current = current;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Current getCurrent() {
        return current;
    }

    public void setCurrent(Current current) {
        this.current = current;
    }
}
