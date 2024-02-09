import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(7001);

        Socket socket = serverSocket.accept();

        BufferedOutputStream bos = new BufferedOutputStream(
                new FileOutputStream(
                        new File("D:/2.txt")));

        InputStream inputStream = socket.getInputStream();

        int length = -1;
        byte[] buf = new byte[1024 * 8];

        while ((length = inputStream.read(buf)) != -1) {
            bos.write(buf, 0, length);
        }

        bos.close();
        socket.close();
    }
}
