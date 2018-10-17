/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prak6;

/**
 *
 * @author NuH
 */
public class Periksa extends Thread {

    Dokter d = new Dokter("johan");
    String namaDok = d.getNama();
    Pasien p = new Pasien(1);
    String p0 = p.getNama(0);
    String p1 = p.getNama(1);
    String p2 = p.getNama(2);
    String p3 = p.getNama(3);
    String p4 = p.getNama(4);
    String p5 = p.getNama(5);
    String p6 = p.getNama(6);
    String p7 = p.getNama(7);
    String p8 = p.getNama(8);
    String p9 = p.getNama(9);
    String pasall[] = {p0, p1, p2, p3, p4, p5, p6, p7, p8,p9};
    int urut;

    public Periksa(int i) {
        urut = i;
    }

    @Override
    public void run() {
        System.out.println("pasien " + pasall[urut] + " telah diperiksa " + namaDok);

    }
}
