package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;




public class Window extends JFrame {

    private String but;
    private MI mi;
    private String currentBDF;
    private String nomBDR;
    private String[] nomsBDF;
    private  DefaultListModel listModel;


    public Window(String s,String nomBDR,String[] nomsBDF){
        super(s);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200,800);
        setLayout(null);
        quitButton();
        chainageAvantButton();
        chainageArriereButton();
        resetBDFButton();
        textFieldDroite();

        listModel = new DefaultListModel();

        currentBDF = nomsBDF[0];

        mi = new MI(nomBDR,nomsBDF[0]);
        // donnés utilisés juste pour que ça soit plus lisible
        BDF bdf = mi.getBFaits();
        BDR bdr = mi.getBRegles();

        baseDeFaitsComboBox(nomsBDF);
        faitsDeduitsList(bdf.getContenu().toArray());

        String[][] data = buildData(bdr);
        String[] header = bdr.getContenu().get(0).getSchema();

        table(data,header);
        setVisible(true);
    }

    private void resetBDFButton(){
        JButton b = new JButton("Reset");
        b.setBounds(760,200,100,30);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("reset bdf list");
                reloadList(currentBDF);
            }
        });
        getContentPane().add(b);
    }


    private String[][] buildData(BDR bdr){
        int n = bdr.getTaille();
        int m = bdr.getContenu().get(0).getValeurs().length;
        String[][] data = new String[n][m];
        for (int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                data[i][j] = bdr.getContenu().get(i).getValeurs()[j];
            }
        }
        return data;
    }

    private void quitButton(){
        JButton quit = new JButton("Quitter");
        // positionnement et dimt manuel du bouton
        quit.setBounds(1000, 50, 80, 30);
        // traitement d'un clic sur le bouton
        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // quand on a clique sur le bouton
                //"Quitter", on sort du programme
                System.exit(0);
            }
        });
        getContentPane().add(quit);
    }

    private void chainageAvantButton(){
        JButton chainageAvant = new JButton("Chainage Avant");
        chainageAvant.setBounds(960,100,200,30);
        chainageAvant.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mi.chainageAvant();
                System.out.println("Chainage Avant");
                reloadList(currentBDF + "_result");
            }
        });
        getContentPane().add(chainageAvant);
    }

    private void chainageArriereButton(){
        // label de résultat
        JLabel resultatLabel = new JLabel();
        resultatLabel.setBounds(960,230,200,30);

        JButton chainageArriere = new JButton("Chainage Arriere");
        chainageArriere.setBounds(960,150,200,30);
        chainageArriere.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Chainage arrière");
                boolean result = mi.chainageArriere(but);
                if (result)
                    resultatLabel.setText(but + " est vérifié");

                else
                    resultatLabel.setText(but + " n'est pas vérifié");
            }
        });
        getContentPane().add(resultatLabel);
        getContentPane().add(chainageArriere);
    }

    private void textFieldDroite(){
        JButton b = new JButton("Valider");
        b.setBounds(1080,200,80,30);

        JTextField text = new JTextField("But",30);
        text.setBounds(960,200,110,30);
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                but = text.getText();
                System.out.println(but);
            }
        });
        getContentPane().add(b);
        getContentPane().add(text);
    }

    private void baseDeFaitsComboBox(Object[] data){
        JLabel basedefaits = new JLabel("Base De Faits");
        basedefaits.setBounds(360,70,100,30);
        getContentPane().add(basedefaits);

        JComboBox bdfcb = new JComboBox(data);
        bdfcb.setBounds(300,100,200,30);
        bdfcb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object selected = bdfcb.getSelectedItem();
                reloadList(selected.toString());
                System.out.println("selected item = " + selected);
            }
        });
        getContentPane().add(bdfcb);
    }

    private void faitsDeduitsList(Object[] data){
        JLabel basedefaits = new JLabel("Faits déduits");
        basedefaits.setBounds(760,70,100,30);
        getContentPane().add(basedefaits);

        JList faitsDList = new JList(listModel);
        for (int i=0;i<data.length;i++) {
            listModel.addElement(data[i]);
        }
        JScrollPane faitsDListScroll = new JScrollPane((faitsDList));
        faitsDListScroll.setBounds(700,100,200,100);
        getContentPane().add(faitsDListScroll);
    }

    private void reloadList(String nomBDF){
        currentBDF = nomBDF.split("_")[0];// le split permet de ne pas avoir le _result en plus comme ça on garde le nom original
        mi.setBFaits(new BDF(nomBDF));
        Object[] data = mi.getBFaits().getContenu().toArray();
        listModel.removeAllElements();
        for (int i=0;i<data.length;i++) {
            listModel.addElement(data[i]);
        }
    }

    private void table(Object[][] data,Object[] header){
        JLabel basedefaits = new JLabel("Base de Règles");
        basedefaits.setBounds(560,280,100,30);
        getContentPane().add(basedefaits);

        JTable table = new JTable(data,header);
        table.setBounds(100,330,1000,500);
        table.getTableHeader().setBounds(100,310,1000,20);
        getContentPane().add(table.getTableHeader());
        getContentPane().add(table);
    }
}
