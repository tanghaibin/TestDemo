package top.tanghaibin.one;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/3/15.
 */
public class Response implements Serializable {
    /**
     * 编码
     */
    private byte encode;
    /**
     * 返回的内容
     */
    private String response;
    /**
     * 返回类容的长度
     */
    private Integer responseLength;

    public Response(){}
    public Response(byte encode,String response,Integer responseLength){
        this.encode = encode;
        this.response = response;
        this.responseLength = responseLength;
    }
    public byte getEncode() {
        return encode;
    }

    public void setEncode(byte encode) {
        this.encode = encode;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public Integer getResponseLength() {
        return responseLength;
    }

    public void setResponseLength(Integer responseLength) {
        this.responseLength = responseLength;
    }

    @Override
    public String toString() {
        return "Response{" +
                "encode=" + encode +
                ", response='" + response + '\'' +
                ", responseLength=" + responseLength +
                '}';
    }
}
