/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aktywa;

import java.io.Serializable;
import projekt.Losowanie;


/**
 * Para: waluta i jej cena kupna
 * @author Monika Zielińska
 */
public class Kurs implements Serializable{
    private Waluta walutaKupno;
    private double cenaKupna; 

    /**
     * 
     * @param walutaKupno
     */
    public Kurs(Waluta walutaKupno) {
        this.walutaKupno = walutaKupno; 
        double cena = Losowanie.losujDouble()*10;
        while(cena > 6) {
            cena -= 0.5;
        }
        if(cena < 0.4) cena += 0.5;
        this.cenaKupna = Losowanie.round(cena, 2);
    }

    /**
     *
     * @param walutaKupno
     * @param cenaKupna
     */
    public Kurs(Waluta walutaKupno, double cenaKupna) {
        this.walutaKupno = walutaKupno;
        this.cenaKupna = cenaKupna;
    }

    

    /**
     *
     * @return waluta
     */
    public Waluta getWalutaKupno() {
        return walutaKupno;
    }

    /**
     *
     * @param walutaKupno 
     */
    public void setWalutaKupno(Waluta walutaKupno) {
        this.walutaKupno = walutaKupno;
    }

    /**
     *
     * @return cena kupna waluty
     */
    public double getCenaKupna() {
        return cenaKupna;
    }

    /**
     *
     * @param cenaKupna
     */
    public void setCenaKupna(double cenaKupna) {
        this.cenaKupna = Losowanie.round(cenaKupna, 2);
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return walutaKupno + " " + cenaKupna;
    }
    
    
    

    
    
    

    
    
    
}
