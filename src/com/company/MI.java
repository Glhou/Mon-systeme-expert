package com.company;

public class MI {
    private BDF BFaits;
    private BDR BRegles;

    public MI(String nomBDR,String nomBDF){
        BFaits = new BDF(nomBDF);
        BRegles = new BDR(nomBDR);
    }
    public void chainageAvant(){
        boolean[] dejaDeclenchee = new boolean[BRegles.getTaille()];
        boolean saturation = false;
        for(int i = 0; i < BRegles.getTaille(); i++){
            dejaDeclenchee[i] = false;
        }
        while(!saturation){
            int compteur = 0;
            for (int i=0; i< BRegles.getTaille();i++){
                if(!dejaDeclenchee[i]){
                    Regle rcourante = BRegles.getContenu().get(i);
                    if (regleDeclenchee(rcourante)){
                        compteur++;
                        dejaDeclenchee[i] = true;
                        BFaits.ajoutBDF(rcourante.getValeurs()[4]);
                    }
                }
            }
            if(compteur == 0)
                saturation = true;
        }
        BFaits.MAJFichier();
    }
    public boolean chainageArriere(String but){
        if(condDansBDF(but))
            return true;
        for(int i=0;i< BRegles.getTaille();i++){
            Regle rcourante=BRegles.getContenu().get(i);
            if(rcourante.getValeurs()[4].equals(but))
                if(verifRegleDeclencheeArriere(rcourante))
                    return true;
        }
        return false;
    }

    private boolean verifRegleDeclencheeArriere(Regle r){
        // vérifie si une règle peut être déclenchée
        for(int i=0;i<4;i++){
            if(!r.getValeurs()[i].equals("")){
                if(!condDansBDF(r.getValeurs()[i])){
                    if(!chainageArriere(r.getValeurs()[i])){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean regleDeclenchee(Regle r){
        // vérifie si une règle peut être déclenchée
        for(int i=0;i<4;i++){
            if(!r.getValeurs()[i].equals("")){
                if(!condDansBDF(r.getValeurs()[i]))
                        return false;
            }
        }
        return true;
    }

    private boolean condDansBDF(String condition){
        for(int i=0;i< BFaits.getTaille();i++){
            if (BFaits.getContenu().get(i).equals(condition)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "MI{" +
                "Bdf=" + BFaits +
                ", Bdr=" + BRegles +
                '}';
    }
}
