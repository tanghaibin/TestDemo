package top.tanghaibin.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 唐海斌 on 2016/8/30.
 */
public class SessionServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String host = req.getLocalAddr();
        resp.getOutputStream().write((host + ":"+ req.getSession().getId()).getBytes());
    }
}
