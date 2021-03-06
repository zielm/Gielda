/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import bledy.*;
import java.awt.CardLayout;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import projekt.Start;
import projekt.Swiat;

/**
 *
 * @author Monika Zielińska
 */
public class PanelStart extends javax.swing.JPanel {

    
    /**
     * Creates new form OknoStart
     */
    public PanelStart() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        opisLabel = new javax.swing.JLabel();
        gieldyLabel = new javax.swing.JLabel();
        iloscGieldTextField = new javax.swing.JTextField();
        iloscSurowcowTextField = new javax.swing.JTextField();
        surowceLabel = new javax.swing.JLabel();
        walutyLabel = new javax.swing.JLabel();
        iloscWalutTextField = new javax.swing.JTextField();
        spolkiLabel = new javax.swing.JLabel();
        iloscSpolekTextField = new javax.swing.JTextField();
        inwestorzyLabel = new javax.swing.JLabel();
        iloscInwestorowTextField = new javax.swing.JTextField();
        funduszeLabel = new javax.swing.JLabel();
        iloscFunduszyTextField = new javax.swing.JTextField();
        startButton = new javax.swing.JButton();
        wczytajButton = new javax.swing.JButton();
        zmienKarteButton = new javax.swing.JButton();

        opisLabel.setText("Wprowadź początkowe dane potrzebne do rozpoczęcia symulacji:");

        gieldyLabel.setText("Ilość giełd:");

        iloscGieldTextField.setText("2");
        iloscGieldTextField.setMinimumSize(new java.awt.Dimension(40, 20));
        iloscGieldTextField.setPreferredSize(new java.awt.Dimension(60, 20));

        iloscSurowcowTextField.setText("5");

        surowceLabel.setText("Ilość surowców:");

        walutyLabel.setText("Ilość walut:");

        iloscWalutTextField.setText("2");

        spolkiLabel.setText("Ilość spółek:");

        iloscSpolekTextField.setText("20");

        inwestorzyLabel.setText("Ilość inwestorów:");

        iloscInwestorowTextField.setText("10");

        funduszeLabel.setText("Ilość funduszy:");

        iloscFunduszyTextField.setText("1");

        startButton.setText("Rozpocznij symulację");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        wczytajButton.setText("Wczytaj zapisaną symulację");
        wczytajButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wczytajButtonActionPerformed(evt);
            }
        });

        zmienKarteButton.setText("Zmień Kartę");
        zmienKarteButton.setVisible(false);
        zmienKarteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zmienKarteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(gieldyLabel)
                            .addComponent(walutyLabel)
                            .addComponent(surowceLabel)
                            .addComponent(spolkiLabel)
                            .addComponent(inwestorzyLabel)
                            .addComponent(funduszeLabel))
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(iloscSurowcowTextField)
                                .addComponent(iloscWalutTextField)
                                .addComponent(iloscSpolekTextField)
                                .addComponent(iloscInwestorowTextField)
                                .addComponent(iloscFunduszyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(iloscGieldTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(startButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(wczytajButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(203, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addComponent(opisLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(zmienKarteButton))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(opisLabel))
                    .addComponent(zmienKarteButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gieldyLabel)
                    .addComponent(iloscGieldTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(surowceLabel)
                    .addComponent(iloscSurowcowTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(walutyLabel)
                    .addComponent(iloscWalutTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spolkiLabel)
                    .addComponent(iloscSpolekTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inwestorzyLabel)
                    .addComponent(iloscInwestorowTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(funduszeLabel)
                    .addComponent(iloscFunduszyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(startButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(wczytajButton)
                .addContainerGap(34, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed

        try {
            int iloscGield = Integer.parseInt(iloscGieldTextField.getText());
            int iloscSurowcow = Integer.parseInt(iloscSurowcowTextField.getText());
            int iloscWalut = Integer.parseInt(iloscWalutTextField.getText());
            int iloscSpolek = Integer.parseInt(iloscSpolekTextField.getText());
            int iloscInwestorow = Integer.parseInt(iloscInwestorowTextField.getText());
            int iloscFunduszy = Integer.parseInt(iloscFunduszyTextField.getText());
            
            if (iloscGield < 1) throw new ZaMaloObiektow("giełd");
            if (iloscWalut < 1) throw new ZaMaloObiektow("walut");
            if (iloscSurowcow < 0 || iloscSpolek < 0 || iloscInwestorow < 0 || iloscFunduszy < 0)
                throw new LiczbaUjemna();
            
            try {
                for (int i = 0; i < iloscWalut; i++) {
                    Swiat.stworzWaluta();
                } 
            } catch (BrakWalutDoWylosowania ex) {
                    System.err.println("Nie można stworzyć nowej waluty, brak możliwej nazwy dla kolejnej waluty.");
                }       
            
            for (int i = 0; i < iloscGield; i++) {
                Swiat.stworzGielda();
            }
            
            try {
                for (int i = 0; i < iloscSurowcow; i++) {
                    Swiat.stworzSurowiec();
                }
            } catch (BrakSurowcaDoWylosowania ex) {
            System.err.println("Nie można stworzyć nowego surowca, brak możliwej nazwy dla kolejnego surowca");
            }
            
            for(int i = 0; i < iloscSpolek; i++) {
                Swiat.stworzSpolka();
            }
            
            for(int i = 0; i < iloscInwestorow; i++) {
                Swiat.stworzInwestor();
            }
            
            for(int i = 0; i < iloscFunduszy; i++) {
                Swiat.stworzFundusz();
            }
            
            Swiat.setDzialanieSymulacji(true);
            CardLayout karta = (CardLayout) getParent().getLayout();
            karta.show(getParent(), (String)("panelGlowny") );
            
        } catch (NumberFormatException numberFormatException) {
            System.err.println("Zły format w jednej z wypełnianych komórek");
        } catch (ZaMaloObiektow ex) {
            System.err.println("Za mało " + ex.getMessage());
        } catch (LiczbaUjemna ex) {
            System.err.println("Ilość obiektów nie może być ujemna");
        }
    }//GEN-LAST:event_startButtonActionPerformed

    private void wczytajButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wczytajButtonActionPerformed
        try {
            Start.wczytaj();
            System.out.println("Wczytanie zakończone powodzeniem");
        } catch (IOException ex) {
            System.out.println("błąd wczytywania IOException");
            Logger.getLogger(Start.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            System.out.println("błąd wczytywania ClassNotFoundException");
            Logger.getLogger(Start.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            System.out.println("nieznany błąd wczytywania");
        }
    }//GEN-LAST:event_wczytajButtonActionPerformed

    private void zmienKarteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zmienKarteButtonActionPerformed
        CardLayout karta = (CardLayout) getParent().getLayout();
        karta.show(getParent(), (String)("panelGlowny") );
        Swiat.wczytane = true;
    }//GEN-LAST:event_zmienKarteButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel funduszeLabel;
    private javax.swing.JLabel gieldyLabel;
    private javax.swing.JTextField iloscFunduszyTextField;
    private javax.swing.JTextField iloscGieldTextField;
    private javax.swing.JTextField iloscInwestorowTextField;
    private javax.swing.JTextField iloscSpolekTextField;
    private javax.swing.JTextField iloscSurowcowTextField;
    private javax.swing.JTextField iloscWalutTextField;
    private javax.swing.JLabel inwestorzyLabel;
    private javax.swing.JLabel opisLabel;
    private javax.swing.JLabel spolkiLabel;
    private javax.swing.JButton startButton;
    private javax.swing.JLabel surowceLabel;
    private javax.swing.JLabel walutyLabel;
    private javax.swing.JButton wczytajButton;
    public javax.swing.JButton zmienKarteButton;
    // End of variables declaration//GEN-END:variables
}
