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
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;

public class ServerAudio {

    ServerSocket serverSocket = null;
    Socket socket = null;
    DataInputStream dataInputStream = null;

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(13085);
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();

        System.out.println("Reading: " + System.currentTimeMillis());
        File file = new File("f:/musicTCP.wav");
        AudioInputStream in = AudioSystem.getAudioInputStream(inputStream);
        
        WaveFileWriter writer = new WaveFileWriter();

        writer.write((AudioInputStream) inputStream, AudioFileFormat.Type.WAVE, file);


        System.out.println("Received " + file.getAbsolutePath());
     

        serverSocket.close();
    }
}