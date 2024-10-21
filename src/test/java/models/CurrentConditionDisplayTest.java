package models;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class CurrentConditionDisplayTest {
    private WeatherData weatherData;
    private CurrentConditionDisplay currentConditionDisplay;
    private ByteArrayOutputStream out;

    @Before
    public void setUp() throws Exception {
        weatherData = new WeatherData();
        currentConditionDisplay = new CurrentConditionDisplay(weatherData);
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @Test
    public void update() {
        weatherData.setMeasurements(25.0f, 1000.0f, 50.0f);
        assertEquals("WeatherData{temperature=25.0, pressure=1000.0, humidity=50.0, observers=1}", weatherData.toString());
    }

    @Test
    public void display() {
        float temperature = 18.5f;
        float pressure = 1010.0f;
        float humidity = 20.0f;
        weatherData.setMeasurements(temperature, pressure, humidity);
        currentConditionDisplay.display();
        assertEquals("Condiciones actuales: " + "Temperatura: " + temperature + "°C" + " Presión: " + pressure + " hPa" + " Humedad: " + humidity + "%", out.toString().trim());
    }

    @Test
    public void testToString() {
    }
}