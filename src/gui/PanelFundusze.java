/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;


import inwestujacy.Fundusz;
import org.jdesktop.observablecollections.ObservableList;
import projekt.Swiat;

/**
 *
 * @author Monika Zielińska
 */
public class PanelFundusze extends javax.swing.JPanel {
    
    private ObservableList<Fundusz> fundusze;
    
    /**
     * Creates new form OknoAktywa
     */
    public PanelFundusze() {
        this.fundusze = Swiat.listaFunduszy;
        
        initComponents();
        usunFunduszPrzycisk.setEnabled(false);
        informacjePanel.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        dodajFunduszPrzycisk = new javax.swing.JButton();
        usunFunduszPrzycisk = new javax.swing.JButton();
        listaFunduszyScrollPane = new javax.swing.JScrollPane();
        funduszeList = new javax.swing.JList<>();
        listaFunduszyLabel = new javax.swing.JLabel();
        informacjePanel = new javax.swing.JPanel();
        informacjeLabel = new javax.swing.JLabel();
        nazwiskoTextField = new javax.swing.JTextField();
        budzetTextField = new javax.swing.JTextField();
        nazwiskoLabel = new javax.swing.JLabel();
        budzetLabel = new javax.swing.JLabel();
        imieLabel = new javax.swing.JLabel();
        imieTextField = new javax.swing.JTextField();
        posiadaneAktywaScrollPane = new javax.swing.JScrollPane();
        posiadaneAktywaList = new javax.swing.JList<>();
        posiadaneAktywaLabel = new javax.swing.JLabel();
        nazwaLabel = new javax.swing.JLabel();
        nazwaTextField = new javax.swing.JTextField();
        jednostkiUczestnictwaLabel = new javax.swing.JLabel();
        iloscLabel = new javax.swing.JLabel();
        wartoscLabel = new javax.swing.JLabel();
        wartoscTextField = new javax.swing.JTextField();
        iloscTextField = new javax.swing.JTextField();

        dodajFunduszPrzycisk.setText("Dodaj fundusz");
        dodajFunduszPrzycisk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dodajFunduszPrzyciskActionPerformed(evt);
            }
        });

        usunFunduszPrzycisk.setText("Usuń fundusz");
        usunFunduszPrzycisk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usunFunduszPrzyciskActionPerformed(evt);
            }
        });

        funduszeList.setInheritsPopupMenu(true);

        org.jdesktop.beansbinding.ELProperty eLProperty = org.jdesktop.beansbinding.ELProperty.create("${fundusze}");
        org.jdesktop.swingbinding.JListBinding jListBinding = org.jdesktop.swingbinding.SwingBindings.createJListBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, funduszeList);
        bindingGroup.addBinding(jListBinding);
        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${fundusz}"), funduszeList, org.jdesktop.beansbinding.BeanProperty.create("selectedElement"));
        bindingGroup.addBinding(binding);

        funduszeList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                funduszeListValueChanged(evt);
            }
        });
        listaFunduszyScrollPane.setViewportView(funduszeList);

        listaFunduszyLabel.setText("Wybierz fundusz:");
        listaFunduszyLabel.setToolTipText("");

        informacjeLabel.setText("Informacje i edycja:");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${fundusz.nazwisko}"), nazwiskoTextField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        budzetTextField.setEditable(false);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${fundusz.budzet}"), budzetTextField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        nazwiskoLabel.setText("Nazwisko:");

        budzetLabel.setText("Budżet:");

        imieLabel.setText("Imię:");

        imieTextField.setToolTipText("");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${fundusz.imie}"), imieTextField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        eLProperty = org.jdesktop.beansbinding.ELProperty.create("${fundusz.listaPosiadanychAktywow}");
        jListBinding = org.jdesktop.swingbinding.SwingBindings.createJListBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, posiadaneAktywaList);
        bindingGroup.addBinding(jListBinding);

        posiadaneAktywaScrollPane.setViewportView(posiadaneAktywaList);

        posiadaneAktywaLabel.setText("Lista posiadanych aktywów:");

        nazwaLabel.setText("Nazwa:");

        nazwaTextField.setToolTipText("");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${fundusz.nazwa}"), nazwaTextField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jednostkiUczestnictwaLabel.setText("Jednostki uczestnictwa:");

        iloscLabel.setText("Ilość:");

        wartoscLabel.setText("Wartość:");

        wartoscTextField.setEditable(false);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${fundusz.jednostkaUczestnictwa.wartoscAktualna}"), wartoscTextField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        iloscTextField.setEditable(false);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${fundusz.jednostkaUczestnictwa.ilosc}"), iloscTextField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        javax.swing.GroupLayout informacjePanelLayout = new javax.swing.GroupLayout(informacjePanel);
        informacjePanel.setLayout(informacjePanelLayout);
        informacjePanelLayout.setHorizontalGroup(
            informacjePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(informacjePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(informacjePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(informacjePanelLayout.createSequentialGroup()
                        .addGroup(informacjePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nazwaLabel)
                            .addComponent(imieLabel)
                            .addComponent(nazwiskoLabel)
                            .addComponent(budzetLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(informacjePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, informacjePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(informacjePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(budzetTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nazwiskoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(nazwaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(imieTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(posiadaneAktywaScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                    .addGroup(informacjePanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(informacjePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(informacjePanelLayout.createSequentialGroup()
                                .addComponent(wartoscLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(wartoscTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, informacjePanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(iloscTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(informacjePanelLayout.createSequentialGroup()
                        .addGroup(informacjePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(informacjeLabel)
                            .addComponent(jednostkiUczestnictwaLabel)
                            .addComponent(posiadaneAktywaLabel)
                            .addGroup(informacjePanelLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(iloscLabel)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(30, 30, 30))
        );
        informacjePanelLayout.setVerticalGroup(
            informacjePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(informacjePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(informacjeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(informacjePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nazwaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nazwaLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(informacjePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(imieTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imieLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(informacjePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nazwiskoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nazwiskoLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(informacjePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(budzetTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(budzetLabel))
                .addGap(10, 10, 10)
                .addComponent(jednostkiUczestnictwaLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(informacjePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(iloscTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(iloscLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(informacjePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(wartoscLabel)
                    .addComponent(wartoscTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(posiadaneAktywaLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(posiadaneAktywaScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(dodajFunduszPrzycisk, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                        .addComponent(listaFunduszyScrollPane, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(usunFunduszPrzycisk, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
                    .addComponent(listaFunduszyLabel))
                .addGap(30, 30, 30)
                .addComponent(informacjePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(listaFunduszyLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(listaFunduszyScrollPane)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dodajFunduszPrzycisk)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usunFunduszPrzycisk)
                .addGap(30, 30, 30))
            .addComponent(informacjePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        listaFunduszyLabel.getAccessibleContext().setAccessibleName("");

        bindingGroup.bind();
    }// </editor-fold>//GEN-END:initComponents

    private void dodajFunduszPrzyciskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dodajFunduszPrzyciskActionPerformed
        Swiat.stworzFundusz();
        funduszeList.setSelectedIndex(funduszeList.getLastVisibleIndex());
    }//GEN-LAST:event_dodajFunduszPrzyciskActionPerformed

    private void usunFunduszPrzyciskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usunFunduszPrzyciskActionPerformed
        if(funduszeList.getSelectedIndex() == -1) return;
        fundusz.usunInwestujacy();
        usunFunduszPrzycisk.setEnabled(false);
    }//GEN-LAST:event_usunFunduszPrzyciskActionPerformed

    private void funduszeListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_funduszeListValueChanged
        if(funduszeList.getSelectedIndex() != -1) {
            usunFunduszPrzycisk.setEnabled(true);
            informacjePanel.setVisible(true);
        }
        else informacjePanel.setVisible(false);
    }//GEN-LAST:event_funduszeListValueChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel budzetLabel;
    private javax.swing.JTextField budzetTextField;
    private javax.swing.JButton dodajFunduszPrzycisk;
    private javax.swing.JList<String> funduszeList;
    private javax.swing.JLabel iloscLabel;
    private javax.swing.JTextField iloscTextField;
    private javax.swing.JLabel imieLabel;
    private javax.swing.JTextField imieTextField;
    private javax.swing.JLabel informacjeLabel;
    private javax.swing.JPanel informacjePanel;
    private javax.swing.JLabel jednostkiUczestnictwaLabel;
    private javax.swing.JLabel listaFunduszyLabel;
    private javax.swing.JScrollPane listaFunduszyScrollPane;
    private javax.swing.JLabel nazwaLabel;
    private javax.swing.JTextField nazwaTextField;
    private javax.swing.JLabel nazwiskoLabel;
    private javax.swing.JTextField nazwiskoTextField;
    private javax.swing.JLabel posiadaneAktywaLabel;
    private javax.swing.JList<String> posiadaneAktywaList;
    private javax.swing.JScrollPane posiadaneAktywaScrollPane;
    private javax.swing.JButton usunFunduszPrzycisk;
    private javax.swing.JLabel wartoscLabel;
    private javax.swing.JTextField wartoscTextField;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    /**
     *
     * @return
     */
    public ObservableList<Fundusz> getFundusze() {
        return fundusze;
    }

    /**
     *
     * @param fundusze
     */
    public void setFundusze(ObservableList<Fundusz> fundusze) {
        this.fundusze = fundusze;
    }

    private Fundusz fundusz;

    /**
     *
     */
    public static final String PROP_FUNDUSZ = "fundusz";

    /**
     * Get the value of fundusz
     *
     * @return the value of fundusz
     */
    public Fundusz getFundusz() {
        return fundusz;
    }

    /**
     * Set the value of fundusz
     *
     * @param fundusz new value of fundusz
     */
    public void setFundusz(Fundusz fundusz) {
        Fundusz oldFundusz = this.fundusz;
        this.fundusz = fundusz;
        firePropertyChange(PROP_FUNDUSZ, oldFundusz, fundusz);
    }

    
    
    
}
