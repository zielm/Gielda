/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt;

import rynki.Gielda;
import aktywa.Akcja;
import inwestujacy.Inwestujacy;
import java.io.Serializable;
import static java.lang.Thread.sleep;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class Spolka implements Runnable, Serializable {
    
    private String nazwa;
    private Date dataWyceny;        //co z data?
    private double kursOtwarcia;
    private Akcja akcjeSpolki;
    private volatile List <Inwestujacy> listaAkcjonariuszy;
    private double zysk;
    private double przychod;
    private double kapitalWlasny;
    private double kapitalZakladowy;
    private int wolumen;
    private double obroty;
    private boolean istnienieSpolki;

    /**
     *
     */
    public Spolka(){
        nazwa = Losowanie.losujNazwe();
        dataWyceny = new Date();
        kursOtwarcia = Losowanie.round(Losowanie.losujDouble()*100,2)+10;
        zysk = 0;
        przychod = 0;
        akcjeSpolki = new Akcja(this, 0);
        akcjeSpolki.setWartoscPierwszyRaz(kursOtwarcia);
        listaAkcjonariuszy = new ArrayList<>();
        Swiat.listaAkcji.add(akcjeSpolki);
        Swiat.listaAktywa.add(akcjeSpolki);
        kapitalWlasny = Losowanie.losujInt(99000)+1000;
        kapitalZakladowy = Losowanie.losujInt(99000)+1000;
        wolumen = 0;
        obroty = 0;
        zysk = 0;
        przychod = 0;
        wypuscAkcje();
    }
    
    /**
     * Metoda pozwalająca na usunięcie spółki bez wypłacania pieniędzy posiadaczom jej akcji
     */
    public void usun() {
        stop();
        Swiat.listaSpolek.remove(this);
        Swiat.listaAkcji.remove(akcjeSpolki);
        Swiat.listaAktywa.remove(akcjeSpolki);
        wykupAkcje();
        while(!listaAkcjonariuszy.isEmpty()) {
            Inwestujacy inw = listaAkcjonariuszy.get(0);
            inw.usunAktywoZPosiadanych(akcjeSpolki);
            listaAkcjonariuszy.remove(inw);
        }
        akcjeSpolki = null;
    }
    

    /**
     * Funkcja pozwala spółce na wypuszczenie losowej liczby nowych akcji na giełdę.
     */
    public void wypuscAkcje() {
        int ileAkcji = Losowanie.losujInt(5000)+1000;
        Gielda g = (Gielda) akcjeSpolki.getRynek();
        g.dodajAkcjeNaGielde(akcjeSpolki, ileAkcji);
    }
    
    /**
     * Metoda pozwala spółce na wykupienie akcji dostępnych na rynkach.
     */
    public void wykupAkcje() {
       int ile = akcjeSpolki.getRynek().wykupAktywaZRynku(akcjeSpolki);
       akcjeSpolki.zmniejszIlosc(ile);
    }
    
    /**
     *
     */
    @Override
    public void run() {
        Thread thisThread = Thread.currentThread();
        while(istnienieSpolki) {
            while(Swiat.isDzialanieSymulacji()) {
                try {
                    sleep((long)(1000*Losowanie.losujDouble()));
                } catch (InterruptedException ex) {
                    Logger.getLogger(Spolka.class.getName()).log(Level.SEVERE, null, ex);
                } 
                double opcja = Losowanie.losujDouble();
                    if(opcja < 0.3){
                        wypuscAkcje();
                    }
            }
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Spolka.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }    

    /**
     *
     * @return nazwa spółki
     */
    public String getNazwa() {
        return nazwa;
    }

    /**
     *
     * @param nazwa nazwa spółki
     */
    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    /**
     *
     * @return data wyceny
     */
    public String getDataWyceny() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        return dateFormat.format(dataWyceny);
    }

    /**
     *
     * @param dataWyceny data wyceny
     */
    public void setDataWyceny(Date dataWyceny) {
        this.dataWyceny = dataWyceny;
    }

    /**
     *
     * @return kurs otwarcia
     */
    public double getKursOtwarcia() {
        return kursOtwarcia;
    }

    /**
     *
     * @param kursOtwarcia kurs otwarcia
     */
    public void setKursOtwarcia(double kursOtwarcia) {
        this.kursOtwarcia = kursOtwarcia;
    }

    /**
     *
     * @return akcje spolki
     */
    public Akcja getAkcjeSpolki() {
        return akcjeSpolki;
    }

    /**
     *
     * @param akcjeSpolki akcje spolki
     */
    public void setAkcjeSpolki(Akcja akcjeSpolki) {
        this.akcjeSpolki = akcjeSpolki;
    }

    /**
     *
     * @return
     */
    public double getZysk() {
        return zysk;
    }

    /**
     *
     * @param zysk
     */
    public void setZysk(double zysk) {
        this.zysk = Losowanie.round(zysk,2);
    }

    /**
     *
     * @return
     */
    public double getPrzychod() {
        return przychod;
    }

    /**
     *
     * @param przychod
     */
    public void setPrzychod(double przychod) {
        this.przychod = Losowanie.round(przychod,2);
    }

    /**
     *
     * @return
     */
    public double getKapitalWlasny() {
        return kapitalWlasny;
    }

    /**
     *
     * @param kapitalWlasny
     */
    public void setKapitalWlasny(double kapitalWlasny) {
        this.kapitalWlasny = kapitalWlasny;
    }

    /**
     *
     * @return
     */
    public double getKapitalZakladowy() {
        return kapitalZakladowy;
    }

    /**
     *
     * @param kapitalZakladowy
     */
    public void setKapitalZakladowy(double kapitalZakladowy) {
        this.kapitalZakladowy = kapitalZakladowy;
    }

    /**
     *
     * @return
     */
    public int getWolumen() {
        return wolumen;
    }

    /**
     *
     * @param wolumen
     */
    public void setWolumen(int wolumen) {
        this.wolumen = wolumen;
    }

    /**
     *
     * @return
     */
    public double getObroty() {
        return obroty;
    }

    /**
     *
     * @param obroty
     */
    public void setObroty(double obroty) {
        this.obroty = Losowanie.round(obroty,2);
    }

    /**
     *
     * @return
     */
    public List<Inwestujacy> getListaAkcjonariuszy() {
        return listaAkcjonariuszy;
    }

    /**
     *
     * @param listaAkcjonariuszy
     */
    public void setListaAkcjonariuszy(List<Inwestujacy> listaAkcjonariuszy) {
        this.listaAkcjonariuszy = listaAkcjonariuszy;
    }
    
    /**
     *
     * @param inwestujacy
     */
    public synchronized void dodajAkcjonariusza(Inwestujacy inwestujacy) {
        listaAkcjonariuszy.add(inwestujacy);
    }
    
    /**
     *
     * @param inwestujacy
     */
    public synchronized void usunAkcjonariusza(Inwestujacy inwestujacy) {
        listaAkcjonariuszy.remove(inwestujacy);
    }
    
    /**
     * Metoda pozwalająca na start wątku spółki
     */
    public void start() {
        istnienieSpolki = true;
        Thread watek = new Thread(this);
        watek.start();        
    }
    
    /**
     * Metoda usuwająca wątek spółki
     */
    public void stop() {
        istnienieSpolki = false;        
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return nazwa;
    }
    
    

}
