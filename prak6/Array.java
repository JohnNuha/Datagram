/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prak6;

/**
 *
 * @author NuH
 */
public class Array extends Thread {

    int indexArr;

    public Array(int no) {
        indexArr = no;
    }

    @Override
    public void run() {
        int data[] = {2, 5, 6, 7, 8, 9};
        int data1[] = {2, 5, 6, 7, 8, 9};
        int data2[] = {2, 5, 6, 7, 8, 9};
        System.out.println("penjumlahan array nomor " + indexArr + " dimulai");
        //    for (int i = 0; i < data.length; i++) {
        int sum = data[indexArr] + data1[indexArr] + data2[indexArr];
        System.out.println( sum + " ");
        try {
            Thread.sleep(6000);
            System.out.println("penjumlahan index " + indexArr + "selesai ");
        } catch (InterruptedException i) {
            System.out.println("penjumlahan index " + indexArr + "selesai ");

        }

        
    //      }

    }

    public static void main(String[] args) {

        Thread t = new Array(0);
        Thread t1 = new Array(1);
        Thread t2 = new Array(2);
        Thread t3 = new Array(3);
        Thread t4 = new Array(4);
        Thread t5 = new Array(5);

        t.start();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

    }
}
