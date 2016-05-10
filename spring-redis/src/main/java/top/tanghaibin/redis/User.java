package top.tanghaibin.redis;

import java.io.Serializable;

/**
 * Created by tangh on 2016/5/10.
 */
public class User implements Serializable{

    private String username;
    private String pswd;
    private Integer age;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPswd() {
        return pswd;
    }

    public void setPswd(String pswd) {
        this.pswd = pswd;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", pswd='" + pswd + '\'' +
                ", age=" + age +
                '}';
    }
}
