/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

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
public class PanelGlowny extends javax.swing.JPanel {

    /**
     * Creates new form NewJPanel
     */
    public PanelGlowny() {
        initComponents();
        if(Swiat.wczytane) {
            stopButton.doClick();
        }
        else zapiszButton.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kartyPanel = new javax.swing.JPanel();
        panelAktywa = new gui.PanelAktywa();
        panelSpolki = new gui.PanelSpolki();
        panelInwestorzy = new gui.PanelInwestorzy();
        panelRynki = new gui.PanelRynki();
        panelFundusze1 = new gui.PanelFundusze();
        wyborPanel = new javax.swing.JPanel();
        wyborLabel = new javax.swing.JLabel();
        wyborComboBox = new javax.swing.JComboBox<>();
        wczytajButton = new javax.swing.JButton();
        zapiszButton = new javax.swing.JButton();
        stopButton = new javax.swing.JToggleButton();

        setPreferredSize(new java.awt.Dimension(420, 450));
        setLayout(new java.awt.BorderLayout());

        kartyPanel.setLayout(new java.awt.CardLayout());
        kartyPanel.add(panelAktywa, "panelAktywa");
        panelAktywa.getAccessibleContext().setAccessibleName("");

        kartyPanel.add(panelSpolki, "panelSpolki");
        panelSpolki.getAccessibleContext().setAccessibleName("");

        kartyPanel.add(panelInwestorzy, "panelInwestorzy");
        kartyPanel.add(panelRynki, "panelRynki");
        kartyPanel.add(panelFundusze1, "panelFundusze");

        add(kartyPanel, java.awt.BorderLayout.CENTER);
        kartyPanel.getAccessibleContext().setAccessibleName("kartyPanel");

        wyborPanel.setPreferredSize(new java.awt.Dimension(428, 60));

        wyborLabel.setText("Wybierz listę do wyświetlenia: ");

        wyborComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aktywa", "Spolki", "Rynki", "Inwestorzy", "Fundusze" }));
        wyborComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wyborComboBoxActionPerformed(evt);
            }
        });

        wczytajButton.setText("Wczytaj");
        wczytajButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wczytajButtonActionPerformed(evt);
            }
        });

        zapiszButton.setText("Zapisz");
        zapiszButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zapiszButtonActionPerformed(evt);
            }
        });

        stopButton.setText("Zatrzymaj");
        stopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout wyborPanelLayout = new javax.swing.GroupLayout(wyborPanel);
        wyborPanel.setLayout(wyborPanelLayout);
        wyborPanelLayout.setHorizontalGroup(
            wyborPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(wyborPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(wyborLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(wyborComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(stopButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(wczytajButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(zapiszButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );
        wyborPanelLayout.setVerticalGroup(
            wyborPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(wyborPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(wyborPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(wyborComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(wyborLabel)
                    .addComponent(stopButton)
                    .addComponent(wczytajButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(zapiszButton))
                .addGap(37, 37, 37))
        );

        wyborPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {stopButton, wczytajButton, zapiszButton});

        add(wyborPanel, java.awt.BorderLayout.PAGE_START);

        getAccessibleContext().setAccessibleName("panelGlowny");
    }// </editor-fold>//GEN-END:initComponents

    private void wyborComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wyborComboBoxActionPerformed
        CardLayout karta = (CardLayout) kartyPanel.getLayout();
        String opcja = (String) wyborComboBox.getSelectedItem();
        karta.show(kartyPanel, (String)("panel"+opcja));
        
    }//GEN-LAST:event_wyborComboBoxActionPerformed

    private void stopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopButtonActionPerformed
        if(stopButton.isSelected()) {
            Swiat.setDzialanieSymulacji(false);
            stopButton.setText("Wznów");
            zapiszButton.setEnabled(true);
        }
        else {
            Swiat.setDzialanieSymulacji(true);
            stopButton.setText("Zatrzymaj");
            zapiszButton.setEnabled(false);
        }
    }//GEN-LAST:event_stopButtonActionPerformed

    private void zapiszButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zapiszButtonActionPerformed
        try {
            Start.zapisz();
        } catch (IOException ex) {
            System.out.println("Błąd zapisu");
            Logger.getLogger(Start.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_zapiszButtonActionPerformed

    private void wczytajButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wczytajButtonActionPerformed
       try {
            Start.wczytaj();
            System.out.println("Wczytanie zakończone powodzeniem");
        } catch (IOException ex) {
            System.out.println("błąd wczytywania - IOException");
            Logger.getLogger(Start.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            System.out.println("błąd wczytywania - ClassNotFound EXCEPTION");
            Logger.getLogger(Start.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            System.out.println("Nieznany błąd wczytywania");
        }
    }//GEN-LAST:event_wczytajButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel kartyPanel;
    private gui.PanelAktywa panelAktywa;
    private gui.PanelFundusze panelFundusze1;
    private gui.PanelInwestorzy panelInwestorzy;
    private gui.PanelRynki panelRynki;
    private gui.PanelSpolki panelSpolki;
    private javax.swing.JToggleButton stopButton;
    private javax.swing.JButton wczytajButton;
    private javax.swing.JComboBox<String> wyborComboBox;
    private javax.swing.JLabel wyborLabel;
    private javax.swing.JPanel wyborPanel;
    private javax.swing.JButton zapiszButton;
    // End of variables declaration//GEN-END:variables
}
