/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rynki;

import aktywa.Waluta;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Monika Zielińska
 */
public class RynekWalut extends Rynek{

    private List <Waluta> listaWalut;

    /**
     *
     */
    public RynekWalut() {
        super.setNazwa("Rynek Walut");
        this.listaWalut = new ArrayList<>();
    }
    
    /**
     *
     */
    public void aktualizujKurs() {
        
    }
   
}
