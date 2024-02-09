import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {
            /*byte[] data = new byte[1000];
            DatagramSocket s = new DatagramSocket();
            InetAddress addr = InetAddress.getLocalHost();

            FileInputStream fr = new FileInputStream(new File("F:/star.png"));
            DatagramPacket pac;*/

            BufferedImage img = ImageIO.read(new File("F:/star.png"));
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(img, "png", baos);
            baos.flush();
            byte[] buffer = baos.toByteArray();

            DatagramSocket client = new DatagramSocket();
            InetAddress addr = InetAddress.getLocalHost();
            //InetAddress IPAdress = InetAddress.getByName("8033");

            DatagramPacket pac = new DatagramPacket(buffer, buffer.length, addr, 8033);

            client.send(pac);

            /*while (fr.read(data) != -1) {
                pac = new DatagramPacket(data, data.length, addr, 8033);
                s.send(pac);
            }

            fr.close();*/
            System.out.println("Файл отправлен");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}