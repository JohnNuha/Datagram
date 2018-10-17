/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package prak6;

/**
 *
 * @author NuH
 */
public class PeriksaPer extends Thread {
    Dokter d= new Dokter("johan");
    String namaDok=d.getNama();
    Pasien p=new Pasien(1);
    String p0= p.getNama(0);
    String p1= p.getNama(1);
    String p2= p.getNama(2);
    String p3= p.getNama(3);
    String p4= p.getNama(4);
    String p5= p.getNama(5);
    String p6= p.getNama(6);
    String p7= p.getNama(7);
    String p8= p.getNama(8);
    String p9= p.getNama(9);
    String pasall[]={p0, p1, p2, p3, p4, p5, p6, p7,p8,p9};

    Perawat pw= new Perawat(1);
    String per=pw.getNama(0);
    String per2=pw.getNama(1);
    String []susall={per, per2};
    int urut;
    int urutPas;
    public PeriksaPer(int i, int x){
        urut=i;
        urutPas= x;
    }
    @Override
    public void run(){
        System.out.println("Perawat "+susall[urut] + " telah memeriksa "+pasall[urutPas]);

    }




}
