/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aktywa;

import bledy.BrakWalutDoWylosowania;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import projekt.Losowanie;
import java.util.ArrayList;
import java.util.List;
import projekt.Swiat;

/**
 *
 * @author Monika Zielińska
 */
public class Waluta extends Aktywa{
    
    private Set <String> listaKrajowWaluty;  //lista krajow obslugujaca dana walute
    private List <Kurs> kursWaluty;

    /**
     * Konstruktor waluty
     * @throws BrakWalutDoWylosowania
     */
    public Waluta() throws BrakWalutDoWylosowania {
        super.setNazwa(Losowanie.losujNowaWalute());
        super.setRynek(Swiat.rynekWalut);
        this.listaKrajowWaluty = new TreeSet<>();
        losujKraje();
        this.kursWaluty = new ArrayList<>();
        dodajKurs();
    }
    
    /**
     * Konstruktor waluty z nazwą
     * @param nazwa nazwa tworzonej waluty
     */
    public Waluta(String nazwa) {
        super.setNazwa(nazwa);
        super.setRynek(Swiat.rynekWalut);
        this.listaKrajowWaluty = new TreeSet<>();
        losujKraje();
        this.kursWaluty = new ArrayList<>();
        dodajKurs();
    }
    
    /**
     * Losowanie krajów do listy krajów, gdzie jest używana jako oficjalny środek płatniczy
     */
    private void losujKraje() {
        Random r = new Random();
        int n = r.nextInt(6)+1;
        for (int i = 0; i < n; i++) {
            this.listaKrajowWaluty.add(Losowanie.losujKraj());
        }
    }
    
    /**
     *
     * @return lista krajów, gdzie waluta jest używana jako oficjalny środek płatniczy
     */
    public Set<String> getListaKrajowWaluty() {
        return listaKrajowWaluty;
    }

    /**
     *
     * @return lista cen sprzedaży na inne waluty 
     */
    public List<Kurs> getKursWaluty() {
        return kursWaluty;
    }  
    
    /**
     * Dodanie nowego kursu waluty (w systemie pojawiła się nowa waluta, którą trzeba połączyć z pozostałymi)
     */
    public void dodajKurs() {
        for (Waluta waluta : Swiat.listaWalut) {
            waluta.getKursWaluty().add(new Kurs(this));
            this.kursWaluty.add(new Kurs(waluta));
        }
        Kurs kursNaSiebie = new Kurs(this, 0);
        this.kursWaluty.add(kursNaSiebie);
        setWartoscPierwszyRaz(this.kursWaluty.get(0).getCenaKupna());
        
    }

    @Override
    public synchronized void aktualizujWartosc() {
        for (Kurs kurs : kursWaluty) {
            double nowyKurs = Losowanie.zmienWartosc(kurs.getCenaKupna());
            kurs.setCenaKupna(nowyKurs);
        }
        double wartosc = kursWaluty.get(0).getCenaKupna();
        getListaWartosci().add(wartosc);
        setWartoscAktualna(wartosc);
        
    }

    
    
     
   
    
    
    
    
}
