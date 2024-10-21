package models;

import interfaces.Observer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class WeatherDataTest {
    private WeatherData weatherData;
    private CurrentConditionDisplay currentConditionDisplay;

    @Before
    public void setUp() throws Exception {
        weatherData = new WeatherData();
        currentConditionDisplay = new CurrentConditionDisplay(weatherData);
    }

    @Test
    public void registerObserver() {
        assertEquals("1", weatherData.toString().split("observers=")[1].split("}")[0].trim());
    }

    @Test
    public void removeObserver() {
        weatherData.removeObserver(currentConditionDisplay);
        assertEquals("0", weatherData.toString().split("observers=")[1].split("}")[0].trim());
    }

    @Test
    public void notifyObservers() {
        weatherData.setMeasurements(25.5f, 1013.1f, 65.0f);
        assertEquals("WeatherData{temperature=25.5, pressure=1013.1, humidity=65.0, observers=1}", weatherData.toString());
    }

    @Test
    public void setMeasurements() {
        weatherData.setMeasurements(25.5f, 1013.1f, 65.0f);
        assertEquals("WeatherData{temperature=25.5, pressure=1013.1, humidity=65.0, observers=1}", weatherData.toString());
    }

    @Test
    public void testToString() {
        weatherData.setMeasurements(25.5f, 1013.1f, 65.0f);
        assertEquals("WeatherData{temperature=25.5, pressure=1013.1, humidity=65.0, observers=1}", weatherData.toString());
    }
}