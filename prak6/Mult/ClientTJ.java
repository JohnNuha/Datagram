/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prak6.Mult;

import prak5.No2.*;
import prak5.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import javax.swing.JOptionPane;
import prak6.Multi;

public class ClientTJ {

    private static Socket socket;

    public static void main(String args[]) {
        try {
            for(;;){
            String host = "localhost";
            int port = 25000;
            InetAddress address = InetAddress.getByName(host);
            socket = new Socket(address,port);

            //Send the message to the server
            OutputStream os = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);

          //  String number = "Assalamualaikum";
            String n="hai";
            String sendMessage = n + "\n";
            bw.write(sendMessage);
           bw.flush();
            System.out.println("Message sent to the server : " + sendMessage);

            //Get the return message from the server
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String message = br.readLine();
          System.out.println("Message received from the server : " + message);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            //Closing the socket
            try {
                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}