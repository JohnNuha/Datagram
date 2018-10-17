/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prak6;

import java.io.*;
import java.net.*;

public class Multi implements Runnable {

    public static final int port = 5678;

    public void run() {
        try {
            ServerSocket server = new ServerSocket(port);
            int i = 0;
            while (i < 5) {
                int b=i+1;
                final Socket client = server.accept();
                System.out.println("Request dari " + client.getLocalAddress() + client.getLocalPort() + " pengunjung ke " +b);
                i++;
                new Thread() {

                    @Override
                    public void run() {

                        try {

                            InputStream in = client.getInputStream();

                            InputStreamReader isr = new InputStreamReader(in);
                            BufferedReader br = new BufferedReader(isr);
                                String message = br.readLine();
                                System.out.println(message);
                            String returnMessage;

                            returnMessage = "Ahlan wa sahlan";

                            //    Sending the response back to the client.
                            OutputStream os = client.getOutputStream();
                            OutputStreamWriter osw = new OutputStreamWriter(os);
                            BufferedWriter bw = new BufferedWriter(osw);
                            bw.write(returnMessage);
                            //         System.out.println("Message sent to the client is "+returnMessage);
                            bw.flush();
                        } catch (Exception e) {
                            System.err.println(e);
                        }

                    }
                }.start();

            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    public static void main(String[] args) {
        Multi m = new Multi();
        new Thread(m).start();
        new Thread(m).stop();

    }
}