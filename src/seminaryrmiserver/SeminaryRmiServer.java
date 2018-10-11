/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package seminaryrmiserver;


import java.net.UnknownHostException;
import java.rmi.AccessException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;
import seminaryrmiserver.logica.modelo.Server;
import seminaryrmiserver.vista.MainFrameServer;


/**
 *
 * @author Ariel Arnedo
 */
public class SeminaryRmiServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String url = "file:///Users/Ariel Arnedo/Dropbox/Seminario/Segundo Corte/RMI/Jar's/SeminaryRemote.jar";
        System.setProperty("java.rmi.server.codebase",url);
        
//        if (System.getSecurityManager()==null)
//            System.setSecurityManager(new SecurityManager());
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MainFrameServer(new Server()).setVisible(true);
                } catch (RemoteException ex) {
                    Logger.getLogger(SeminaryRmiServer.class.getName()).log(Level.SEVERE, null, ex);
                } catch (AlreadyBoundException ex) {
                    Logger.getLogger(SeminaryRmiServer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
//        InterfaceManeger controlModel = new ControlModel();
//        try {
//            InterfaceManeger stub = (InterfaceManeger ) UnicastRemoteObject.exportObject(controlModel, 0);
//            
//            Registry registry = LocateRegistry.createRegistry(5555);
//            registry.bind("Control", stub);
//            System.out.println("Corriendo Server");
//        } catch (RemoteException ex) {
//            Logger.getLogger(SeminaryRmiServer.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (AlreadyBoundException ex) {
//            Logger.getLogger(SeminaryRmiServer.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
    
}
