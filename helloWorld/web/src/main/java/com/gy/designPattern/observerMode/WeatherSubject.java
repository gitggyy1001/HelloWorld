package com.gy.designPattern.observerMode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hello on 2018/9/10.
 */
public class WeatherSubject implements Subject {
    List<Observer> WeatherObserverList = new ArrayList<Observer>();
    Double temperature;
    Double humidity;
    String weather;

    public WeatherSubject(List<Observer> wheatherObserverList){
        this.WeatherObserverList = wheatherObserverList;
    }

    public WeatherSubject(){

    }

    @Override
    public void registerObserver(Observer observer) {
        WeatherObserverList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        WeatherObserverList.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for(Observer observer : WeatherObserverList){
            observer.update( temperature,
                     humidity,
                     weather);
        }
    }

    public void changed(){
        setHumidity(Math.random()*100);
        setTemperature(Math.random()*50);
        setWeather("sunny");
        notifyObserver();
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }


}
