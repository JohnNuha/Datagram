/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prak6;

/**
 *
 * @author NuH
 */
public class Hospital {

    public static void main(String[] args) throws InterruptedException {
        int i;
        Thread d = new Dokter("johan");
        Thread per = new Perawat(1);
        Thread per1 = new Perawat(0);
        Thread kas = new Kasir("jojo");

        
 
        d.start();
        per.start();
        per1.start();
        kas.start();
        Thread.sleep(2000);
      for(i=0;i<9;i++){
        Thread pas = new Pasien(i);
        pas.start();

        }

       
        for (i = 0; i < 9; i++) {
            Thread prk = new Periksa(i);
            prk.start();
            Thread.sleep(700);
        }
        for (i = 0; i < 5; i++) {
           int i2 = i + 5;

            Thread prkpi = new PeriksaPer(0, i);
            Thread prkpi1 = new PeriksaPer(1, i2);
            prkpi.start();
            prkpi1.start();

            Thread.sleep(600);
        }
for (i = 0; i < 9; i++) {
            Thread prk = new Bayar(i);
            prk.start();
            Thread.sleep(700);
        }


    }
}
