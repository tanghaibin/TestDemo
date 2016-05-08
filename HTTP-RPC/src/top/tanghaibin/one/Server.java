package top.tanghaibin.one;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Administrator on 2016/3/15.
 */
public class Server {

    public static void main(String [] args)throws Exception{

        ServerSocket serverSocket = new ServerSocket(12345);
        while(true) {
            Socket socket = serverSocket.accept();
            InputStream in = socket.getInputStream();
            ObjectInputStream inputStream = new ObjectInputStream(in);
            Request request = (Request) inputStream.readObject();
            System.out.println(request);
            Response response = new Response(request.getEncode(),"server",6);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(response);
        }

    }
}
