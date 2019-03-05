package Models;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PenduInterface extends Remote {
    public String InitWord () throws RemoteException;
    public String getMotSecret () throws RemoteException;
    public boolean verifyWord(char c) throws RemoteException;
    public boolean estFini() throws RemoteException;
    public boolean verifyWord(char[] tc) throws RemoteException;

}
