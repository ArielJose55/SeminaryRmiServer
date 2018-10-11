/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package seminaryrmiserver.logica.modelo;

import com.seminary.remote.HostPc;
import com.seminary.remote.InterfaceManagerServer;
import java.rmi.RemoteException;

/**
 *
 * @author Ariel Arnedo
 */
public class ServerManager implements InterfaceManagerServer{

    private final java.util.List<HostPc> listClients;

    public ServerManager() {
        this.listClients = new java.util.ArrayList<>();
    }
    
    
    @Override
    public int sendSuccessfulConnection(HostPc hostpc) throws RemoteException {
        System.out.println(hostpc);
        if(listClients.add(hostpc)){
            return -1;
        }
        return -1;
    }

    @Override
    public int sendMessage(String string) throws RemoteException {
        for(HostPc cliente : listClients){
            if(cliente.compareHostPc(getMessage(string)[0])){
                cliente.getMessages().add(createMessageClient(cliente, getMessage(string)[1]));
                return 1;
            }
        }
        return -1;
    }

    @Override
    public int sendCloseConnection() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private String[] getMessage(String message){
        if(message == null || message.compareTo("") == 0)
            throw new RuntimeException("Mensaje nulo");
        String[] messages = message.split("###$###");
        if(messages.length != 2)
            throw new RuntimeException("Error al procesar el mensaje");
        return messages;
    }
    
    private String createMessageClient(HostPc client , String message){
        StringBuilder sb = new StringBuilder();
        sb.append(client.getNameHost());
        sb.append(" : ");
        sb.append(message);
        return sb.toString();
    }
}
