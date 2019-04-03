/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rynki;

import aktywa.Aktywa;
import aktywa.Surowiec;
import projekt.Losowanie;
import inwestujacy.Inwestujacy;
import java.util.ArrayList;
import java.util.List;
import projekt.Swiat;

/**
 *
 * @author Monika Zielińska
 */
public class RynekSurowcow extends Rynek {
    
    private List <Surowiec> listaSurowcow;

    /**
     *
     */
    public RynekSurowcow() {
        super.setNazwa("Rynek Surowców");
        this.listaSurowcow = new ArrayList<>();
    }
    
    /**
     * Usunięcie surowca z systemu
     * @param surowiec usuwany surowiec
     */
    public void usunSurowiec(Surowiec surowiec) {
        Swiat.listaAktywa.remove(surowiec);
        Swiat.listaSurowcow.remove(surowiec);
        wykupAktywaZRynku(surowiec);
        List <Inwestujacy> posiadacze = surowiec.getListaPosiadaczySurowca();
        while(!posiadacze.isEmpty()) {
            Inwestujacy inw = posiadacze.get(0);
            inw.usunAktywoZPosiadanych(surowiec);
            posiadacze.remove(inw);
        }
    }

    @Override
    public int kupAktywaZRynku(Inwestujacy inw, Aktywa aktywo, int ilosc) {
        Surowiec surowiec = (Surowiec) aktywo;
        double wartosc = surowiec.getCenaKupna();
        double cena = wartosc*ilosc;
        cena += pobierzMarze(cena);
        if(inw.getBudzet() < cena) return 0;
        else {
            inw.zmniejszBudzet(cena);
            return ilosc;
        }
    }

    @Override
    public double sprzedajAktywaNaRynek(Aktywa aktywa, int ilosc) {
        Surowiec surowiec = (Surowiec) aktywa;
        double wartosc = surowiec.getCenaKupna();
        double cena = wartosc*ilosc;
        cena -= pobierzMarze(cena);
        return Losowanie.round(cena,2);
    }
    
    
    
    
    

    
    
    
    
}
