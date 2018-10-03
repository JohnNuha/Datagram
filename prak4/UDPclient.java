/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prak4;

import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.lang.System;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author NuH
 */
public class UDPclient {

    public static final int SERVICE_PORT = 7;
    public static final int BUFSIZE = 256;



    public static void main(String[] args) throws UnknownHostException,IOException, ClassNotFoundException {
        String hostname = "localhost";
        InetAddress addr = InetAddress.getByName(hostname);
        DatagramSocket soket = new DatagramSocket();
        soket.setSoTimeout(2000);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (;;) {
            System.out.println("Tulis data mahasiswa");
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            PrintStream pout = new PrintStream(bout);
            pout.print(br.readLine());

            byte[] barray = bout.toByteArray();

            DatagramPacket paket = new DatagramPacket(barray, barray.length, addr, SERVICE_PORT);
            System.out.println("Mengirim data ke " + hostname);
            soket.send(paket);

            System.out.println("menunggu respon");

            byte[] recbuf = new byte[BUFSIZE];
            DatagramPacket terima = new DatagramPacket(recbuf, BUFSIZE);

            boolean timeout = false;

            try {
                soket.receive(terima);
            } catch (Exception e) {
                timeout = true;
            }
            if (!timeout) {
                System.out.println("data diterima ");
                System.out.println("Detrails : " + terima.getAddress());

                ByteArrayInputStream bin = new ByteArrayInputStream(terima.getData(), 0, terima.getLength());

                BufferedReader buffer2 = new BufferedReader(new InputStreamReader(bin));
                System.out.println(buffer2.readLine());

            } else {
                System.out.println("pengiriman gagal");
            }
        }


    }
}
