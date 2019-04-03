/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt;

import aktywa.Akcja;
import aktywa.Aktywa;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import rynki.Gielda;

/**
 * Klasa indeksu. Możliwe są 4 rodzaje indeksu: 
 * bIA - posiadające największą liczbę akcji na giełdzie
 * sIA - posiadające najmniejszą liczbę akcji na giełdzie
 * bLW - posiadające najwyższą liczbę wolumenów
 * sLW - posiadające najmniejszą liczbę wolumenów
 * @author Monika Zielińska
 */
public class Indeks implements Serializable{
    
    private String nazwaIndeksu;
    private int ilosc;
    private int rodzaj;
    private Gielda gielda;
    private double wartoscIndeksu;
    private List <Akcja> listaAkcji;

    /**
     *
     * @param gielda giełda do której należeć będzie indeks
     */
    public Indeks(Gielda gielda) {
        this.gielda = gielda;
        rodzaj = Losowanie.losujInt(4);
        ilosc = (Losowanie.losujInt(25)+1);
    
        switch(rodzaj) {
            case 0:
                nazwaIndeksu = "bIA" + ilosc;   //najwieksza ilosc akcji
                break;
            case 1:
                nazwaIndeksu = "sIA" + ilosc;   //najmniejsza ilosc akcji
                break;
            case 2:
                nazwaIndeksu = "bLW" + ilosc;   //najwieksza liczba wolumenow
                break;
            case 3:
                nazwaIndeksu = "sLW" + ilosc;   //najmniejsza liczba wolumenow
                break;
        }    
        aktualizujIndeks();
    }

    /**
     *
     * @return wartosc indeksu
     */
    public double getWartoscIndeksu() {
        return wartoscIndeksu;
    }

    /**
     *
     * @param wartoscIndeksu wartosc indeksu
     */
    public void setWartoscIndeksu(int wartoscIndeksu) {
        this.wartoscIndeksu = wartoscIndeksu;
    }

    /**
     *
     * @return nazwa indeksu
     */
    public String getNazwaIndeksu() {
        return nazwaIndeksu;
    }

    /**
     * Indeks składają się z określonej ilości spółek
     * @return ilosc spółek należących (mogących należeć) do indeksu
     */
    public int getIlosc() {
        return ilosc;
    }

    /**
     * W tej symulacji giełdy znajdują się 4 możliwe indeksy:
     * rodzaj 0: składa się ze spółek, które posiadają największą ilość akcji
     * rodzaj 1: składa się ze spółek, które posiadają najmniejszą ilość akcji
     * rodzaj 2: składa się ze spółek, które w danym momencie notują największą liczbę wolumenów
     * rodzaj 3: składa się ze spółek, które w danym momencie notują najmniejszą ilość wolumenów
     * @return cyfra od 0 do 3, która symbolizuje jeden z możliwych typów indeksu
     */
    public int getRodzaj() {
        return rodzaj;
    }

    /**
     *
     * @return gielda do której nalezy indeks
     */
    public Gielda getGielda() {
        return gielda;
    }

    /**
     *
     * @return lista spółek akcji należąca do indeksu (w znaczeniu spółek)
     */
    public List<Akcja> getListaAkcji() {
        return listaAkcji;
    }
   
    
    /**
     *
     */
    public void aktualizujIndeks() {
        listaAkcji = new ArrayList<>();
        for (Aktywa aktywa : gielda.getListaAktywRynku()) {
            Akcja a = (Akcja) aktywa;
            listaAkcji.add(a);
        }
        
        switch(rodzaj) {
            case 0:
                Collections.sort(listaAkcji, new KomparatorNajwieksze());
                break;
            case 1:
                Collections.sort(listaAkcji, new KomparatorNajmniejsze());
                break;
            case 2:
                Collections.sort(listaAkcji, new KomparatorWolumenNajwiekszy());
                break;
            case 3:
                Collections.sort(listaAkcji, new KomparatorWolumenNajmniejszy());
                break;
        }
        
        double wartosc = 0;
        List <Akcja> listaAkcji2 = new ArrayList<>();
        int ile = Math.min(ilosc, listaAkcji.size());
        for (int i = 0; i < ile; i++) {
            Akcja akcja = listaAkcji.get(i);
            listaAkcji2.add(akcja);
            wartosc += akcja.getSpolka().getObroty();  
        }
        
        this.listaAkcji = listaAkcji2;
        this.wartoscIndeksu = Losowanie.round(wartosc, 2);
        
    }
    
    private class KomparatorNajwieksze implements Comparator<Akcja> {
        @Override
        public int compare(Akcja a1, Akcja a2) {
            return  a2.getIlosc() - a1.getIlosc();
        }
    }
    
    private class KomparatorNajmniejsze implements Comparator<Akcja> {
        @Override
        public int compare(Akcja a1, Akcja a2) {
            return  a1.getIlosc() - a2.getIlosc();
        }
    }
    
    private class KomparatorWolumenNajwiekszy implements Comparator<Akcja> {
        @Override
        public int compare(Akcja a1, Akcja a2) {
            return  a2.getSpolka().getWolumen() - a1.getSpolka().getWolumen();
        }
    }
    
    private class KomparatorWolumenNajmniejszy implements Comparator<Akcja> {
        @Override
        public int compare(Akcja a1, Akcja a2) {
            return  a1.getDostepnaIlosc() - a2.getDostepnaIlosc();
        }
    }
}
