/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rynki;

import aktywa.Aktywa;
import projekt.Losowanie;
import inwestujacy.Inwestujacy;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.jdesktop.observablecollections.ObservableCollections;

/**
 *
 * @author Monika Zielińska
 */
public abstract class Rynek implements Serializable {
    
    private String nazwa;
    private double marza;
    transient private volatile List <Aktywa> listaAktywRynku;
    
    /**
     *
     */
    public Rynek() {
        this.nazwa = "Rynek" + Losowanie.losujNazwe();
        this.marza = Losowanie.round(Losowanie.losujDouble(),2);
        listaAktywRynku = new ArrayList<>();
    }

    /**
     *
     * @return
     */
    public String getNazwa() {
        return nazwa;
    }

    /**
     *
     * @param nazwa
     */
    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    /**
     *
     * @return
     */
    public double getMarza() {
        return marza;
    }

    /**
     *
     * @param marza
     */
    public void setMarza(double marza) {
        this.marza = marza;
    }

    /**
     *
     * @return
     */
    public List<Aktywa> getListaAktywRynku() {
        return listaAktywRynku;
    }

    /**
     *
     * @param listaAktywRynku
     */
    public synchronized void setListaAktywRynku(List<Aktywa> listaAktywRynku) {
        this.listaAktywRynku = listaAktywRynku;
    }
    
    /**
     *
     * @param a
     */
    public synchronized void dodajDoListyAktywRynku(Aktywa a) {
        listaAktywRynku.add(a);
    }
    
    /**
     *
     * @param a
     */
    public synchronized void usunZListyAktywRynku(Aktywa a) {
        listaAktywRynku.remove(a);
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return nazwa;
    }
        
    /**
     * Metoda obsługująca sprzedaż aktywa na rynek (cena sprzedaży aktyw to kurs bieżący*ilość - marża)
     * @param aktywa sprzedawane aktywo
     * @param ilosc ilość sprzedawanego aktywa
     * @return cena jaką inwestujący otrzymuje za sprzedaż aktywa
     */
    public double sprzedajAktywaNaRynek(Aktywa aktywa, int ilosc) {
        double cena = aktywa.getWartoscAktualna()*ilosc;
        cena -= pobierzMarze(cena);
        return Losowanie.round(cena,2);
    }
    
    /**
     * Metoda obsługująca kupno aktywa z rynku (cena kupna aktyw to kurs bieżący*ilość + marża)
     * @param inw inwestor kupujący aktywo
     * @param aktywo kupowane aktywo
     * @param ilosc ilość aktywa którą chce zakupić inwestujący
     * @return sukces(true) lub niepowodzenie(false) operacji kupna 
     */
    public int kupAktywaZRynku(Inwestujacy inw, Aktywa aktywo, int ilosc) { 
       double cena = aktywo.getWartoscAktualna()*ilosc;
       cena += pobierzMarze(cena);
       if(inw.getBudzet() < cena) return 0;
       else {
           inw.zmniejszBudzet(cena);
           return ilosc;
       }
    }
    
    /**
     * Metoda wykorzystywana do całkowitego wykupywania aktywa z rynku (inwestorzy i fundusze nadal je posiadają).
     * @param aktywa aktywo które wykupujemy całkowicie z rynku
     * @return ilość wykupionych aktyw z rynku
     */
    public synchronized int wykupAktywaZRynku(Aktywa aktywa) {
        usunZListyAktywRynku(aktywa);
        return 0;
    }
    
    /**
     * Metoda wyliczająca marżę, którą rynek pobierze od operacji kupna-sprzedaży
     * @param cena koszt zakupu aktyw z rynku / cena sprzedaży aktyw na rynek
     * @return
     */
    public double pobierzMarze(double cena) {
        return cena*(marza/100);
    }
    
        private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();
        oos.writeObject((new ArrayList<>(listaAktywRynku)));
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();
        listaAktywRynku = ObservableCollections.observableList((List<Aktywa>) ois.readObject());
    }
    
}
