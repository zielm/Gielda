/*
 * To change this license header, choose License Headers scanner Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template scanner the editor.
 */
package dane;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * Klasa do odczytywania danych z pliku
 * @author Monika Zielińska
 */
public class OdczytZPliku {
    
    /**
     * 
     * @param nazwaPliku nazwu pliku z którego czytane są wartości
     * @return lista odczytanych linii
     */
    public static List<String> odczytajZPliku(String nazwaPliku) {
        Charset ch = Charset.forName("UTF-8");
        nazwaPliku = "src/pliki/"+nazwaPliku;
        BufferedReader reader;
        List <String> lista = new ArrayList<>();
        try {
            reader = new BufferedReader(new InputStreamReader(
            new FileInputStream(nazwaPliku),ch));
            String s;
            while( (s = reader.readLine()) != null) {
                lista.add(s);
            }
            reader.close();  
        }   catch (IOException ex) {
                System.err.println("Błąd przy wczytywaniu pliku " + nazwaPliku);
            }
        return lista;
    }
}
