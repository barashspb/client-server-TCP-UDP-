import java.io.*;
import java.net.*;

class Client
{
    public static void main(String args[])throws Exception
    {
        String line, newLine;
        try
        {
            DataInputStream in=new DataInputStream(System.in);
            Socket cs=new Socket("LocalHost",6789);
            System.out.println("Client Started...");
            DataInputStream inp=new DataInputStream (cs.getInputStream());
            DataOutputStream out=new DataOutputStream(cs.getOutputStream());

            while(true) {
                newLine = in.readLine();

                if (newLine.equals("q")) {
                    out.writeBytes("Client is down..." +'\n');
                    return;
                } else {
                    out.writeBytes(newLine + '\n');
                }
                line = inp.readLine();
                System.out.println("Received from server: "+line);
            }
        }
        catch(Exception e)
        {
        }
    }
}