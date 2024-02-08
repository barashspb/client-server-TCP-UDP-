import java.io.*;
import java.net.*;

class Server
{
    public static void main(String args[])throws Exception
    {
        try
        {
            String line, newLine;
            ServerSocket ss = new ServerSocket(6789);
            while(true)
            {
                //ожидание подключения
                Socket s=ss.accept();
                System.out.println("Server Started...");
                //чтение входной строки
                DataInputStream inp=new DataInputStream(s.getInputStream());
                DataOutputStream out = new DataOutputStream(s.getOutputStream());
                DataInputStream in=new DataInputStream(System.in);

                while(true) {
                    System.out.println("Press 'q' if you want to exit server");
                    line = inp.readLine();
                    System.out.println("Received from client: " + line);
                    newLine = in.readLine();

                    if (newLine.equals("q")) {
                        out.writeBytes("Server is down..." +'\n');
                        return;
                    } else {
                        out.writeBytes(newLine + '\n');
                    }
                }
            }
        }
        catch(Exception e)
        {

        }
    }
}