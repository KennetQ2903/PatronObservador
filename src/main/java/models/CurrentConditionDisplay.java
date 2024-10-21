package models;

import interfaces.DisplayElement;
import interfaces.Observer;

public class CurrentConditionDisplay implements Observer, DisplayElement {
    private float temperature, pressure, humidity;

    public CurrentConditionDisplay(WeatherData weatherData) {
        weatherData.registerObserver(this);
    }


    @Override
    public void update(float deltaTemperature, float deltaPressure, float deltaHumidity) {
        this.temperature = deltaTemperature;
        this.pressure = deltaPressure;
        this.humidity = deltaHumidity;
    }

    @Override
    public void display() {
        System.out.println("Condiciones actuales: " + "Temperatura: " + temperature + "°C" + " Presión: " + pressure + " hPa" + " Humedad: " + humidity + "%");
    }

    @Override
    public String toString() {
        return "CurrentConditionDisplay{" +
                "temperature=" + temperature +
                ", pressure=" + pressure +
                ", humidity=" + humidity +
                '}';
    }

}
