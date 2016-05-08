package top.tanghaibin.context;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.AuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Created by Administrator on 2016/2/16.
 */
public class ShiroRestFilter extends AuthenticationFilter {

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        Subject subject = getSubject(request,response);
        return subject.isAuthenticated();
    }

    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        if(getSubject(servletRequest,servletResponse).isAuthenticated()){
            return true;
        }else{
            servletResponse.setCharacterEncoding("gb2312");
            servletResponse.getWriter().write("{\"message\":\"登录超时\"}");
            return false;
        }
    }
}
