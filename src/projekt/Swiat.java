/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt;

import rynki.*;
import inwestujacy.*;
import aktywa.*;
import bledy.BrakSurowcaDoWylosowania;
import bledy.BrakWalutDoWylosowania;
import java.util.ArrayList;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.observablecollections.ObservableList;

/**
 *
 * @author Monika Zielińska
 */
public class Swiat {
    
    private static boolean dzialanieSymulacji;
    public static boolean wczytane;
    private static int czas = 0;
    public static ObservableList <Gielda> listaGield;
    public static RynekSurowcow rynekSurowcow;
    public static RynekWalut rynekWalut;
    public static ObservableList <Rynek> listaRynkow;
    public static ObservableList <Spolka> listaSpolek;
    public static ObservableList <Inwestor> listaInwestorow;
    public static ObservableList <Fundusz> listaFunduszy;
    public static ObservableList <Akcja> listaAkcji;
    public static ObservableList <Surowiec> listaSurowcow;
    public static ObservableList <Waluta> listaWalut;
    public static ObservableList <JednostkaUczestnictwa> listaJednostekUczestnictwa;
    public static ObservableList <Aktywa> listaAktywa;

    static{
            try {
            wczytane = false;
            listaRynkow = ObservableCollections.observableList(new ArrayList<>());
            rynekWalut = new RynekWalut();
            Swiat.listaRynkow.add(rynekWalut);
            rynekSurowcow = new RynekSurowcow();
            Swiat.listaRynkow.add(rynekSurowcow);
            listaGield = ObservableCollections.observableList(new ArrayList<>());
            listaSpolek = ObservableCollections.observableList(new ArrayList<>());
            listaInwestorow = ObservableCollections.observableList(new ArrayList<>());
            listaFunduszy = ObservableCollections.observableList(new ArrayList<>());
            listaAkcji = ObservableCollections.observableList(new ArrayList<>());
            listaSurowcow = ObservableCollections.observableList(new ArrayList<>());
            listaWalut = ObservableCollections.observableList(new ArrayList<>());
            listaJednostekUczestnictwa = ObservableCollections.observableList(new ArrayList<>());
            listaAktywa = ObservableCollections.observableList(new ArrayList<>());
            
        } catch (Exception e) {
                System.err.println("Błąd przy inicjalizacji świata");
        }
    }

    /**
     *
     * @return lista istniejących giełd
     */
    public static ObservableList<Gielda> getListaGield() {
        return listaGield;
    }

    /**
     *
     * @param listaGield  lista istniejących giełd
     */
    public static void setListaGield(ObservableList<Gielda> listaGield) {
        Swiat.listaGield = listaGield;
    }

    /**
     *
     * @return  rynek surowców
     */
    public static RynekSurowcow getRynekSurowcow() {
        return rynekSurowcow;
    }

    /**
     *
     * @param rynekSurowcow rynek surowców
     */
    public static void setRynekSurowcow(RynekSurowcow rynekSurowcow) {
        Swiat.rynekSurowcow = rynekSurowcow;
    }

    /**
     *
     * @return rynek walut
     */
    public static RynekWalut getRynekWalut() {
        return rynekWalut;
    }

    /**
     *
     * @param rynekWalut rynek walut
     */
    public static void setRynekWalut(RynekWalut rynekWalut) {
        Swiat.rynekWalut = rynekWalut;
    }

    /**
     *
     * @return lista wszystkich dostępnych rynków
     */
    public static ObservableList<Rynek> getListaRynkow() {
        return listaRynkow;
    }

    /**
     *
     * @param listaRynkow lista wszystkich dostępnych rynków
     */
    public static void setListaRynkow(ObservableList<Rynek> listaRynkow) {
        Swiat.listaRynkow = listaRynkow;
    }

    /**
     *
     * @return lista spółek
     */
    public static ObservableList<Spolka> getListaSpolek() {
        return listaSpolek;
    }

    /**
     *
     * @param listaSpolek lista spółek
     */
    public static void setListaSpolek(ObservableList<Spolka> listaSpolek) {
        Swiat.listaSpolek = listaSpolek;
    }

    /**
     *
     * @return lista inwestorow
     */
    public static ObservableList<Inwestor> getListaInwestorow() {
        return listaInwestorow;
    }

    /**
     *
     * @param listaInwestorow lista inwestorow
     */
    public static void setListaInwestorow(ObservableList<Inwestor> listaInwestorow) {
        Swiat.listaInwestorow = listaInwestorow;
    }

    /**
     *
     * @return lista funduszy
     */
    public static ObservableList<Fundusz> getListaFunduszy() {
        return listaFunduszy;
    }

    /**
     *
     * @param listaFunduszy lista funduszy
     */
    public static void setListaFunduszy(ObservableList<Fundusz> listaFunduszy) {
        Swiat.listaFunduszy = listaFunduszy;
    }

    /**
     *
     * @return lista akcji
     */
    public static ObservableList<Akcja> getListaAkcji() {
        return listaAkcji;
    }

    /**
     *
     * @param listaAkcji lista akcji
     */
    public static void setListaAkcji(ObservableList<Akcja> listaAkcji) {
        Swiat.listaAkcji = listaAkcji;
    }

    /**
     *
     * @return lista surowcow
     */
    public static ObservableList<Surowiec> getListaSurowcow() {
        return listaSurowcow;
    }

    /**
     *
     * @param listaSurowcow lista surowcow
     */
    public static void setListaSurowcow(ObservableList<Surowiec> listaSurowcow) {
        Swiat.listaSurowcow = listaSurowcow;
    }

    /**
     *
     * @return lista walut
     */
    public static ObservableList<Waluta> getListaWalut() {
        return listaWalut;
    }

    /**
     *
     * @param listaWalut lista walut
     */
    public static void setListaWalut(ObservableList<Waluta> listaWalut) {
        Swiat.listaWalut = listaWalut;
    }

    /**
     *
     * @return lista jednostek uczestnictwa w funduszach
     */
    public static ObservableList<JednostkaUczestnictwa> getListaJednostekUczestnictwa() {
        return listaJednostekUczestnictwa;
    }

    /**
     *
     * @param listaJednostekUczestnictwa lista jednostek uczestnictwa w funduszach
     */
    public static void setListaJednostekUczestnictwa(ObservableList<JednostkaUczestnictwa> listaJednostekUczestnictwa) {
        Swiat.listaJednostekUczestnictwa = listaJednostekUczestnictwa;
    }

    /**
     *
     * @return lista wszystkich aktyw
     */
    public static ObservableList<Aktywa> getListaAktywa() {
        return listaAktywa;
    }

    /**
     *
     * @param listaAktywa lista wszystkich aktyw
     */
    public static void setListaAktywa(ObservableList<Aktywa> listaAktywa) {
        Swiat.listaAktywa = listaAktywa;
    }

    
    

    /**
     * Metoda pozwalająca na aktualizację świata
     */
    public static void aktualizuj() {
        //setDzialanieSymulacji(false);
        listaAktywa.forEach(Aktywa::aktualizujWartosc);
        listaWalut.forEach(Waluta::aktualizujWartosc);
        double los;
        int iloscInwestujacych = listaInwestorow.size()+listaFunduszy.size();
        while(iloscInwestujacych < 2*listaAktywa.size()) {
            los = Losowanie.losujDouble();
            if(los < 0.98) stworzInwestor();
            else stworzFundusz();
            iloscInwestujacych++;
        }
        czas++;
        //setDzialanieSymulacji(true);
    }   
    
    /**
     *
     * @throws BrakWalutDoWylosowania
     */
    public static void stworzWaluta() throws BrakWalutDoWylosowania {
        Waluta w;
        if(listaWalut.isEmpty()) {
            w = new Waluta("USD");
            w.getListaKrajowWaluty().add("USA");
        }
        else {
                w = new Waluta();
        }
        listaWalut.add(w);
        listaAktywa.add(w);
        rynekWalut.dodajDoListyAktywRynku(w);
    }
    
    /**
     *
     * @throws BrakSurowcaDoWylosowania
     */
    public static void stworzSurowiec() throws BrakSurowcaDoWylosowania  {
            Surowiec s = new Surowiec();
            listaSurowcow.add(s);
            listaAktywa.add(s);
            rynekSurowcow.dodajDoListyAktywRynku(s);
    }
    
    /**
     *
     */
    public static void stworzGielda() {
        Gielda g = new Gielda();
        listaGield.add(g);
        listaRynkow.add(g);
    }
    
    /**
     *
     * @param gielda
     * @return indeks
     */
    public static Indeks stworzIndeks(Gielda gielda) {
        Indeks ind = new Indeks(gielda);
        gielda.getListaIndeksow().add(ind);
        return ind;
    }
    
    /**
     *
     */
    public static void stworzSpolka() {
        Spolka sp = new Spolka();
        listaSpolek.add(sp);
        Thread tSp = new Thread(sp);
        tSp.start();
        
    }
    
    /**
     *
     */
    public static void stworzInwestor() {
        Inwestor inw = new Inwestor();
        inw.start();
        listaInwestorow.add(inw);
    }
    
    /**
     *
     */
    public static void stworzFundusz() {
        Fundusz fund = new Fundusz();
        fund.start();
        listaFunduszy.add(fund);
    }

    /**
     *
     * @return
     */
    public static boolean isDzialanieSymulacji() {
        return dzialanieSymulacji;
    }

    /**
     *
     * @param dzialanieSymulacji
     */
    public static void setDzialanieSymulacji(boolean dzialanieSymulacji) {
        Swiat.dzialanieSymulacji = dzialanieSymulacji;
    }

    /**
     * 
     * @return obecny czas (numer przejścia pętli aktualizacji)
     */
    public static int getCzas() {
        return czas;
    }

    public static void setCzas(int czas) {
        Swiat.czas = czas;
    }

    public static boolean isWczytane() {
        return wczytane;
    }

    public static void setWczytane(boolean wczytane) {
        Swiat.wczytane = wczytane;
    }
    
    
    
    
  
    
}
