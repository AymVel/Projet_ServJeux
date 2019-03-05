package Controllers;

import Models.Pendu;
import Models.PenduInterface;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class PenduImpl extends UnicastRemoteObject implements PenduInterface {
    Pendu p = new Pendu();
    public PenduImpl () throws RemoteException {
        super(); }
    public String InitWord(){
        p.initWord();
        return "Mot initialisé";
    }
    public String getMotSecret(){
        return p.getMotSecret();
    }

    public boolean verifyWord(char c){
        return p.verifyWord(c);
    }
    public boolean estFini(){
        return p.estFini();
    }
    public boolean verifyWord(char[] tc){
        return p.verifyWord(tc);
    }
}

