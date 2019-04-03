/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bledy;

/**
 *
 * @author Monika Zielińska
 */
public class LiczbaUjemna extends Exception {

    /**
     * Creates a new instance of <code>LiczbaUjemna</code> without detail
     * message.
     */
    public LiczbaUjemna() {
    }

    /**
     * Constructs an instance of <code>LiczbaUjemna</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public LiczbaUjemna(String msg) {
        super(msg);
    }
}
