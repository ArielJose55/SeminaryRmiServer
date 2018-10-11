/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package seminaryrmiserver.logica.modelo;

import com.seminary.remote.InterfaceManagerServer;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Ariel Arnedo
 */
public class Server {
 
    private final ServerManager serverManager;

    public Server() throws RemoteException, AlreadyBoundException {
        this.serverManager = new ServerManager();
    }
    
    public void startConnectionServer() throws RemoteException, AlreadyBoundException{
        InterfaceManagerServer stub = (InterfaceManagerServer) UnicastRemoteObject.exportObject(serverManager, 0);
        Registry registry = LocateRegistry.createRegistry(5555);
        registry.bind("ServerManager", stub);
    }
    
}
