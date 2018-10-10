/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * clientform.java
 *
 * Created on 03/10/2018, 02:44:44 م
 */
package prak5.FIX;

import prak5.*;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author NuH
 */
public class ClientMHS extends javax.swing.JFrame {

    /** Creates new form clientform */
    public ClientMHS() {
        initComponents();
    }
    List<Mahasiswa> participants = new ArrayList<Mahasiswa>();
    SerializationDemo demo = new SerializationDemo();
    String NIM, Nama, Alamat, Kelas;
    public static final int SERVICE_PORT = 13;

    public void tbh() {
        NIM = JOptionPane.showInputDialog("Masukkan NIM!");
        Nama = JOptionPane.showInputDialog("Masukkan Nama!");
        Alamat = JOptionPane.showInputDialog("Masukkan Alamat!");
        Kelas = JOptionPane.showInputDialog("Masukkan Kelas!");

        participants.add(new Mahasiswa(NIM, Nama, Alamat, Kelas));
        demo.serialize(participants, "f:/Tugas_Nomor_05.ser");
   

    }

    public void edit(int h) {
        NIM = JOptionPane.showInputDialog("Masukkan NIM!");
        Nama = JOptionPane.showInputDialog("Masukkan Nama!");
        Alamat = JOptionPane.showInputDialog("Masukkan Alamat!");
        Kelas = JOptionPane.showInputDialog("Masukkan Kelas!");


        participants.set(h, new Mahasiswa(NIM, Nama, Alamat, Kelas));
        System.out.println("hasil edit" + participants);
    }

    public void hapus(int ind) {
        String hapus = JOptionPane.showInputDialog("Hapus data berdasarkan index");
        ind = Integer.parseInt(hapus);
        participants.remove(ind);
        System.out.println("hasil hapus " + participants);
        demo.serialize(participants, "f:/Tugas_Nomor_05.ser");
    }

    public void cetak() {
        try {
            demo.deserialize("f:/Tugas_Nomor_05.ser");
            JOptionPane.showMessageDialog(null, "mahasiswa " + participants);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientMHS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void TCPc() {
        try {
            String hostname = "localhost";
            Socket daytime = new Socket(hostname, SERVICE_PORT);
            System.out.println("Terhubung");
            daytime.setSoTimeout(2000);
            Mahasiswa parti = new Mahasiswa(NIM, Nama, Alamat, Kelas);
            BufferedReader reader = new BufferedReader(new InputStreamReader(daytime.getInputStream()));
            System.out.println("HAsil :" + reader.readLine());
            //daytime.close();
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            PrintStream pout = new PrintStream(bout);
            pout.print(participants);
        } catch (IOException ex) {
            System.err.print(ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        insert = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 255, 255));

        insert.setText("insert");
        insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertActionPerformed(evt);
            }
        });

        jButton1.setText("save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(insert))
                .addContainerGap(159, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(insert)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertActionPerformed
        // TODO add your handling code here:
        tbh();

        TCPc();

    }//GEN-LAST:event_insertActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         demo.seri(participants, "f:/no5.ser");
        System.out.println(participants);
        JOptionPane.showMessageDialog(null,  "Serialization is Done");
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new ClientMHS().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton insert;
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
