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
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTJ extends Thread{

    private static Socket socket;

    @Override
    public void run() {
        try {

            int port = 25000;
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server Started and listening to the port 25000");

            //Server is running always. This is done using this while(true) loop
            int i=0;
            while (i<1) {
                i++;
                //Reading the message from the client
                socket = serverSocket.accept();
                InputStream is = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);
                String number = br.readLine();
                String n2 = "salam";
                String n3 = "hai";
                String n4 = "apa kabar";

                System.out.println("Message received from client " + serverSocket.getLocalPort() + serverSocket.getInetAddress() + " is " + number);

                //Multiplying the number by 2 and forming the return message
                String returnMessage;
                if (number.equals(n2)) {
                    returnMessage = "salam juga\n";
                } else if (number.equals(n3)){
                    returnMessage = "Hai Juga\n";
                }else if (number.equals(n4)){
                    returnMessage = "baik baik saja\n";
                }
                else{
                    returnMessage = "\n";
                }
                //    Sending the response back to the client.
                OutputStream os = socket.getOutputStream();
                OutputStreamWriter osw = new OutputStreamWriter(os);
                BufferedWriter bw = new BufferedWriter(osw);
                bw.write(returnMessage);
                //         System.out.println("Message sent to the client is "+returnMessage);
                bw.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (Exception e) {
            }
        }
    }
    public static void main(String[] args) {
      ////  int i=0;
       
            Thread b= new ServerTJ();
            Thread c= new ServerTJ();
            Thread d= new ServerTJ();
            Thread e= new ServerTJ();
            Thread f= new ServerTJ();
            b.start();
            c.start();
            d.start();
            e.start();
            f.start();
            System.out.println("client ke ");
   //     }

    }
}