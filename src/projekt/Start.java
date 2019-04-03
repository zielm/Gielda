/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt;

import gui.OknoGlowne;
import inwestujacy.Fundusz;
import inwestujacy.Inwestor;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Monika Zielińska
 */
public class Start {
    
    private static OknoGlowne oknoGlowne;
    
    /**
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        
        try {
            Swiat.setDzialanieSymulacji(false);
            oknoGlowne = new OknoGlowne();
            oknoGlowne.setVisible(true);
            while (true) {
                while(Swiat.isDzialanieSymulacji()) {
                    Swiat.aktualizuj();
                    oknoGlowne.repaint();
                    Thread.sleep(4000);
                }
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            System.err.println("Coś poszło nie tak");
        }
        
	}
    
    /**
     * Zapisanie serializacji
     * @throws IOException
     */
    public static void zapisz() throws IOException {
        Serializacja dane = new Serializacja();
        BufferedOutputStream fileOut = new BufferedOutputStream(new FileOutputStream("zapis"));
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(dane);
        out.close();
        
        System.out.println("Zapisanie zakończone sukcesem");
    }

    /**
     * Wczytanie serializacji
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void wczytaj() throws IOException, ClassNotFoundException {
        for (Inwestor inwestor : Swiat.getListaInwestorow()) {
            inwestor.stop();
        }
        for(Fundusz fundusz : Swiat.getListaFunduszy()) {
            fundusz.stop();
        }
        for (Spolka spolka : Swiat.getListaSpolek()) {
            spolka.stop();
        }
        ObjectInputStream in = new ObjectInputStream(
                    new BufferedInputStream(new FileInputStream("zapis")));
        Serializacja odczyt = (Serializacja) in.readObject();
        odczyt.zapiszDane();
        oknoGlowne.dispose();
        oknoGlowne = new OknoGlowne();
        oknoGlowne.setVisible(true);
        oknoGlowne.panelStart.zmienKarteButton.doClick();

        for (Inwestor inwestor : Swiat.getListaInwestorow()) {
            inwestor.start();
        }
        
        for (Fundusz fundusz : Swiat.getListaFunduszy()) {
            fundusz.start();
        }
        
        for (Spolka spolka : Swiat.getListaSpolek()) {
            spolka.start();
        }
    }

}


