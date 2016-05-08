package top.tanghaibin.one;

import java.io.*;
import java.net.Socket;

/**
 * Created by Administrator on 2016/3/15.
 */
public class Client {

    public static void main(String [] args)throws Exception{
        byte[] encode = new byte[1];
        encode[0] = 0;
        Request request = new Request(encode[0],"hello!tanghaibin",16);
        Socket socket = new Socket("127.0.0.1",12345);
        ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
        outputStream.writeObject(request);
        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
        Response response = (Response) objectInputStream.readObject();
        System.out.println(response);
    }
}
