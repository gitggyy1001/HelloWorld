package com.gy.designPattern.observerMode;

/**
 * Created by hello on 2018/9/10.
 */
public class WeatherObserver implements Observer,Displayer {
    WeatherSubject weatherSubject = new WeatherSubject();
    Double temperature;
    Double humidity;
    String weather;

    public WeatherObserver(WeatherSubject weatherSubject){
        this.weatherSubject = weatherSubject;
        weatherSubject.registerObserver(this);
    }

    @Override
    public void update(Double temperature,
                       Double humidity,
                       String weather) {
        this.weather = weather;
        this.humidity = humidity;
        this.temperature = temperature;
        display();
    }

    @Override
    public void display() {
        System.out.println("weather <=======> "+ weather);
        System.out.println("humidity <=======> "+ humidity);
        System.out.println("temperature <=======> "+ temperature);
    }

    public WeatherSubject getWeatherSubject() {
        return weatherSubject;
    }

    public void setWeatherSubject(WeatherSubject weatherSubject) {
        this.weatherSubject = weatherSubject;
    }
}
