package com.gy.designPattern.observerMode;

/**
 * Created by hello on 2018/9/10.
 */
public interface Subject {
    public void registerObserver(Observer observer);
    public void removeObserver(Observer observer);
    public void notifyObserver();
}
