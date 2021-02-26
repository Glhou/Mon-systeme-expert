package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//TODO choix de la base de fait
//TODO chainage avant
//TODO affichage dynamique des faits déduits
//TODO lien de l'input avec le but
//TODO chainage arrière

public class Window extends JFrame {

    private String but;
    private MI mi;
    private BDF bdf;
    private BDR bdr;
    private String nomBDR;
    private String[] nomsBDF;


    public Window(String s,String nomBDR,String[] nomsBDF){
        super(s);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200,800);
        setLayout(null);
        quitButton();
        chainageAvantButton();
        chainageArriereButton();
        textFieldDroite();
        mi = new MI(nomBDR,nomsBDF[0]);
        bdf = mi.getBFaits();
        bdr = mi.getBRegles();

        baseDeFaitsComboBox(nomsBDF);
        faitsDeduitsList(bdf.getContenu().toArray());

        String[][] data = buildData(bdr);
        String[] header = bdr.getContenu().get(0).getSchema();

        table(data,header);
        setVisible(true);
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

            }
        });
        getContentPane().add(chainageAvant);
    }

    private void chainageArriereButton(){
        JButton chainageArriere = new JButton("Chainage Arriere");
        chainageArriere.setBounds(960,150,200,30);
        chainageArriere.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        getContentPane().add(chainageArriere);
    }

    private void textFieldDroite(){
        JTextField text = new JTextField(30);
        text.setBounds(960,200,200,30);
        text.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                but = text.getText();
                System.out.println(but);
            }
        });
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
                bdf = new BDF(selected.toString());
                faitsDeduitsList(bdf.getContenu().toArray());
                System.out.println("selected item = " + selected);
            }
        });
        getContentPane().add(bdfcb);
    }

    private void faitsDeduitsList(Object[] data){
        JLabel basedefaits = new JLabel("Faits déduits");
        basedefaits.setBounds(760,70,100,30);
        getContentPane().add(basedefaits);

        JList faitsDList = new JList(data);
        JScrollPane faitsDListScroll = new JScrollPane((faitsDList));
        faitsDListScroll.setBounds(700,100,200,100);
        getContentPane().add(faitsDListScroll);
    }

    private void table(Object[][] data,Object[] header){
        JLabel basedefaits = new JLabel("Base de Règles");
        basedefaits.setBounds(560,230,100,30);
        getContentPane().add(basedefaits);

        JTable table = new JTable(data,header);
        table.setBounds(100,290,1000,540);
        table.getTableHeader().setBounds(100,260,1000,30);
        getContentPane().add(table.getTableHeader());
        getContentPane().add(table);
    }
}
