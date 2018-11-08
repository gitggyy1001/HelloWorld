package com.gy.rmi;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * Created by hello on 2018/3/8.
 */
public class RmiServer {

    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1399);
            IHello service1 = new HelloImpl();
            Context namingContext = new InitialContext();
            namingContext.rebind("rmi://localhost:1399/Hello",
                    service1);
        }
        catch (NamingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        System.out.println("Successfully register a remote object.");

    }
}
