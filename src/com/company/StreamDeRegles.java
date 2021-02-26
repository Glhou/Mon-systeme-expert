package com.company;

import java.io.BufferedReader;
import java.io.FileReader;

public class StreamDeRegles {
    private FileReader descripteur; // représente le fichier
    private BufferedReader buffer; // données
    private Regle regle;

    public StreamDeRegles(String name) { // constructeur qui va à partir du nom du fichier
        // (en paramètres) l'ouvrir et le préparer à la lecture ligne par ligne
        // lire la première ligne qui fournira les données pour le tableau schéma
        try {// try et catch permettent la gestion des exceptions
            descripteur = new FileReader(name);
            // et le nom de la variable qui désigne ce fichier dans le programme
            // est descripteur
            buffer = new BufferedReader(descripteur); // est le fichier dans la mémoire tampon
            // et permet la lecture ligne par ligne
            System.out.println("ouverture réussie");

        } catch (Exception e) {
            System.out.println("Erreur d'ouverture avec : " + e);
        }
        String ss=null;

        try{
            ss = buffer.readLine();
        } catch (Exception e) {
            System.out.println("Erreur de lecture avec : " + e);
        }
        String[] tab1;
        tab1 = ss.split(";");
        regle = new Regle(tab1);
    }

    public Regle getRegleSuivante(){
        String ss=null;

        try{
            ss = buffer.readLine();
        } catch (Exception e) {
            System.out.println("Erreur de lecture avec : " + e);
        }
        if(ss == null)
            return null;
        else {
            regle.setValeurs(ss.split(";"));
            return regle;
        }
    }

    @Override
    public String toString() {
        return "StreamDeRegles{" +
                "regle=" + regle +
                '}';
    }

    public Regle getRegle() {
        return regle;
    }

}
