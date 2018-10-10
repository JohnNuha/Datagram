
package prak5.FIX;


import com.sun.media.sound.WaveFileWriter;
import java.awt.image.BufferedImage;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioFileFormat;

public class ServerGambari {

    ServerSocket serverSocket = null;
    Socket socket = null;
    DataInputStream dataInputStream = null;
 public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(13085);
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();

        System.out.println("Reading: " + System.currentTimeMillis());

        byte[] sizeAr = new byte[100];
        inputStream.read(sizeAr);
        int size = ByteBuffer.wrap(sizeAr).asIntBuffer().get();

        byte[] imageAr = new byte[size];
        inputStream.read(imageAr);


        BufferedImage image = ImageIO.read(new ByteArrayInputStream(imageAr));

        System.out.println("Received " + image.getHeight() + "x" + image.getWidth() + ": " + System.currentTimeMillis());
        ImageIO.write(image, "jpg", new File("f:/hasilTCP.jpg"));

        serverSocket.close();
    }

}