/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bledy;

/**
 * Błąd - wykorzystano wszystkie przygotowane surowce
 * @author Monika Zielińska
 */
public class BrakSurowcaDoWylosowania extends Exception {

    /**
     * Creates a new instance of <code>BrakSurowca</code> without detail
     * message.
     */
    public BrakSurowcaDoWylosowania() {
    }

    /**
     * Constructs an instance of <code>BrakSurowca</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public BrakSurowcaDoWylosowania(String msg) {
        super(msg);
    }
}
