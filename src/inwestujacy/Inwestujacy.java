/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inwestujacy;

import aktywa.Akcja;
import aktywa.Aktywa;
import aktywa.JednostkaUczestnictwa;
import aktywa.Surowiec;
import java.util.ArrayList;
import java.util.List;
import projekt.Losowanie;
import inne.ParaAktywa;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.observablecollections.ObservableList;
import projekt.Swiat;

/**
 * Abstrakcyjna klasa Inwestujący
 * @author Monika Zielińska
 */
public abstract class Inwestujacy implements Runnable, Serializable {
    
    private String imie;
    private String nazwisko;
    private boolean istnienieInwestujacego;
    transient private ObservableList <ParaAktywa> listaPosiadanychAktywow;
    private double budzet;

    /**
     *
     */
    public Inwestujacy() {
        this.imie = Losowanie.losujImie();
        this.nazwisko = Losowanie.losujNazwisko();
        this.listaPosiadanychAktywow = ObservableCollections.observableList(new ArrayList<>());
        this.budzet = Losowanie.losujInt(20000)+1000;
    }
    
    /**
     * Metoda usuwająca inwestującego
     */
    public void usunInwestujacy() {
        stop();
        sprzedajWszystkieAktywa();
        if(this.getClass() == Inwestor.class) {
            Swiat.listaInwestorow.remove((Inwestor)this);
        }
        else {
            Swiat.listaFunduszy.remove((Fundusz)this);
        }
    }
    
    /**
     * Metoda odpowiadająca za kupowanie losowego aktywa
     */
    public void kupAktywa() {
        if(getBudzet() == 0) return;
        if(Swiat.listaAktywa.isEmpty()) return;
        int opcja = Losowanie.losujInt(Swiat.listaAktywa.size()-1)+1; //nie może kupić USD
        Aktywa aktywo = Swiat.listaAktywa.get(opcja); 
        if((aktywo.getClass() == JednostkaUczestnictwa.class) && (this.getClass() == Fundusz.class)) return;
        
        int maxIlosc = (int) (getBudzet()/aktywo.getWartoscAktualna());
        if(maxIlosc < 1) return;
        int ilosc = Losowanie.losujInt(maxIlosc) + 1;
        ilosc = aktywo.kup(this, ilosc);
        
        if (ilosc == 0) return;
        boolean dodane = false;
        for (ParaAktywa para : listaPosiadanychAktywow) {
            if(para.getAktywa() == aktywo) {
                para.zwiekszIlosc(ilosc);
                dodane = true;
            }
        }
        if(dodane == false) {
            listaPosiadanychAktywow.add(new ParaAktywa(aktywo, ilosc));
            if(aktywo.getClass() == Akcja.class) {
                Akcja akcja = (Akcja) aktywo;
                akcja.getSpolka().dodajAkcjonariusza(this);
            }
            else if(aktywo.getClass() == Surowiec.class) {
                Surowiec surowiec = (Surowiec) aktywo;
                surowiec.getListaPosiadaczySurowca().add(this);
            }
        }
    }
    
    /**
     *
     */
    public void sprzedajAktywa() {
        if(listaPosiadanychAktywow.isEmpty()) return;
        int ktoreAktywo = Losowanie.losujInt(listaPosiadanychAktywow.size());
        ParaAktywa paraAktywa = listaPosiadanychAktywow.get(ktoreAktywo);
        int ile = Losowanie.losujInt(paraAktywa.getIlosc()) + 1;
        double cena = paraAktywa.getAktywa().sprzedaj(ile);
        zwiekszBudzet(cena);
        
        paraAktywa.zmniejszIlosc(ile);
        if(paraAktywa.getIlosc() == 0) {
            listaPosiadanychAktywow.remove(paraAktywa);
            if(Akcja.class == paraAktywa.getAktywa().getClass()) {
                Akcja akcja = (Akcja) paraAktywa.getAktywa();
                akcja.getSpolka().usunAkcjonariusza(this);
            }
            else if(Surowiec.class == paraAktywa.getAktywa().getClass()) {
                Surowiec surowiec = (Surowiec) paraAktywa.getAktywa();
                surowiec.usunZListyPosiadaczySurowca(this);
            }
        }
    }
    
    /**
     *
     */
    public void sprzedajWszystkieAktywa() {
        while(!listaPosiadanychAktywow.isEmpty()) {
            ParaAktywa pa = listaPosiadanychAktywow.get(0);
            pa.getAktywa().sprzedaj(pa.getIlosc());
            listaPosiadanychAktywow.remove(pa);
        }
    }

    /**
     *
     * @return
     */
    public String getImie() {
        return imie;
    }

    /**
     *
     * @param imie
     */
    public void setImie(String imie) {
        this.imie = imie;
    }
    
    /**
     *
     * @return
     */
    public String getNazwisko() {
        return nazwisko;
    }

    /**
     *
     * @param nazwisko
     */
    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    /**
     *
     * @return
     */
    public List<ParaAktywa> getListaPosiadanychAktywow() {
        return listaPosiadanychAktywow;
    }
    
    /**
     * Usuwanie z listy aktywów bez zapłaty - aktywo stało się bezwartościowe, więc inwestujący nie otrzymuje pieniędzy, wywoływane przy usuwaniu spółki, funduszu lub surowca
     * @param aktywa usuwane aktywo
     */
    public void usunAktywoZPosiadanych(Aktywa aktywa) {
        for (ParaAktywa paraAktywa : listaPosiadanychAktywow) { 
            if(paraAktywa.getAktywa() == aktywa) {
                listaPosiadanychAktywow.remove(paraAktywa);
                return;
            }            
        }
    }

    /**
     *
     * @return
     */
    public double getBudzet() {
        return budzet;
    }
    
    /**
     *
     * @param ile
     */
    public void zwiekszBudzet(double ile) {
        budzet += ile;
        budzet = Losowanie.round(budzet, 2);
    }
    
    /**
     *
     * @param ile
     */
    public void zmniejszBudzet(double ile) {
        budzet -= ile;
        budzet = Losowanie.round(budzet, 2);
    }
    
    /**
     *
     * @param budzet
     */
    public void setBudzet(double budzet) {
        this.budzet = Losowanie.round(budzet, 2);
    }

    /**
     *
     * @return
     */
    public boolean getIstnienieInwestujacego() {
        return istnienieInwestujacego;
    }

    /**
     *
     */
    public void stop() {
         istnienieInwestujacego = false;
    }
    
    /**
     *
     */
    public void start() {
        istnienieInwestujacego = true;
        Thread watek = new Thread(this);
        watek.start();
    }

    /**
     *
     */
    @Override
    public abstract void run();
    
     //Serializacja 
    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();
        oos.writeObject(new ArrayList<>(listaPosiadanychAktywow));
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();
        listaPosiadanychAktywow = ObservableCollections.observableList((List<ParaAktywa>) ois.readObject());
    }
    
    
    
    
    
    


    
}
