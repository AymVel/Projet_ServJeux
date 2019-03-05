package Clients;

import Models.PenduInterface;

import java.rmi.Naming;
import java.util.Scanner;

public class Client {
    public static void main (String[] argv) {
        /* PENDU */
        try {
            PenduInterface obj = (PenduInterface) Naming.lookup ("rmi://localhost:8000/serveur");
            System.out.println (obj.InitWord());
            System.out.println (obj.getMotSecret());
            while (obj.estFini() == false){
            Scanner sc = new Scanner(System.in);
            System.out.println("Veuillez entrer un caractere :");
            String str= sc.nextLine().toUpperCase();
            char[] a = str.toCharArray();
            obj.verifyWord(a);
            System.out.println(obj.getMotSecret());}

        } catch (Exception e) {
            System.out.println ("Client exception: " + e);
        }
        /* tictactoe */
            
    }
}

