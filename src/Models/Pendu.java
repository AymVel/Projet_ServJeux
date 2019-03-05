package Models;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;

public class Pendu {
    private char[] TabMot;
    private String mot;
    private String motSecret;

    public String getMotSecret(){
        return motSecret;
    }
    public void initWord() {
        motSecret = "";
        mot = "";
        String fichier = "word.txt";
        int compteur = 0;

        try{
            InputStream ips=new FileInputStream(fichier);
            InputStreamReader ipsr=new InputStreamReader(ips);
            BufferedReader br=new BufferedReader(ipsr);
            while ((br.readLine())!=null){
                compteur++;
            }
            br.close();

            InputStream ips2=new FileInputStream(fichier);
            InputStreamReader ipsr2=new InputStreamReader(ips2);
            BufferedReader br2=new BufferedReader(ipsr2);
            Random randomGenerator = new Random();
            int limite = randomGenerator.nextInt(compteur);
            compteur = 0;
            String ligne;

            while ((ligne = br2.readLine())!=null && compteur <= limite){
                this.mot = ligne;
                compteur++;
            }
            br2.close();

            this.mot = this.mot.trim().toUpperCase();

            for(int j = 0; j < this.mot.length(); j++)
            {
                this.motSecret +=  '*';
            }
            this.TabMot = this.motSecret.toCharArray();
        }
        catch (Exception e){

            System.out.println(e.toString());
        }
    }

    public boolean verifyWord(char c){

        boolean cok = false;

        for(int i = 0; i < this.mot.length(); i++){
            if(this.mot.toUpperCase().charAt(i) == c){
                this.TabMot[i] = c;
                cok = true;
            }
        }
        this.motSecret = new String(this.TabMot);
        return cok;
    }

    public boolean verifyWord(char[] tc){

        boolean tcok = false;

        for(char c : tc)
        {
            for(int i = 0; i < this.mot.length(); i++){

                if(this.mot.toUpperCase().charAt(i) == c){
                    this.TabMot[i] = c;
                    System.out.println("OK !");
                    tcok = true;
                }
            }
        }
        this.motSecret = new String(this.TabMot);
        System.out.println("Mot secret = " + this.mot);

        return tcok;
    }

    public boolean estFini(){

        for(char c : this.TabMot){
            if(c == '*')
                return false;
        }
        return true;
    }
}
