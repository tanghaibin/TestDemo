package top.tanghaibin.regex;

/**
 * Created by 唐海斌 on 2016/8/29.
 */
public class RegexDemo {


    public static void test(String regexStr,String regex){

        boolean b = regexStr.matches(regex);
        System.out.println(b);
    }

    public static void main(String [] args){
        String email = "tanghaibinhaohan@163.com";
        String phone = "";

        test(email,"^([a-z]+)");
    }
}
