package com.gy.rmi;

import java.rmi.Remote;

/**
 * Created by hello on 2018/3/8.
 */
public interface IHello extends Remote {
    public String sayHello(String name) throws java.rmi.RemoteException;
}
