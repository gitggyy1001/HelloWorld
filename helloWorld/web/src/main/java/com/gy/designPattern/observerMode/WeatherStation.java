package com.gy.designPattern.observerMode;

/**
 * Created by hello on 2018/9/10.
 */
public class WeatherStation {
    public static void main(String[] args) {
        WeatherSubject weatherSubject = new WeatherSubject();
        WeatherObserver weatherObserver1 = new WeatherObserver(weatherSubject);
        WeatherObserver weatherObserver2 = new WeatherObserver(weatherSubject);
        weatherSubject.changed();
    }
}
