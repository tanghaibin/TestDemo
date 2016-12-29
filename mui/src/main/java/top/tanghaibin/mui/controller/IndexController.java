package top.tanghaibin.mui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by tangh on 2016/11/12.
 */
@Controller
public class IndexController {


    @RequestMapping("main")
    public String main() {
        return "main";
    }
    @RequestMapping("content")
    public String getContent() {
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "content";
    }

    @RequestMapping("uploadPage")
    public String toUploadPage() {
        return "upload";
    }
    @RequestMapping("upload")
    public void upload(String base64) {
        System.out.println(base64);
    }
}
