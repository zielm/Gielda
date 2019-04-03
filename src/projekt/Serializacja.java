package projekt;

import aktywa.Akcja;
import aktywa.Aktywa;
import aktywa.JednostkaUczestnictwa;
import aktywa.Surowiec;
import aktywa.Waluta;
import inne.ParaString;
import inwestujacy.Fundusz;
import inwestujacy.Inwestor;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.jdesktop.observablecollections.ObservableCollections;
import rynki.Gielda;
import rynki.Rynek;
import rynki.RynekSurowcow;
import rynki.RynekWalut;

/**
 * Serializacja statycznych elementów
 * @author Monika Zielińska
 */

public class Serializacja implements Serializable {

    public boolean dzialanieSymulacji;
    public boolean wczytane;
    public int czas;
    public List <Gielda> listaGield;
    public RynekSurowcow rynekSurowcow;
    public RynekWalut rynekWalut;
    public List <Rynek> listaRynkow;
    public List <Spolka> listaSpolek;
    public List <Inwestor> listaInwestorow;
    public List <Fundusz> listaFunduszy;
    public List <Akcja> listaAkcji;
    public List <Surowiec> listaSurowcow;
    public List <Waluta> listaWalut;
    public List <JednostkaUczestnictwa> listaJednostekUczestnictwa;
    public List <Aktywa> listaAktywa;
    public List <String> imiona;
    public List <String> nazwiska;
    public List <String> kraje;
    public List <String> waluty;
    public List <ParaString> surowce;
    public List <String> miasta;
    public List <String> adresy;
    public List <String> nazwy;
    public List <ParaString> gieldy;
    

    /**
     * Kopiowanie statycznych pól
     */
    public Serializacja() {
        dzialanieSymulacji = Swiat.isDzialanieSymulacji();
        czas = Swiat.getCzas();
        wczytane = true;
        listaGield = new ArrayList<>(Swiat.getListaGield());
        rynekSurowcow = Swiat.rynekSurowcow;
        rynekWalut = Swiat.rynekWalut;
        listaRynkow = new ArrayList<>(Swiat.getListaRynkow());
        listaSpolek = new ArrayList<>(Swiat.getListaSpolek());
        listaInwestorow = new ArrayList<>(Swiat.getListaInwestorow());
        listaFunduszy = new ArrayList<>(Swiat.getListaFunduszy());
        listaAkcji = new ArrayList<>(Swiat.getListaAkcji());
        listaSurowcow = new ArrayList<>(Swiat.getListaSurowcow());
        listaWalut = new ArrayList<>(Swiat.getListaWalut());
        listaJednostekUczestnictwa = new ArrayList<>(Swiat.getListaJednostekUczestnictwa());
        listaAktywa = new ArrayList<>(Swiat.getListaAktywa());
        imiona = new ArrayList<>(Losowanie.getImiona());
        nazwiska = new ArrayList<>(Losowanie.getNazwiska());
        kraje = new ArrayList<>(Losowanie.getKraje());
        waluty = new ArrayList<>(Losowanie.getWaluty());
        surowce = new ArrayList<>(Losowanie.getSurowce());
        miasta = new ArrayList<>(Losowanie.getMiasta());
        adresy = new ArrayList<>(Losowanie.getAdresy());
        nazwy = new ArrayList<>(Losowanie.getNazwy());
        gieldy = new ArrayList<>(Losowanie.getGieldy());             
    }

    /**
     * odczytywanie danych z serializacji
     */
    public void zapiszDane() {
        Swiat.setDzialanieSymulacji(dzialanieSymulacji);
        Swiat.setCzas(czas);
        Swiat.setWczytane(wczytane);
        Swiat.setListaGield(ObservableCollections.observableList(listaGield));
        Swiat.setRynekSurowcow(rynekSurowcow);
        Swiat.setRynekWalut(rynekWalut);
        Swiat.setListaRynkow(ObservableCollections.observableList(listaRynkow));
        Swiat.setListaSpolek(ObservableCollections.observableList(listaSpolek));
        Swiat.setListaInwestorow(ObservableCollections.observableList(listaInwestorow));
        Swiat.setListaFunduszy(ObservableCollections.observableList(listaFunduszy));
        Swiat.setListaAkcji(ObservableCollections.observableList(listaAkcji));
        Swiat.setListaSurowcow(ObservableCollections.observableList(listaSurowcow));
        Swiat.setListaWalut(ObservableCollections.observableList(listaWalut));
        Swiat.setListaJednostekUczestnictwa(ObservableCollections.observableList(listaJednostekUczestnictwa));
        Swiat.setListaAktywa(ObservableCollections.observableList(listaAktywa));
        Losowanie.setImiona(imiona);
        Losowanie.setNazwiska(nazwiska);
        Losowanie.setKraje(kraje);
        Losowanie.setWaluty(waluty);
        Losowanie.setSurowce(surowce);
        Losowanie.setMiasta(miasta);
        Losowanie.setAdresy(adresy);
        Losowanie.setNazwy(nazwy);
        Losowanie.setGieldy(gieldy);
    }

}

