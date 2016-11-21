package top.tanghaibin.mui.controller;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/**
 * Created by tangh on 2016/11/21.
 */
public class HttpClientTest {

    public static void main(String [] args) throws UnsupportedEncodingException {

        CloseableHttpClient client = HttpClients.custom().build();
        HttpPost httpPost = new HttpPost("http://127.0.0.1:8080/httpClient");
        MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();
//        multipartEntityBuilder.setCharset(Charset.forName("utf-8"));
        FileBody file = new FileBody(new File("F:\\壁纸\\b.jpg"));
        multipartEntityBuilder.addPart("file", file);
        multipartEntityBuilder.addTextBody("name", "tanghaibin");
        multipartEntityBuilder.addBinaryBody("lick", "骑行".getBytes("utf-8"));
        httpPost.setEntity(multipartEntityBuilder.build());

        try {
            CloseableHttpResponse response = client.execute(httpPost);
            HttpEntity result = response.getEntity();
            System.out.println(result.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
