package Serveur;

import Controllers.PenduImpl;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;

public class Serveur {
    public static void main(String[] argv) {
        try {

            LocateRegistry.createRegistry(8000);
            Naming.rebind("rmi://localhost:8000/serveur", new PenduImpl());
            System.out.println("Server prêt ! .");
        } catch (Exception e) {
            System.out.println("Server échec " + e);
        }
    }
}

