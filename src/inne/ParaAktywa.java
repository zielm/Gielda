/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inne;

import aktywa.Aktywa;
import java.io.Serializable;

/**
 * Klasa do przechowywanie aktywa i jego ilości
 * @author Monika Zielińska
 */
public class ParaAktywa implements Serializable{
    private Aktywa aktywa;
    private int ilosc;

    /**
     *
     * @param aktywa
     * @param ilosc
     */
    public ParaAktywa(Aktywa aktywa, int ilosc) {
        this.aktywa = aktywa;
        this.ilosc = ilosc;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return aktywa + ": " + ilosc;
    }

    /**
     *
     * @return
     */
    public Aktywa getAktywa() {
        return aktywa;
    }

    /**
     *
     * @param aktywa
     */
    public void setAktywa(Aktywa aktywa) {
        this.aktywa = aktywa;
    }

    /**
     *
     * @return
     */
    public int getIlosc() {
        return ilosc;
    }

    /**
     *
     * @param ilosc
     */
    public void setIlosc(int ilosc) {
        this.ilosc = ilosc;
    }
    
    /**
     *
     * @param ile
     */
    public void zwiekszIlosc(int ile) {
        this.ilosc += ile;
    }
    
    /**
     *
     * @param ile
     */
    public void zmniejszIlosc(int ile) {
        this.ilosc -= ile;
    }
    
    
}
