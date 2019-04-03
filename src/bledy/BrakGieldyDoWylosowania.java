/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bledy;

/**
 * Błąd - wykorzystano wszystkie zapisane nazwy giełd
 * @author Monika Zielińska
 */
public class BrakGieldyDoWylosowania extends Exception {

    /**
     * Creates a new instance of <code>BrakGieldy</code> without detail message.
     */
    public BrakGieldyDoWylosowania() {
    }

    /**
     * Constructs an instance of <code>BrakGieldy</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public BrakGieldyDoWylosowania(String msg) {
        super(msg);
    }
}
