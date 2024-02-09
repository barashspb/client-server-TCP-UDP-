import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        File file = new File("F:/star1.png");
        System.out.println("Прием данных…");

        try {
            acceptFile(file, 8033, 15000);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void acceptFile(File file, int port,
                                   int pacSize) throws IOException {
        byte data[] = new byte[pacSize];
        DatagramPacket pac = new DatagramPacket(data, data.length);
        DatagramSocket s = new DatagramSocket(port);
        FileOutputStream os = new FileOutputStream(file);

        try {
            s.setSoTimeout(60000);

            while (true) {
                s.receive(pac);
                os.write(data);
                //os.flush();
            }
        } catch (SocketTimeoutException e) {

            System.out.println("Истекло время ожидания, прием данных закончен");
        } finally{
            os.close();
        }
    }
}