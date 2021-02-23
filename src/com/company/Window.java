package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Window extends JFrame {

    private String but;
    private String[] baseDeFaits;
    private String[] faits;
    private Object[][] data;


    public Window(String s){
        super(s);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200,800);
        setLayout(null);
        quitButton();
        chainageAvantButton();
        chainageArriereButton();
        textFieldDroite();
        baseDeFaits = new String[] {"Java in python","Java for dumies","Java for Breakfast"};
        baseDeFaitsComboBox(baseDeFaits);
        faits = new String[] {"Il mange le java","Il vit le java","Il adore le java","Il dort le java"};
        faitsDeduitsList(faits);
        faits[3] = "Il dors le java"; // test qui prouve qu'on a juste à modifier la data qu'on entre et ça modifie dans l'affichage ce qui est top
        data = new Object[][] {{"John","Vic",2}};
        String[] header = new String[] {"Nom","Prenom","Age"};
        table(data,header);
        setVisible(true);
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
                System.out.println("selected item = " + selected);
                String command = e.getActionCommand();
                System.out.println(command);
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
        faitsDListScroll.setBounds(700,100,200,50);
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
