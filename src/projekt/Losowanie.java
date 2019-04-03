/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt;

import aktywa.Surowiec;
import bledy.*;
import rynki.Gielda;
import aktywa.Waluta;
import dane.OdczytZPliku;
import inne.ParaString;
import inwestujacy.Fundusz;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import projekt.Swiat;

/**
 *
 * @author Monika Zielińska
 */
public class Losowanie {
    
    private static List <String> imiona;
    private static List <String> nazwiska;
    private static List <String> kraje;
    private static List <String> waluty;
    private static List <ParaString> surowce;
    private static List <String> miasta;
    private static List <String> adresy;
    private static List <String> nazwy;
    private static List <ParaString> gieldy;


    static {
        imiona = OdczytZPliku.odczytajZPliku("imiona.txt");
        nazwiska = OdczytZPliku.odczytajZPliku("nazwiska.txt");
        kraje = OdczytZPliku.odczytajZPliku("kraje.txt");        
        waluty = OdczytZPliku.odczytajZPliku("waluty.txt");
        miasta = OdczytZPliku.odczytajZPliku("miasta.txt");
        adresy = OdczytZPliku.odczytajZPliku("adresy.txt");
        nazwy = OdczytZPliku.odczytajZPliku("nazwy.txt");
       
        surowce = new ArrayList<>();
        List <String> infoSurowiec = OdczytZPliku.odczytajZPliku("surowce.txt");
        infoSurowiec.stream().map((para) -> para.split(";")).forEachOrdered((String[] czesc) -> {
            surowce.add(new ParaString(czesc[0], czesc[1]));
        });

        gieldy = new ArrayList<>();
        List <String> infoGieldy = OdczytZPliku.odczytajZPliku("gieldy.txt");
        infoGieldy.stream().map((para) -> para.split(" - ")).forEachOrdered((String[] czesc) -> {
            gieldy.add(new ParaString(czesc[0], czesc[1]));
        });
        
    }
    
    /**
     * losowanie wartosci int z podanego przedzialu
     * @param przedzial przedział do losowania
     * @return wylosowany int
     */
    public static int losujInt(int przedzial) {
        Random r = new Random();
        return r.nextInt(przedzial);
    }
    
    /**
     * losowanie wartości double (0,1)
     * @return wylosowany double
     */
    public static double losujDouble() {
        Random r = new Random();
        return r.nextDouble();
    }
    
    /**
     * tworzenie peselu
     * @return wylosowany pesel
     */
    public static String losujPesel(){
        String pesel;
        pesel = "";
        Random r = new Random();
        int a = r.nextInt(69)+31;
        pesel += Integer.toString(a);
        a = r.nextInt(12)+1;
        if(a<10) pesel += "0"; 
        pesel += Integer.toString(a);
        a = r.nextInt(27)+1;
        if(a<10) pesel += "0"; 
        pesel += Integer.toString(a);
        for (int i = 0; i < 5; i++) {
            a = r.nextInt(10);
            pesel += Integer.toString(a); 
        }
        return pesel;
    }
   
    /**
     * losowanie imienia
     * @return wylosowane imie
     */
    public static String losujImie(){
        Random r = new Random();
        int a = r.nextInt(imiona.size());
        return imiona.get(a);
    }
    
    /**
     * losowanie nazwiska
     * @return wylosowane nazwisko
     */
    public static String losujNazwisko() {
        Random r = new Random();
        int a = r.nextInt(nazwiska.size());
        return nazwiska.get(a);
    }
    
    /**
     * losowanie kraju
     * @return wylosowany kraj
     */
    public static String losujKraj() {
        Random r = new Random();
        int a = r.nextInt(kraje.size());
        return kraje.get(a);
    }
      
    /**
     * losowanie nazwy waluty z dostepnej puli
     * @return wylosowana waluta
     * @throws BrakWalutDoWylosowania skończyły się przygotowane waluty
     */
    @SuppressWarnings("empty-statement")
    public static String losujNowaWalute() throws BrakWalutDoWylosowania {
        Random r = new Random();
        if(waluty.isEmpty()) throw new BrakWalutDoWylosowania();
        int a = r.nextInt(waluty.size());
        return waluty.remove(a);
    }
    
    /**
     * losowanie nazwy i jednostki surowca z dostepnej puli
     * @return surowiec wylosowany surowiec
     * @throws BrakSurowcaDoWylosowania skończyły się przygotowane surowce
     */
    public static ParaString losujNowySurowiec() throws BrakSurowcaDoWylosowania {
        Random r = new Random();
        if(surowce.isEmpty()) throw new BrakSurowcaDoWylosowania();
        int a = r.nextInt(surowce.size());
        return surowce.remove(a);
    }
    
    /**
     * losowanie nazwy giełdy z dostepnej puli
     * @return wylosowana giełda
     * @throws BrakGieldyDoWylosowania skończyły się przygotowane giełdy
     */
    public static ParaString losujInfoGieldy() throws BrakGieldyDoWylosowania {
        Random r = new Random();
        if(gieldy.isEmpty()) throw new BrakGieldyDoWylosowania();
        int a = r.nextInt(gieldy.size());
        return gieldy.remove(a);
    }
    
    /**
     * Losowanie miasta
     * @return wylosowane miasto
     */
    public static String losujMiasto() {    
        Random r = new Random();
        int a = r.nextInt(miasta.size());
        return miasta.get(a);
    }
    
    /**
     * losowanie adresu
     * @return wylosowany adres
     */
    public static String losujAdres() {     
        Random r = new Random();
        int a = r.nextInt(adresy.size());
        return (adresy.get(a) + " " + Integer.toString(r.nextInt(100)+1)+ " / " + Integer.toString(r.nextInt(300)+1));
    }
    
    /**
     * losowanie nazwy
     * @return wylosowana nazwa
     */
    public static String losujNazwe() {    
        Random r = new Random();
        int a = r.nextInt(nazwy.size());
        int b = r.nextInt(nazwy.size());
        return nazwy.get(a)+nazwy.get(b);
    }
    
    /**
     * Tworzenie nazwy funduszu
     * @return nazwa funduszu
     */
    public static String losujNazweFundusz() {    
        String s = losujNazwe();
        return s + " FUND";
    }
    
    /**
     * Losowanie waluty z istniejących
     * @return wylosowana waluta
     */
    public static Waluta losujWaluta() {
        Random r = new Random();
        int a = r.nextInt(Swiat.listaWalut.size());
        return Swiat.listaWalut.get(a);
    }
    
    /**
     * Losowanie surowca z istniejących
     * @return wylosowany surowiec
     */
    public static Surowiec losujSurowiec() {
        Random r = new Random();
        int a = r.nextInt(Swiat.listaSurowcow.size());
        return Swiat.listaSurowcow.get(a);
    }
    
    /**
     * Losowanie funduszu z istniejących
     * @return wylosowany fundusz
     */
    public static Fundusz losujFundusz() {
        Random r = new Random();
        int a = r.nextInt(Swiat.listaFunduszy.size());
        return Swiat.listaFunduszy.get(a);
    }
    
    /**
     * Losowanie giełdy z dostępnych
     * @return wylosowana giełda
     */
    public static Gielda losujGielda() {
        Random r = new Random();
        int a = r.nextInt(Swiat.listaGield.size());
        return Swiat.listaGield.get(a);
    }
    
    /**
     * Losowa zmiana wartości aktywa
     * @param liczba wartosc od której nachodzi zmiana
     * @return nowa wartosc
     */
    public static double zmienWartosc(double liczba) {
        if(losujInt(2) == 0) {
            return (1+(losujDouble())/100)*liczba;
        } 
        return (1-(losujDouble())/100)*liczba;
    }

    /**
     * Zaokrąglanie wartości double do określonej liczby miejsc po przecinku
     * @param wartosc zaokrąglana wartość
     * @param miejsca do którego miejsca po przecinku
     * @return zaokrąglona wartość
     */
    public static double round(double wartosc, int miejsca) {
    if (miejsca < 0) return wartosc;

    BigDecimal bd = new BigDecimal(wartosc);
    bd = bd.setScale(miejsca, RoundingMode.HALF_UP);
    return bd.doubleValue();
    }

    /**
     *
     * @return lista imion
     */
    public static List<String> getImiona() {
        return imiona;
    }

    /**
     *
     * @param imiona lista imion
     */
    public static void setImiona(List<String> imiona) {
        Losowanie.imiona = imiona;
    }

    /**
     *
     * @return lista nazwisk
     */
    public static List<String> getNazwiska() {
        return nazwiska;
    }

    /**
     *
     * @param nazwiska lista nazwisk
     */
    public static void setNazwiska(List<String> nazwiska) {
        Losowanie.nazwiska = nazwiska;
    }

    /**
     *
     * @return lista krajów
     */
    public static List<String> getKraje() {
        return kraje;
    }

    /**
     *
     * @param kraje lista krajów
     */
    public static void setKraje(List<String> kraje) {
        Losowanie.kraje = kraje;
    }

    /**
     *
     * @return lista walut
     */
    public static List<String> getWaluty() {
        return waluty;
    }

    /**
     *
     * @param waluty lista walut
     */
    public static void setWaluty(List<String> waluty) {
        Losowanie.waluty = waluty;
    }

    /**
     *
     * @return lista surowcow
     */
    public static List<ParaString> getSurowce() {
        return surowce;
    }

    /**
     *
     * @param surowce lista surowców
     */
    public static void setSurowce(List<ParaString> surowce) {
        Losowanie.surowce = surowce;
    }

    /**
     *
     * @return lista miast
     */
    public static List<String> getMiasta() {
        return miasta;
    }

    /**
     *
     * @param miasta lista miast
     */
    public static void setMiasta(List<String> miasta) {
        Losowanie.miasta = miasta;
    }

    /**
     *
     * @return lista adresow
     */
    public static List<String> getAdresy() {
        return adresy;
    }

    /**
     *
     * @param adresy lista adresow
     */
    public static void setAdresy(List<String> adresy) {
        Losowanie.adresy = adresy;
    }

    /**
     *
     * @return lista nazw
     */
    public static List<String> getNazwy() {
        return nazwy;
    }

    /**
     *
     * @param nazwy lista nazw
     */
    public static void setNazwy(List<String> nazwy) {
        Losowanie.nazwy = nazwy;
    }

    /**
     *
     * @return lista giełd
     */
    public static List<ParaString> getGieldy() {
        return gieldy;
    }

    /**
     *
     * @param gieldy lista giełd
     */
    public static void setGieldy(List<ParaString> gieldy) {
        Losowanie.gieldy = gieldy;
    }
    
    
    
}
