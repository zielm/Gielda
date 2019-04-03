/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aktywa;

import bledy.BrakSurowcaDoWylosowania;
import projekt.Losowanie;
import inne.ParaString;
import inwestujacy.Inwestujacy;
import java.util.ArrayList;
import java.util.List;
import projekt.Swiat;

/**
 *
 * @author Monika Zielińska
 */
public class Surowiec extends Aktywa{
    
    private ParaString dane;
    private String jednostka;
    private Waluta waluta;
    private List <Inwestujacy> listaPosiadaczySurowca;
    
    /**
     *
     * @throws BrakSurowcaDoWylosowania
     */
    public Surowiec() throws BrakSurowcaDoWylosowania {
        dane = Losowanie.losujNowySurowiec();
        super.setNazwa(dane.getPierwszy());
        jednostka = dane.getDrugi();
        this.waluta = Losowanie.losujWaluta(); 
        this.listaPosiadaczySurowca = new ArrayList<>();
    
        double b = Losowanie.round(100*Losowanie.losujDouble()+0.01,2);
        super.setWartoscPierwszyRaz(b);
        super.setRynek(Swiat.rynekSurowcow);
        
        
    }

    /**
     *
     * @return
     */
    public ParaString getDane() {
        return dane;
    }

    /**
     *
     * @param dane
     */
    public void setDane(ParaString dane) {
        this.dane = dane;
    }

    /**
     *
     * @return
     */
    public String getJednostka() {
        return jednostka;
    }

    /**
     *
     * @param jednostka
     */
    public void setJednostka(String jednostka) {
        this.jednostka = jednostka;
    }

    /**
     *
     * @return
     */
    public Waluta getWaluta() {
        return waluta;
    }

    /**
     *
     * @param waluta
     */
    public void setWaluta(Waluta waluta) {
        this.waluta = waluta;
    }

    /**
     *
     * @return
     */
    public List<Inwestujacy> getListaPosiadaczySurowca() {
        return listaPosiadaczySurowca;
    }

    /**
     *
     * @param listaPosiadaczySurowca
     */
    public void setListaPosiadaczySurowca(List<Inwestujacy> listaPosiadaczySurowca) {
        this.listaPosiadaczySurowca = listaPosiadaczySurowca;
    }
    
    /**
     *
     * @param inwestujacy
     */
    public void usunZListyPosiadaczySurowca(Inwestujacy inwestujacy) {
        listaPosiadaczySurowca.remove(inwestujacy);
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return getNazwa()+" ["+jednostka+"]";
    }
    
    
        /**
     * 
     * @return cena kupna akcji w USD
     */
    public double getCenaKupna() {
        if(waluta.getNazwa().equals("USD")) return getWartoscAktualna();
        double cenaWaluty = waluta.getKursWaluty().get(0).getCenaKupna();
        return getWartoscAktualna() * cenaWaluty;
    }
    
    /**
     * 
     * @return cena sprzedaży akcji z USD do waluty giełdy
     */
    public double getCenaSprzedazy() {
        if(waluta.getNazwa().equals("USD")) return getWartoscAktualna();
        double cenaWaluty = 1;
        for (Kurs kurs : Swiat.listaWalut.get(0).getKursWaluty()) {
            if(kurs.getWalutaKupno() == waluta) {
                cenaWaluty = kurs.getCenaKupna();
            }
        }
        return getWartoscAktualna() * cenaWaluty;
    }
    
    
    
    
}
