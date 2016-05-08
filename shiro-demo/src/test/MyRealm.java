import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;
import sun.java2d.pipe.SpanShapeRenderer;

/**
 * Created by Administrator on 2016/2/3.
 */
public class MyRealm implements Realm{

    @Override
    public String getName() {
        return "myRealm1";
    }

    /**
     * 是否支持某种验证方式
     * @param authenticationToken
     * @return
     */
    @Override
    public boolean supports(AuthenticationToken authenticationToken) {
        return authenticationToken instanceof UsernamePasswordToken;
    }

    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("第一个验证。。。。");
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken)authenticationToken;

        String username = usernamePasswordToken.getUsername();
        String password = new String(usernamePasswordToken.getPassword());

        if("tanghaibin".equals(username) && "admin".equals(password)){
            return new SimpleAuthenticationInfo(username,password,getName());
        }
        return null;
    }
}
