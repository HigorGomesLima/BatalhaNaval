package org.edwintumax.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Observer extends Remote {
    public void actualizar() throws RemoteException;
}
