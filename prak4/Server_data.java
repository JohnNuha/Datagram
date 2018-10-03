/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DataMahasiswa.java
 *
 * Created on 16 Sep 18, 8:39:59
 */
package prak4;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import prakk03.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author CHP_SONE
 */
public class Server_data extends javax.swing.JFrame {

    public static final int SERVICE_PORT = 7;
    public static final int BUFSIZE = 256;
    private DatagramSocket soket;
    List<Mahasiswa> participants = new ArrayList<Mahasiswa>();
    SerializationDemo demo = new SerializationDemo();
    String NIM, Nama, Alamat, Kelas;
    Nomor_04_DataMahasiswa no = new Nomor_04_DataMahasiswa();

    /** Creates new form DataMahasiswa */
    public Server_data() {
        initComponents();
        try {
            soket = new DatagramSocket(SERVICE_PORT);
            System.out.println("server aktiv pada poer " + soket.getLocalPort());

        } catch (Exception e) {
            System.out.println("tak terhubung");
        }

    }

    public void terim() {
        byte[] buffer = new byte[BUFSIZE];
        for (;;) {
            try {
                DatagramPacket paket = new DatagramPacket(buffer, BUFSIZE);
                soket.receive(paket);
                System.out.println("data diterima dari " + paket.getAddress() + " : " + paket.getPort() + " sepanjang " + paket.getLength());

                soket.send(paket);
            } catch (IOException ioe) {
                System.out.println("error " + ioe);
            }
        }
    }

    public void ds() throws ClassNotFoundException {
        demo.deserialize("f:/Tugas_Nomor_04.ser");
        //     JOptionPane.showMessageDialog(null, "mahasiswa " + mhs);
        JOptionPane.showMessageDialog(null, "mahasiswa " + participants);
    //   System.out.println("mahasiswa " + mhs);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dt_mhs = new javax.swing.JLabel();
        print = new javax.swing.JButton();
        save = new javax.swing.JButton();
        terima = new javax.swing.JButton();
        x = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 51));

        dt_mhs.setFont(new java.awt.Font("Tahoma", 1, 18));
        dt_mhs.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dt_mhs.setText("Data Mahasiswa");

        print.setText("Print");
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });

        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        terima.setText("Terima");
        terima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                terimaActionPerformed(evt);
            }
        });

        x.setText("X");
        x.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dt_mhs, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
                .addGap(53, 53, 53))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(358, Short.MAX_VALUE)
                .addComponent(x))
            .addGroup(layout.createSequentialGroup()
                .addGap(156, 156, 156)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(print, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(terima))
                .addGap(168, 168, 168))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(x)
                .addGap(4, 4, 4)
                .addComponent(dt_mhs, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(terima)
                .addGap(18, 18, 18)
                .addComponent(save)
                .addGap(18, 18, 18)
                .addComponent(print)
                .addContainerGap(169, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
    try {
            demo.deserialize("f:/Tugas_Nomor_04.ser");
            JOptionPane.showMessageDialog(null, "mahasiswa " + participants);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Nomor_04_DataMahasiswa.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_printActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        demo.seri(participants, "f:/Tugas_Nomor_04.ser");
        System.out.println(participants);
        JOptionPane.showMessageDialog(null, "Serialization is Done");
    }//GEN-LAST:event_saveActionPerformed

    private void terimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_terimaActionPerformed
        // TODO add your handling code here:
        byte[] buffer = new byte[BUFSIZE];
        byte[] recbuf = new byte[BUFSIZE];
        for (int i = 0; i < 3; i++) {

            try {
                DatagramPacket paket = new DatagramPacket(buffer, BUFSIZE);
                soket.receive(paket);
                System.out.println("data diterima dari " + paket.getAddress() + " : " + paket.getPort() + " sepanjang " + paket.getLength());

                ByteArrayInputStream bin = new ByteArrayInputStream(paket.getData(), 0, paket.getLength());
                BufferedReader buffer2 = new BufferedReader(new InputStreamReader(bin));
                System.out.println(buffer2.readLine());
                ObjectInputStream is = new ObjectInputStream(bin);
                Mahasiswa m;
                try {
                    m = (Mahasiswa) is.readObject();
                    String n = m.getNama();
                    String a = m.getAlamat();
                    String ni = m.getNIM();
                    String k = m.getKelas();
                    System.out.println("================" + ni + n + a + k + "====================");
                    participants.add(new Mahasiswa(ni, n, a, k));

                    System.out.println(participants.add((Mahasiswa) is.readObject()) + "--------------------");
                    // participants.add((Mahasiswa) is.readObject());
                    demo.serialize(participants, "f:/Tugas_Nomor_04.ser");
                    demo.seri(participants, "f:/Tugas_Nomor_04.ser");
                    System.out.println(participants);
                    JOptionPane.showMessageDialog(null, "Serialization is Done");
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Server_data.class.getName()).log(Level.SEVERE, null, ex);
                }
                soket.send(paket);
            } catch (IOException ioe) {
                System.out.println("error " + ioe);
            }
            DatagramPacket terima = new DatagramPacket(recbuf, BUFSIZE);
//                soket.receive(terima);
//                System.out.println("data diterima ");
//                System.out.println("Detrails : " + terima.getAddress());
            //    participants.add(terima);

            demo.serialize(participants, "f:/Tugas_Nomor_04.ser");

        }


    }//GEN-LAST:event_terimaActionPerformed

    private void xActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xActionPerformed
        dispose();
    }//GEN-LAST:event_xActionPerformed

    public static void main(String args[]) {


        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Server_data().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel dt_mhs;
    private javax.swing.JButton print;
    private javax.swing.JButton save;
    private javax.swing.JButton terima;
    private javax.swing.JButton x;
    // End of variables declaration//GEN-END:variables
}
