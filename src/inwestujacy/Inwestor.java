/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inwestujacy;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import projekt.Losowanie;
import projekt.Swiat;

/**
 *
 * @author Monika Zielińska
 */
public class Inwestor extends Inwestujacy {
    
    private String pesel;
    
    
    
    public Inwestor() {
        
        pesel = Losowanie.losujPesel();            
    }
   

    @Override
    public void run() {
        while(getIstnienieInwestujacego()) {
            while(Swiat.isDzialanieSymulacji()) {
                try {
                    sleep((long)(1000*Losowanie.losujDouble())); 
                } catch (InterruptedException ex) {
                    Logger.getLogger(Inwestor.class.getName()).log(Level.SEVERE, null, ex);
                }
                double opcja = Losowanie.losujDouble();
                    if (opcja < 0.2 && !getListaPosiadanychAktywow().isEmpty()) {
                        sprzedajAktywa();
                    }
                    else if ( opcja < 0.8 ) {
                        kupAktywa();
                    }
                    
                    else if (opcja < 0.9) {
                        zwiekszBudzet(Losowanie.losujInt(250));
                    }
            }
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Inwestor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public String getPesel() {
        return pesel;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return this.getImie()+" "+this.getNazwisko();
    }
    
    
}
