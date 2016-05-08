import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Administrator on 2016/2/3.
 */
public class DemoTest {

    @Test
    public void testOne(){
        //通过ini文件构建安全管理器工厂
        //Factory<org.apache.shiro.mgt.SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        Factory<org.apache.shiro.mgt.SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        //通过工厂拿到安全管理器
        org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();
        //把安全管理器绑定到securityutils
        SecurityUtils.setSecurityManager(securityManager);
        //得到subject；即用户名/密码
        org.apache.shiro.subject.Subject subject = SecurityUtils.getSubject();
        //构建token
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("zhangsan","123");
        try {
            subject.login(usernamePasswordToken);
            System.out.println("登录成功...");
        }catch (AuthenticationException e){
            System.out.println("用户名密码错误！！");
        }
        Assert.assertEquals(true,subject.isAuthenticated());
    }

    @Test
    public void testTwo(){
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        //defaultSecurityManager.setRealm(new MyRealm());
        defaultSecurityManager.setRealm(new MyRealm());
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        org.apache.shiro.subject.Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("tanghaibin","admin");
        try {
            subject.login(usernamePasswordToken);
            System.out.println("登录成功...");
        }catch (AuthenticationException e){
            System.out.println("用户名密码错误！！");
        }
    }
}
