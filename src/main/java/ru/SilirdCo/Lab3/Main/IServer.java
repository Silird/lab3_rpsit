package ru.SilirdCo.Lab3.Main;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IServer extends Remote {
    public static final int PORT = 1099;
    public static final String NAME = "my_server";

    public void check(String str) throws RemoteException;

    int div(int a, int b) throws RemoteException;

    boolean lessOrEqual(int a, int b) throws RemoteException;

    boolean and(boolean a, boolean b) throws RemoteException;

    String[] split(String str) throws RemoteException;
}
