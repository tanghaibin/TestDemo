package top.tanghaibin.mui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

/**
 * Created by tangh on 2016/11/12.
 */
@Controller
public class IndexController {

private static int count = 0;
    @RequestMapping("main")
    public String main() {
        return "main";
    }
    @RequestMapping("content")
    public String getContent(HttpServletRequest httpServletRequest) {
        String contextPath = httpServletRequest.getContextPath() + "/order/detal";
        String basePath = httpServletRequest.getScheme() + "://"+ httpServletRequest.getServerName() + ":" + httpServletRequest.getServerPort()+ contextPath;
        return "content";
    }
    @RequestMapping("image")
    public String image() {
        return "image";
    }

    @RequestMapping("ajaxUpload")
    public String toUploadPage() {
        return "ajaxUpload";
    }

    @RequestMapping("upload")
    public void upload(String base64) {
        System.out.println(base64);
    }


    @RequestMapping("httpClient")
    public void httpClient(MultipartFile file, String name, String lick) throws UnsupportedEncodingException {
        System.out.println(lick);
    }
}
