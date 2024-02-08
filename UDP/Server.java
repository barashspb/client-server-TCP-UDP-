// Java program to illustrate Server side
// Implementation using DatagramSocket
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {
    public static void main(String[] args) throws IOException
    {
        //создаем сокет
        DatagramSocket ds = new DatagramSocket(7001);
        byte[] receive = new byte[65535];

        DatagramPacket DpReceive = null;
        while (true)
        {

            //создаем DatgramPacket для отправки данных
            DpReceive = new DatagramPacket(receive, receive.length);
            //отправляем принятые данные в буфер
            ds.receive(DpReceive);
            System.out.println("Client:-" + data(receive));

            if (data(receive).toString().equals("exit"))
            {
                System.out.println("Client exit.....");
                break;
            }
            //очищаем буфер после каждого сообщения
            receive = new byte[65535];
        }
    }

    public static StringBuilder data(byte[] a)
    {
        if (a == null)
            return null;
        StringBuilder ret = new StringBuilder();
        int i = 0;
        while (a[i] != 0)
        {
            ret.append((char) a[i]);
            i++;
        }
        return ret;
    }
}