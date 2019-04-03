/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aktywa;

import projekt.Losowanie;
import inwestujacy.Fundusz;
import inwestujacy.Inwestujacy;
import projekt.Swiat;

/**
 *
 * @author Monika Zielińska
 */
public class JednostkaUczestnictwa extends Aktywa{
    
    private Fundusz fundusz;
    private int ilosc;

    /**
     *
     * @param fundusz
     */
    public JednostkaUczestnictwa(Fundusz fundusz) {
        super.setNazwa(("jednostki " + fundusz.getNazwa()));
        this.fundusz = fundusz;
        this.ilosc = 0;
        double b = Losowanie.round(100*Losowanie.losujDouble(),2)+10;
        super.setWartoscPierwszyRaz(b);
        this.setRynek(null);
        Swiat.listaAktywa.add(this);
        Swiat.listaJednostekUczestnictwa.add(this);
    }

    /**
     *
     * @return
     */
    public Fundusz getFundusz() {
        return fundusz;
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
     * @param ilosc
     */
    public void zwiekszIlosc(int ilosc) {
        this.ilosc += ilosc;
    }
    
    /**
     *
     * @param ilosc
     */
    public void zmniejszIlosc(int ilosc) {
        this.ilosc -= ilosc;
    }

    @Override
    public int kup(Inwestujacy inw, int ilosc) {
       double cena = Losowanie.round(getWartoscAktualna()*ilosc,2);
       if(inw.getBudzet() < cena) return 0;
       else {
           inw.zmniejszBudzet(cena);
           zwiekszIlosc(ilosc);
           fundusz.zwiekszBudzet(cena);
           return ilosc;
       }
    }

    @Override
    public double sprzedaj(int ilosc) {
        zmniejszIlosc(ilosc);
        double cena = Losowanie.round(ilosc*getWartoscAktualna(),2);
        fundusz.zmniejszBudzet(cena);
        return cena;
    }
    
    

    
    
    
}
