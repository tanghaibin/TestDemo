package top.tanghaibin.regex;

import java.util.regex.Pattern;

/**
 * Created by 唐海斌 on 2016/8/29.
 */
public class RegexDemo {


    public static void test(String regexStr,String regex){

        System.out.println(Pattern.matches(regex, regexStr));


    }

    public static void main(String [] args){
        String phone = "18682668023rf*";
        test(phone,"^[\\d]{11}.[\\D]{2}.*");
        String url = "www.baidu.com";
        test(url,"^[w]{3}.*[.]{1}.*[a-z]{5}.*[.]{1}.*[a-z]{3}");
        String name = "tanghaibin";
        test(name, "^[a-zA-Z0-9]{1,10}");
        String email = "tanghaibinhaohan@163.net";
        test(email, "^[a-zA-Z0-9]+.*[@]{1}.*[\\D\\d]{5}.*[com|cn|net]$");
    }
}
