package ru.SilirdCo.Lab3.Main;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server implements IServer {
    private final String HELLO = "Hello, ";
    private final static String SERVER_WAIT = "Server is waiting for connection...";

    @Override
    public void check(String str) throws RemoteException {
        System.out.println(HELLO + str);
    }

    @Override
    public int div(int a, int b) {
        return a%b;
    }

    @Override
    public boolean lessOrEqual(int a, int b) {
        return a<=b;
    }

    @Override
    public boolean and(boolean a, boolean b) {
        return a&&b;
    }

    @Override
    public String[] split(String str) {
        return str.split(" ");
    }

    public static void main(String[] args) throws Exception {
        System.setProperty("java.security.policy","file:./security.policy");

        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }

        Registry reg = LocateRegistry.createRegistry(PORT);
        IServer srv = new Server();
        IServer stub = (IServer) UnicastRemoteObject.exportObject(srv, PORT);
        reg.rebind(NAME, stub);
        System.out.println(SERVER_WAIT);
    }
}
