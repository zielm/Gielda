/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aktywa;

import projekt.Losowanie;
import inwestujacy.Inwestujacy;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import projekt.Swiat;
import rynki.Rynek;

/**
 *
 * @author Monika Zielińska
 */
public abstract class Aktywa implements Serializable {
    private String nazwa;
    private volatile double wartoscAktualna;
    private double wartoscMin;
    private double wartoscMax;
    private List <Double> listaWartosci = new ArrayList<>();
    private Rynek rynek;
    private int momentPowstania;

    /**
     * Konstruktor aktywa - ustawienie czasu powstania
     */
    public Aktywa() {
        momentPowstania = Swiat.getCzas();
        this.listaWartosci = new ArrayList<>();
    }
    
    /**
     *
     * @return klasa danego aktywa
     */
    public String getKlasa() {
        return getClass().getSimpleName();
    }    

    /**
     *
     * @param nazwa nowa nazwa aktywa
     */
    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }
    
    /**
     *
     * @return nazwa aktywa
     */
    public String getNazwa() {
        return nazwa;
    }
    
    /**
     *
     * @return rynek na którym znajduje się aktywo
     */
    public Rynek getRynek() {
        return rynek;
    }

    /**
     *
     * @param rynek rynek na który ma zostać wprowadzone aktywo
     */
    public void setRynek(Rynek rynek) {
        this.rynek = rynek;
    }
    
    /**
     * 
     * @return wartość aktualna aktywa
     */
    public synchronized double getWartoscAktualna() {
        return wartoscAktualna;
    }

    /**
     * Pierwsze ustawienie
     * @param wartoscAktualna ustawiana wartość
     */
    public synchronized void setWartoscPierwszyRaz(double wartoscAktualna) {
        wartoscAktualna = Losowanie.round(wartoscAktualna, 2);
        this.wartoscAktualna = wartoscAktualna;
        setWartoscMax(wartoscAktualna);            
        setWartoscMin(wartoscAktualna);
        listaWartosci.add(wartoscAktualna);
    }
    
    /**
     * Ustaw wartość aktualną
     * @param wartoscAktualna ustawiana wartość
     */
    public synchronized void setWartoscAktualna(double wartoscAktualna) {
        wartoscAktualna = Losowanie.round(wartoscAktualna, 2);
        this.wartoscAktualna = wartoscAktualna;
        if (wartoscAktualna > getWartoscMax()) {
            setWartoscMax(wartoscAktualna);            
        }
        
        if(wartoscAktualna < getWartoscMin()) {
            setWartoscMin(wartoscAktualna);
        }
    }
    
    /**
     *
     * @return minimalna zanotowana wartość aktywa
     */
    public double getWartoscMin() {
        return wartoscMin;
    }

    /**
     *
     * @param wartoscMin nowa wartość minimalna aktywa
     */
    public void setWartoscMin(double wartoscMin) {
        this.wartoscMin = wartoscMin;
    }

    /**
     *
     * @return maksymalna zanotowana wartość aktywa
     */
    public double getWartoscMax() {
        return wartoscMax;
    }

    /**
     *
     * @param wartoscMax nowa maksymalna wartość aktywa
     */
    public void setWartoscMax(double wartoscMax) {
        this.wartoscMax = wartoscMax;
    }

    /**
     *
     * @return historia wartości aktywa
     */
    public List<Double> getListaWartosci() {
        return listaWartosci;
    }

    /**
     *
     * @param listaWartosci historia wartości aktywa
     */
    public void setListaWartosci(List<Double> listaWartosci) {
        this.listaWartosci = listaWartosci;
    }

    /**
     *
     * @return
     */
    public int getMomentPowstania() {
        return momentPowstania;
    }

    /**
     *
     * @param momentPowstania
     */
    public void setMomentPowstania(int momentPowstania) {
        this.momentPowstania = momentPowstania;
    }
    
    
    
    
    
    /**
     * Aktualizowanie wartości aktywa - wartość zmienia się losowo
     */
    public synchronized void aktualizujWartosc(){
        double wartosc = Losowanie.zmienWartosc(wartoscAktualna);
        listaWartosci.add(wartoscAktualna);
        setWartoscAktualna(wartosc);
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
     * Metoda odpowiadająca za sprzedaż aktywów od inwestorów - przekazuje argumenty na rynek
     * @param ilosc liczba aktywów, które inwestor sprzedaje
     * @return otrzymana zapłata
     */
    public double sprzedaj(int ilosc) {
        return rynek.sprzedajAktywaNaRynek(this, ilosc);
    }
    
    /**
     * Metoda odpowiadająca za zakup aktywa z rynku - przekazuje argumenty na rynek
     * @param inw inwestor kupujący aktywo
     * @param ilosc ilość aktywa którą chce zakupić inwestujący
     * @return sukces(true) lub niepowodzenie(false) operacji kupna 
     */
    public int kup(Inwestujacy inw, int ilosc) {
        return rynek.kupAktywaZRynku(inw, this, ilosc);
    }
    
}
