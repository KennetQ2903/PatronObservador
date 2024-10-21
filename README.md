# Plantilla
![Plantilla](public/observerTemplate.webp)
# Diagrama de clases
![Diagrama de clases](public/ObserverPattern.png)
# Diagrama de secuencia
```mermaid
sequenceDiagram
    participant Client
    participant WeatherData
    participant CurrentConditionDisplay

    Client->>WeatherData: new WeatherData()
    Client->>CurrentConditionDisplay: new CurrentConditionDisplay(weatherData)
    WeatherData->>CurrentConditionDisplay: registerObserver(this)

    Client->>WeatherData: setMeasurements(25.0, 1012, 65)
    WeatherData->>WeatherData: update temperature, pressure, humidity
    WeatherData->>CurrentConditionDisplay: notifyObservers()
    CurrentConditionDisplay->>CurrentConditionDisplay: update(25.0, 1012, 65)

    Client->>CurrentConditionDisplay: display()
    CurrentConditionDisplay-->>Client: "Condiciones actuales: Temperatura: 25.0°C Presión: 1012 hPa Humedad: 65%"
```