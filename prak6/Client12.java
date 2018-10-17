/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prak6;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author NuH
 */
public class Client12 extends Thread {

    public void writeMessage(String msg) throws IOException {
        new ObjectOutputStream((new Socket("localhost", Multi.port).getOutputStream())).writeObject(msg);
    }

    public static void main(String[] args) throws IOException, InterruptedException {
      //  Thread.sleep(7000);
        Client12 client1 = new Client12();

        client1.writeMessage("Hello ! saya Nomor 3");

    }
}

