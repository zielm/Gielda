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
public class ZaMaloObiektow extends Exception {

    /**
     * Creates a new instance of <code>ZaMaloObiektow</code> without detail
     * message.
     */
    public ZaMaloObiektow() {
    }

    /**
     * Constructs an instance of <code>ZaMaloObiektow</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public ZaMaloObiektow(String msg) {
        super(msg);
    }
}
