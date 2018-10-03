/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prak4;

/**
 *
 * @author NuH
 */
import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;

public class UDPserver {

    public static final int SERVICE_PORT = 7;
    public static final int BUFSIZE = 256;
    private DatagramSocket soket;

    public UDPserver() {
        try {
            soket = new DatagramSocket(SERVICE_PORT);
            System.out.println("server aktiv pada poer " + soket.getLocalPort());
        } catch (Exception e) {
            System.out.println("tak terhubung");
        }
    }

    public void serviceClient() throws IOException {

        byte[] buffer = new byte[BUFSIZE];
        for (;;) {
            try {
                DatagramPacket paket = new DatagramPacket(buffer, BUFSIZE);
                soket.receive(paket);
                System.out.println("data diterima dari " + paket.getAddress() + " : " + paket.getPort() + " sepanjang " + paket.getLength());
                System.out.println(paket.getData());
        //        ByteArrayOutputStream bin = new ByteArrayOutputStream();
                ByteArrayInputStream bin = new ByteArrayInputStream(paket.getData(), 0,paket.getLength());

                BufferedReader buffer2 = new BufferedReader(new InputStreamReader(bin));
                System.out.println(buffer2.readLine()+"========================");

                soket.send(paket);
            }catch (IOException ioe){
                System.out.println("error "+ ioe);
            }
        }

    }
    public static void main(String[] args) throws IOException {
        UDPserver server= new UDPserver();
        server.serviceClient();

    }
}
