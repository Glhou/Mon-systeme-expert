package com.company;

import java.util.Arrays;

public class Regle {
    private String [] schema;
    private String [] valeurs;

    public Regle(String[] val){
        schema = new String[5];
        valeurs = new String[5];

        for (int i=0;i<5;i++){
            if (i < 4) {
                schema[i] = "condition" + i;
            }
            else{
                schema[i] = "conclusion";
            }
            valeurs[i] = val[i];
        }
    }

    public String[] getSchema() {
        return schema;
    }

    public String[] getValeurs() {
        return valeurs;
    }

    public void setValeurs(String[] valeurs) {
        this.valeurs = valeurs;
    }

    @Override
    public String toString() {
        String resultat = "Regle{" ;
        for(int i=0;i<5;i++){
            resultat += schema[i] + " = " + valeurs[i] +", ";
        }
        return resultat;
    }
}
