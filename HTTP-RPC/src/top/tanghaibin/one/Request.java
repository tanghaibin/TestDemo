package top.tanghaibin.one;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/3/15.
 */
public class Request implements Serializable{
    /**
     * 编码
     */
    private byte encode;
    /**
     * 请求的参数
     */
    private String param;
    /**
     * 参数长度
     */
    private Integer paramLength;

    public Request(){}

    public Request(byte encode,String param,Integer paramLength){
        this.encode = encode;
        this.param = param;
        this.paramLength = paramLength;
    }

    public byte getEncode() {
        return encode;
    }

    public void setEncode(byte encode) {
        this.encode = encode;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public Integer getParamLength() {
        return paramLength;
    }

    public void setParamLength(Integer paramLength) {
        this.paramLength = paramLength;
    }

    @Override
    public String toString() {
        return "Request{" +
                "encode=" + encode +
                ", param='" + param + '\'' +
                ", paramLength=" + paramLength +
                '}';
    }
}
