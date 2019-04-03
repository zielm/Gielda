/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inwestujacy;

import aktywa.JednostkaUczestnictwa;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import projekt.Losowanie;
import projekt.Swiat;

/**
 *
 * @author Monika Zielińska
 */
public class Fundusz extends Inwestujacy {
    
    private String nazwa;
    private JednostkaUczestnictwa jednostkaUczestnictwa;

    /**
     * Konstruktor funduszu
     */
    public Fundusz() {
        nazwa = Losowanie.losujNazweFundusz();
        jednostkaUczestnictwa = new JednostkaUczestnictwa(this);   
    }
   
    @Override
    public void run() {
        while(getIstnienieInwestujacego()){
            while(Swiat.isDzialanieSymulacji()) {
                try {
                    sleep((long)(1000*Losowanie.losujDouble()));
                } catch (InterruptedException ex) {
                    Logger.getLogger(Fundusz.class.getName()).log(Level.SEVERE, null, ex);
                }
                double opcja = Losowanie.losujDouble();
                if(opcja < 0.7 && getBudzet() > 0) {
                    kupAktywa();
                }
                else {
                    sprzedajAktywa();
                }    
            }
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Fundusz.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public String toString() {
        return this.nazwa;
    }
    
    /**
     *
     * @return nazwa funduszu
     */
    public String getNazwa() {
        return nazwa;
    }

    /**
     *
     * @param nazwa nazwa funduszu
     */
    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    /**
     *
     * @return jednostka uczestnictwa funduszu
     */
    public JednostkaUczestnictwa getJednostkaUczestnictwa() {
        return jednostkaUczestnictwa;
    }

    /**
     *
     * @param jednostkaUczestnictwa jednostka uczestnictwa funduszu
     */
    public void setJednostkaUczestnictwa(JednostkaUczestnictwa jednostkaUczestnictwa) {
        this.jednostkaUczestnictwa = jednostkaUczestnictwa;
    }
    
}
