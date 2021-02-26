package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Scanner;

public class BDF {
    private ArrayList<String> contenu;
    private int taille;
    private String nomFichier;

    public BDF(String nomFichier){
        this.nomFichier = nomFichier;
        //String fait="";
        contenu = new ArrayList<String>();
        BufferedReader br;
        String Line ="";
        try{
            br = new BufferedReader(new FileReader(nomFichier));
            while (Line != null){
                Line = br.readLine();
                if (Line != null && Line!=""){
                    contenu.add(Line);
                }
            }
            br.close();
        } catch (Exception e){
            System.out.println("Erreur d'ouverture avec : " + e);
        }
        taille = contenu.size();

        /*
        Scanner entree = new Scanner(System.in);
        System.out.println("Saisie des faits en terminant par fin :");
        while(!fait.equals("fin")){
            System.out.print("fait : ");
            fait = entree.nextLine();
            if(!fait.equals("fin")) {
                contenu.add(fait);
                taille += 1;
            }
        }
         */
    }

    public void ajoutBDF(String fait){
        contenu.add(fait);
        taille += 1;
    }

    public ArrayList<String> getContenu() {
        return contenu;
    }

    public int getTaille() {
        return taille;
    }

    @Override
    public String toString() {
        return "BDF{" +
                "contenu=" + contenu +
                ", taille=" + taille +
                '}';
    }

    public void MAJFichier(){
        FileWriter fw;
        try{
            fw = new FileWriter(nomFichier+"_result");
            for(int i=0;i<taille;i++){
                fw.write(contenu.get(i) + "\n");
            }
            fw.close();
            System.out.println("Mise à jour du fichier " + nomFichier);
        } catch (Exception e){
            System.out.printf("Erreur d'ouverture avec : " + e);
        }
    }
}
