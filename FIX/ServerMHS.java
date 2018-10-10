/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prak5.FIX;


import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NuH
 */
public class ServerMHS {

    public static final int SERVICE_PORT = 13;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(SERVICE_PORT);
            System.out.println("Menunggu Request");
            for (;;) {
                Socket nexClient = server.accept();
                System.out.println("Diterima request dari " + nexClient.getInetAddress() + " : " + nexClient.getPort());
                OutputStream out = nexClient.getOutputStream();
                PrintStream pout = new PrintStream(out);
                pout.print(pout);
                System.out.println(pout);
               pout.print(new java.util.Date());

           //     BufferedReader buffer2 = new BufferedReader(pout);
              //  System.out.println(buffer2.readLine());
                out.flush();
                out.close();
                nexClient.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(ServerMHS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
