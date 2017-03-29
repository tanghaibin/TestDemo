package top.tanghaibin.common;

/**
 * Created by 唐海斌 on 2016/8/25.
 */

import top.tanghaibin.cons.Constants;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.NumberFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class StringSdk {

    private static final String RANDOM_STR = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    private static final java.util.Random RANDOM = new java.util.Random();
    /**
     * 检查指定的字符串是否为空。
     * <ul>
     * <li>SysUtils.isEmpty(null) = true</li>
     * <li>SysUtils.isEmpty("") = true</li>
     * <li>SysUtils.isEmpty("   ") = true</li>
     * <li>SysUtils.isEmpty("abc") = false</li>
     * </ul>
     *
     * @param value
     *            待检查的字符串
     * @return true/false
     */
    public static boolean isEmpty(String value) {
        int strLen;
        if (value == null || (strLen = value.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if ((Character.isWhitespace(value.charAt(i)) == false)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 检查对象是否为数字型字符串,包含负数开头的。
     */
    public static boolean isNumeric(Object obj) {
        if (obj == null) {
            return false;
        }
        char[] chars = obj.toString().toCharArray();
        int length = chars.length;
        if (length < 1)
            return false;

        int i = 0;
        if (length > 1 && chars[0] == '-')
            i = 1;

        for (; i < length; i++) {
            if (!Character.isDigit(chars[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * 检查指定的字符串列表是否不为空。
     */
    public static boolean areNotEmpty(String... values) {
        boolean result = true;
        if (values == null || values.length == 0) {
            result = false;
        } else {
            for (String value : values) {
                result &= !isEmpty(value);
            }
        }
        return result;
    }

    /**
     * 把通用字符编码的字符串转化为汉字编码。
     */
    public static String unicodeToChinese(String unicode) {
        StringBuilder out = new StringBuilder();
        if (!isEmpty(unicode)) {
            for (int i = 0; i < unicode.length(); i++) {
                out.append(unicode.charAt(i));
            }
        }
        return out.toString();
    }

    public static String toUnderlineStyle(String name) {
        StringBuilder newName = new StringBuilder();
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            if (Character.isUpperCase(c)) {
                if (i > 0) {
                    newName.append("_");
                }
                newName.append(Character.toLowerCase(c));
            } else {
                newName.append(c);
            }
        }
        return newName.toString();
    }

    public static String convertString(byte[] data, int offset, int length) {
        if (data == null) {
            return null;
        } else {
            try {
                return new String(data, offset, length, Constants.CHARSET_UTF8);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static byte[] convertBytes(String data) {
        if (data == null) {
            return null;
        } else {
            try {
                return data.getBytes(Constants.CHARSET_UTF8);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static String numberFormater(int number,int length){
        NumberFormat formatter = NumberFormat.getNumberInstance();
        formatter.setMinimumIntegerDigits(length);
        formatter.setGroupingUsed(false);
        return formatter.format(number);
    }

    static final Pattern reUnicode = Pattern.compile("\\\\u([0-9a-zA-Z]{4})");

    public static String decode1(String s) {
        Matcher m = reUnicode.matcher(s);
        StringBuffer sb = new StringBuffer(s.length());
        while (m.find()) {
            m.appendReplacement(sb,
                    Character.toString((char) Integer.parseInt(m.group(1), 16)));
        }
        m.appendTail(sb);
        return sb.toString();
    }

    /**
     * 替换http参数信息
     * @param url
     * @param name
     * @param value
     * @return
     */
    public static String replaceHttpParams(String url, String name, String value) {
        if(null!=url && null!=value){
            url = url.replaceAll("(" + name +"=[^&]*)", name + "=" + value);
        }
        return url;
    }

    public static String replaceUrl(String url, String name, String value) {
        if(CommonSdk.isNotEmpty(url, name, value)) {
            int index = url.indexOf(name + "=");
            if(index != -1) {
                StringBuilder sb = new StringBuilder();
                sb.append(url.substring(0, index)).append(name + "=")
                        .append(value);
                int idx = url.indexOf("&", index);
                if(idx != -1) {
                    sb.append(url.substring(idx));
                }
                url = sb.toString();
            }
        }
        return url;
    }

    public static String readerStringFromStream(InputStream is) throws IOException {
        InputStreamReader isr =null;
        try{
            isr = new InputStreamReader(is, "utf-8");
            BufferedReader in = new BufferedReader(isr);
            StringBuffer sb = new StringBuffer();
            String line = "";
            while ((line = in.readLine()) != null) {
                sb.append(line);
            }
            return sb.toString();
        }finally{
            isr.close();
            is.close();
        }
    }

    /**
     * 获取随机字符串
     * @return
     */
    public static String getRandomStr() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            sb.append(RANDOM_STR.charAt(RANDOM.nextInt(RANDOM_STR.length())));
        }
        return sb.toString();
    }

    public static void main(String [] args) {
        System.out.println(getRandomStr());
        Long orderId = 336705614745047040l;
        System.out.println(String.valueOf(orderId));

        String url = "https://www.baidu.com";
        boolean result = url.matches("http:.*");
        String aa = url.replaceAll("http.*", "aa");
        System.out.println(aa);
    }

}