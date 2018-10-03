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
public class Nomor_04_DataMahasiswa extends javax.swing.JFrame {

    public static final int SERVICE_PORT = 7;
    public static final int BUFSIZE = 256;

    /** Creates new form DataMahasiswa */
    public Nomor_04_DataMahasiswa() {
        initComponents();
    }

    public void udp() throws IOException {
        String hostname = "localhost";
        InetAddress addr = InetAddress.getByName(hostname);
        DatagramSocket soket = new DatagramSocket();
        soket.setSoTimeout(8000);
        Mahasiswa parti = new Mahasiswa(NIM, Nama, Alamat, Kelas);
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 1; i++) {
            System.out.println("Tulis data mahasiswa");
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            PrintStream pout = new PrintStream(bout);
            pout.print(parti);
            System.out.println(parti);

            byte[] barray = bout.toByteArray();
            DatagramPacket paket = new DatagramPacket(barray, barray.length, addr, SERVICE_PORT);
            System.out.println("Mengirim data ke " + hostname);
            soket.send(paket);
            System.out.println("menunggu respon");

            byte[] recbuf = new byte[BUFSIZE];
            DatagramPacket terima = new DatagramPacket(recbuf, BUFSIZE);
            boolean timeout = false;

            if (!timeout) {
                System.out.println("data terkirim ");

            } else {
                System.out.println("pengiriman gagal");
            }
        }
    }

    public void tbh() {
        NIM = JOptionPane.showInputDialog("Masukkan NIM!");
        Nama = JOptionPane.showInputDialog("Masukkan Nama!");
        Alamat = JOptionPane.showInputDialog("Masukkan Alamat!");
        Kelas = JOptionPane.showInputDialog("Masukkan Kelas!");

        participants.add(new Mahasiswa(NIM, Nama, Alamat, Kelas));


    }

    public void edit(int h) {
        NIM = JOptionPane.showInputDialog("Masukkan NIM!");
        Nama = JOptionPane.showInputDialog("Masukkan Nama!");
        Alamat = JOptionPane.showInputDialog("Masukkan Alamat!");
        Kelas = JOptionPane.showInputDialog("Masukkan Kelas!");


        participants.set(h, new Mahasiswa(NIM, Nama, Alamat, Kelas));
        System.out.println("hasil edit" + participants);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dt_mhs = new javax.swing.JLabel();
        insert = new javax.swing.JButton();
        update = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        save = new javax.swing.JButton();
        Clear = new javax.swing.JButton();
        print = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 51));

        dt_mhs.setFont(new java.awt.Font("Tahoma", 1, 18));
        dt_mhs.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dt_mhs.setText("Data Mahasiswa");

        insert.setText("Insert");
        insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertActionPerformed(evt);
            }
        });

        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        Clear.setText("clear");
        Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearActionPerformed(evt);
            }
        });

        print.setText("print");
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
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
            .addGroup(layout.createSequentialGroup()
                .addGap(156, 156, 156)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(print)
                        .addContainerGap())
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(Clear)
                            .addContainerGap())
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(delete, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                                    .addComponent(insert, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(update, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE))
                                .addGap(165, 165, 165))
                            .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(dt_mhs, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(insert)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(update)
                .addGap(11, 11, 11)
                .addComponent(delete)
                .addGap(18, 18, 18)
                .addComponent(save)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Clear)
                .addGap(18, 18, 18)
                .addComponent(print)
                .addGap(65, 65, 65))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    List<Mahasiswa> participants = new ArrayList<Mahasiswa>();
    SerializationDemo demo = new SerializationDemo();
    String NIM, Nama, Alamat, Kelas;

    private void insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertActionPerformed
        tbh();

        try {
            udp();
        } catch (IOException ex) {
            Logger.getLogger(Nomor_04_DataMahasiswa.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_insertActionPerformed
    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        String edit = JOptionPane.showInputDialog("Update data berdasarkan index");
        int h = Integer.parseInt(edit);
        edit(h);
        demo.serialize(participants, "f:/Tugas_Nomor_04.ser");
        System.out.println("info data diedit pada index " + h);
        try {
            udp();
        } catch (IOException ex) {
            Logger.getLogger(Nomor_04_DataMahasiswa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_updateActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed

        String hapus = JOptionPane.showInputDialog("Hapus data berdasarkan index");
        int h = Integer.parseInt(hapus);
        participants.remove(h);
        System.out.println("hasil hapus " + participants);
        demo.serialize(participants, "f:/Tugas_Nomor_04.ser");
    }//GEN-LAST:event_deleteActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        demo.seri(participants, "f:/Tugas_Nomor_04.ser");
        System.out.println(participants);
        JOptionPane.showMessageDialog(null,  "Serialization is Done");
    }//GEN-LAST:event_saveActionPerformed

    private void ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearActionPerformed
        // TODO add your handling code here:
        try {
            PrintWriter pw = new PrintWriter("f:/Tugas_Nomor_04.ser");
            pw.close();
            JOptionPane.showMessageDialog(null, "Data f:/Tugas_Nomor_04.ser");
        } catch (IOException ioe) {
            System.out.println("A problem accured during serialize.\n" + ioe.getMessage());
        }
    }//GEN-LAST:event_ClearActionPerformed

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
        try {
            demo.deserialize("f:/Tugas_Nomor_04.ser");
            JOptionPane.showMessageDialog(null, "mahasiswa " + participants);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Nomor_04_DataMahasiswa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_printActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Nomor_04_DataMahasiswa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Clear;
    private javax.swing.JButton delete;
    private javax.swing.JLabel dt_mhs;
    private javax.swing.JButton insert;
    private javax.swing.JButton print;
    private javax.swing.JButton save;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
