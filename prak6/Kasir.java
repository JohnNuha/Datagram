/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package prak6;

/**
 *
 * @author NuH
 */
public class Kasir extends Thread{
    String dok;
    public Kasir(String nama){
        dok=nama;
    }
    public String getNama(){
        return dok;
    }
    @Override
    public void run(){
        System.out.println("Kasir "+dok+" siap");
    }

}
