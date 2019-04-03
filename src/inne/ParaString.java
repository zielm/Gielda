/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inne;

import java.io.Serializable;

/**
 * Klasa do przechowywania 2 stringów, używana m.in w klasie Surowiec
 * @author Monika Zielińska
 */
public class ParaString implements Serializable{
    private String pierwszy;
    private String drugi;

    /**
     *
     * @param pierwszy
     * @param drugi
     */
    public ParaString(String pierwszy, String drugi)
    {
        this.pierwszy = pierwszy;
        this.drugi = drugi;
    }

    /**
     *
     * @return
     */
    public String getPierwszy() {
        return pierwszy;
    }

    /**
     *
     * @param pierwszy
     */
    public void setPierwszy(String pierwszy) {
        this.pierwszy = pierwszy;
    }

    /**
     *
     * @return
     */
    public String getDrugi() {
        return drugi;
    }

    /**
     *
     * @param drugi
     */
    public void setDrugi(String drugi) {
        this.drugi = drugi;
    }
    
}
