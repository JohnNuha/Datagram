/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prak6;

/**
 *
 * @author NuH
 */
public class Perawat extends Thread {

    String per1 = "aisya";
    String per2 = "maria";
    int index;
    String suster[] = {per1, per2};

    public Perawat(int i) {
        index = i;

    }

    public String getNama(int g) {
        return suster[g];
    }

    @Override
    public void run() {


        System.out.println("Perawat " + suster[index] + " siap");
    }
}
