/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package prak6;

/**
 *
 * @author NuH
 */
public class Pasien extends Thread{
    String pas1="pasien a";
    String pas2="pasien b";
    String pas3="pasien c";
    String pas4="pasien d";
    String pas5="pasien e";
    String pas6="pasien f";
    String pas7="pasien g";
    String pas8="pasien h";
    String pas9="pasien i";
    String pas10="pasien j";
    String suster[]={pas1, pas2, pas3, pas4, pas5, pas6, pas7, pas8, pas9, pas10,};
    int index;
    public Pasien( int i){
        index=i;
       
    }
    public String getNama(int g){
        return suster[g];
    }
    @Override
    public void run(){
       // String suster[]={pas1, pas2, pas3, pas4, pas5, pas6, pas7, pas8, pas9, pas10,};

        System.out.println("Pasien "+suster[index]+" datang");
    }

}
