/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rynki;

import inwestujacy.Inwestujacy;
import aktywa.Waluta;
import aktywa.Akcja;
import aktywa.Aktywa;
import aktywa.Kurs;
import bledy.BrakGieldyDoWylosowania;
import bledy.ZbytMalaIloscDostepnychAkcji;
import java.util.ArrayList;
import java.util.List;
import projekt.Indeks;
import projekt.Losowanie;
import inne.ParaString;
import projekt.Swiat;


/**
 *
 * @author Monika Zielińska
 */
public class Gielda extends Rynek {
    
    private String kraj;
    private Waluta waluta;
    private String miasto;
    private String adresSiedziby;
    private List <Indeks> listaIndeksow;

    /**
     * Konstruktor giełdy papierów wartościowych
     */
    public Gielda()  {
        try {
            ParaString infoGieldy = Losowanie.losujInfoGieldy();
            super.setNazwa(infoGieldy.getDrugi());
            kraj = infoGieldy.getPierwszy();        
        } catch (BrakGieldyDoWylosowania ex) {
            kraj = Losowanie.losujKraj();
        }
        
        miasto = Losowanie.losujMiasto();
        adresSiedziby = Losowanie.losujAdres();
        waluta = Losowanie.losujWaluta(); 

        this.listaIndeksow = new ArrayList<>();
    }
    
    

    /**
     * Getter kraju
     * @return kraj w którym znajduje się giełda
     */
    public String getKraj() {
        return kraj;
    }

    /**
     * Setter kraju
     * @param kraj kraj w którym znajduje się giełda
     */
    public void setKraj(String kraj) {
        this.kraj = kraj;
    }

    /**
     * Getter waluty
     * @return waluta w której są notowane akcje na giełdzie
     */
    public Waluta getWaluta() {
        return waluta;
    }

    /**
     * Setter waluty
     * @param waluta waluta w której są notowane akcje na giełdzie
     */
    public void setWaluta(Waluta waluta) {
        this.waluta = waluta;
    }

    /**
     * Getter miasta
     * @return miasto w którym mieści się siedziba giełdy
     */
    public String getMiasto() {
        return miasto;
    }

    /**
     * Setter miasta
     * @param miasto w którym mieści się siedziba giełdy
     */
    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    /**
     * Getter adresu
     * @return adres siedziby giełdy
     */
    public String getAdresSiedziby() {
        return adresSiedziby;
    }

    /**
     * Setter adresu
     * @param adresSiedziby adres siedziby giełdy
     */
    public void setAdresSiedziby(String adresSiedziby) {
        this.adresSiedziby = adresSiedziby;
    }
    

    /**
     *
     * @return
     */
    public List<Indeks> getListaIndeksow() {
        return listaIndeksow;
    }

    
    /**
     * 
     * @param akcja akcja która kupujemy
     * @return cena kupna akcji w USD
     */
    public double getCenaKupna(Aktywa akcja) {
        if(waluta.getNazwa().equals("USD")) return akcja.getWartoscAktualna();
        double cenaWaluty = waluta.getKursWaluty().get(0).getCenaKupna();
        return akcja.getWartoscAktualna() * cenaWaluty;
    }
    
    /**
     * 
     * @param akcja
     * @return cena sprzedaży akcji z USD do waluty giełdy
     */
    public double getCenaSprzedazy(Aktywa akcja) {
        if(waluta.getNazwa().equals("USD")) return akcja.getWartoscAktualna();
        double cenaWaluty = 1;
        for (Kurs kurs : Swiat.listaWalut.get(0).getKursWaluty()) {
            if(kurs.getWalutaKupno() == waluta) {
                cenaWaluty = kurs.getCenaKupna();
            }
        }
        return akcja.getWartoscAktualna() * cenaWaluty;
    }
    

    
    /**
     * Dodawanie określonej ilości akcji spółki na giełdę
     * @param akcja akcja dodawana na giełdę
     * @param ilosc ilość akcji dodawanych na giełdę
     */
    public synchronized void dodajAkcjeNaGielde(Akcja akcja, int ilosc){
        if(!getListaAktywRynku().contains(akcja)) {
            dodajDoListyAktywRynku(akcja);
        }
        akcja.zwiekszIlosc(ilosc);
    }
    

    @Override
    public synchronized int kupAktywaZRynku(Inwestujacy inw, Aktywa aktywo, int ilosc) {
        
        double wartosc = getCenaKupna(aktywo);
        
        Akcja akcja = (Akcja) aktywo;
        int dostepnaIlosc = akcja.getDostepnaIlosc();
        if(dostepnaIlosc == 0) return 0;
        if(dostepnaIlosc < ilosc) ilosc = dostepnaIlosc;
        double cena = wartosc*ilosc;
        cena += pobierzMarze(cena);
        if(inw.getBudzet() < cena) return 0;
        else {
            inw.zmniejszBudzet(cena);
            try {
                akcja.zmniejszDostepnaIlosc(ilosc);
            } catch (ZbytMalaIloscDostepnychAkcji ex) {
                return 0;
            }
            return ilosc;
        }
    }


    @Override
    public synchronized double sprzedajAktywaNaRynek(Aktywa aktywa, int ilosc) {
        Akcja akcja = (Akcja) aktywa;
        double cena = aktywa.getWartoscAktualna()*ilosc;
        if(!getListaAktywRynku().contains(aktywa)) {
            dodajDoListyAktywRynku(akcja);
        }
        akcja.zwiekszDostepnaIlosc(ilosc);
        return cena - pobierzMarze(cena);
    }

    @Override
    public synchronized int wykupAktywaZRynku(Aktywa aktywa) {
        Akcja akcja = (Akcja) aktywa;
        usunZListyAktywRynku(aktywa);
        return akcja.getDostepnaIlosc();
    }
}
