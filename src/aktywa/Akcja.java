/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aktywa;

import bledy.ZbytMalaIloscDostepnychAkcji;
import projekt.Losowanie;
import projekt.Spolka;

/**
 *
 * @author Monika Zielińska
 */
public class Akcja extends Aktywa  {
    
    private final Spolka spolka;
    private int ilosc;
    private volatile int dostepnaIlosc;
    private volatile int zmianaWlasciciela;

    /**
     * Kontruktor spółki
     * @param spolka spółka do której należą akcje
     * @param ilosc ilość akcji
     */
    public Akcja(Spolka spolka, int ilosc) {
        super.setNazwa("akcje " + spolka.getNazwa());
        this.spolka = spolka;
        this.ilosc = ilosc;
        this.dostepnaIlosc = ilosc;
        super.setRynek(Losowanie.losujGielda());
    }


    /**
     *
     * @return spółka do której należą akcje
     */
    public Spolka getSpolka() {
        return spolka;
    }


    /**
     *
     * @return całkowita ilość akcji 
     */
    public int getIlosc() {
        return ilosc;
    }

    /**
     * 
     * @param ilosc całkowita ilość akcji
     */
    public void setIlosc(int ilosc) {
        this.ilosc = ilosc;
    }
    
    

    
    /**
     * Zwiększenie ilości akcji na giełdzie - spółka wypuściła nowe akcje
     * @param ilosc ilość nowo wypuszczonych akcji
     */
    public void zwiekszIlosc(int ilosc) {
        this.ilosc += ilosc;
        this.dostepnaIlosc += ilosc;
    }
    
    /**
     * Zmniejszenie ilości akcji na giełdzie - spółka wykupiła swoje akcje z giełdy
     * @param ilosc ilość akcji do wykupienia
     */
    public synchronized void zmniejszIlosc(int ilosc) {
        this.ilosc -= ilosc;
        this.dostepnaIlosc -= ilosc;
    }

    /**
     *
     * @return dostępna ilość akcji na giełdzie
     */
    public int getDostepnaIlosc() {
        return dostepnaIlosc;
    }
    
    /**
     * Zwiększenie dostępnej ilości akcji na giełdzie - inwestujący odsprzedał swoje akcje
     * @param ilosc o ile zwiekszamy
     */
    public synchronized void zwiekszDostepnaIlosc(int ilosc) {
        this.dostepnaIlosc += ilosc;
        this.zmianaWlasciciela += ilosc;
    }
    
    /**
     * Zmniejszenie dostępnej ilości akcji na giełdzie - inwestujący zakupił akcje
     * @param ilosc ilość akcji do wykupienia
     * @throws bledy.ZbytMalaIloscDostepnychAkcji
     */
    public synchronized void zmniejszDostepnaIlosc(int ilosc) throws ZbytMalaIloscDostepnychAkcji {
        if(this.dostepnaIlosc < ilosc) throw new ZbytMalaIloscDostepnychAkcji();
        this.dostepnaIlosc -= ilosc;
        this.zmianaWlasciciela += ilosc;
    }
    
    
    /**
     * Aktualizacja wartości akcji opiera się na ilości wolumenów czyli liczby akcji, które zmieniły właściciela.
     * Przyjmujemy, że wolumen rosnący oznacza siłę trendu, a więc cena akcji w takim przypadku rośnie.
     */
    @Override
    public synchronized void aktualizujWartosc() {
        int staryWolumen = spolka.getWolumen();
        int nowyWolumen = this.zmianaWlasciciela;
        this.zmianaWlasciciela = 0;
        spolka.setWolumen(nowyWolumen);
        spolka.setObroty(nowyWolumen*getWartoscAktualna());
        
        if(nowyWolumen == 0) {
            spolka.setPrzychod((Losowanie.losujDouble()-0.3)*spolka.getPrzychod());
            spolka.setZysk((Losowanie.losujDouble()*-0.3)*spolka.getPrzychod());
        }
        else {
            spolka.setPrzychod(Losowanie.losujDouble()*spolka.getObroty());
            spolka.setZysk(Losowanie.losujDouble()*spolka.getObroty());
        }

        int roznica = nowyWolumen - staryWolumen;
        
        double wartosc;
        if( roznica == 0 ) {
            wartosc = Losowanie.zmienWartosc(getWartoscAktualna()); 
        }
        else {
            wartosc = (1 + (Losowanie.losujDouble()*(double)roznica)/10000)*getWartoscAktualna();
        }
        getListaWartosci().add(wartosc);
        setWartoscAktualna(wartosc);       
    }
    
    


    
    
}
