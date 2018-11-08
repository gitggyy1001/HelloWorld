package com.gy.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by hello on 2018/3/8.
 */
public class HelloImpl extends UnicastRemoteObject implements IHello {
    // 这个实现必须有一个显式的构造函数，并且要抛出一个RemoteException异常
    protected HelloImpl() throws RemoteException {
        super();
    }

    @Override
    public String sayHello(String name) throws RemoteException {
        return "server say hello to "+name;
    }

}
