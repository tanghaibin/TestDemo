package top.tanghaibin.one;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.util.concurrent.ExecutorService;

/**
 * Created by Administrator on 2016/3/15.
 */
public class ProcessUtil {

    public static Request readRequest(InputStream in)throws Exception{
        //编码
        byte[] encodeByte = new byte[1];
        in.read(encodeByte);
        byte encode = encodeByte[0];
        //参数长度
        byte[] contentLengthBytes = new byte[4];
        in.read(contentLengthBytes);
        int contentLength = ByteUtils.bytes2Int(contentLengthBytes);
        //参数
        byte[] contentBytes = new byte[contentLength];
        in.read(contentBytes);
        String content = null;
        if(Encode.ENCODE_UTF_8 == encode){
            content = new String(contentBytes,"UTF-8");
        }else if(Encode.ENCODE_GBK == encode){
            content = new String(contentBytes,"GBK");
        }else if(Encode.ENCODE_GB2312 == encode){
            content = new String(contentBytes,"gb2312");
        }
        Request request = new Request(encode,content,contentLength);
        in.close();
        return request;
    }

    public static void writeResponse(OutputStream out,Response response)throws Exception{
        out.write(response.getEncode());
        out.write(ByteUtils.int2ByteArray(response.getResponseLength()));
        if(Encode.ENCODE_UTF_8 == response.getEncode()){
            out.write(response.getResponse().getBytes("utf-8"));
        }else if(Encode.ENCODE_GBK == response.getEncode()){
            out.write(response.getResponse().getBytes("gbk"));
        }else if(Encode.ENCODE_GB2312 == response.getEncode()){
            out.write(response.getResponse().getBytes("gb2312"));
        }
        out.flush();
        out.close();
    }

    public static void writeRequest(OutputStream outputStream,Request request)throws Exception{

        outputStream.write(request.getEncode());

        outputStream.write(request.getParamLength());

        outputStream.write(request.getParam().getBytes());

        outputStream.close();
    }

    public static Response readResponse(InputStream inputStream)throws Exception{
        byte [] b = new byte[1024];
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        objectInputStream.read(b);
        Response response = new Response();
        response.setResponse(new String(b,0,b.length));
        return  response;
    }
}
