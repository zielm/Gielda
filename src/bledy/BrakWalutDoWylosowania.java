/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bledy;

/**
 * Błąd - wykorzystano wszystkie przygotowane waluty
 * @author Monika Zielińska
 */
public class BrakWalutDoWylosowania extends Exception {

    /**
     * Creates a new instance of <code>BrakWalut</code> without detail message.
     */
    public BrakWalutDoWylosowania() {
    }

    /**
     * Constructs an instance of <code>BrakWalut</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public BrakWalutDoWylosowania(String msg) {
        super(msg);
    }
}
