import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(
                new FileInputStream(new File("D:/1.txt")));

        Socket socket = new Socket(InetAddress.getLocalHost().getHostAddress(), 7001);

        OutputStream outputStream = socket.getOutputStream();

        int length = -1;
        byte[] buf = new byte[1024 * 8];

        while ((length = bis.read(buf)) != -1) {
            outputStream.write(buf, 0, length);
        }

        socket.close();
        bis.close();
    }
}