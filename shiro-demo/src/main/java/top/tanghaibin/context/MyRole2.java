package top.tanghaibin.context;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2016/2/4.
 */
public class MyRole2 extends AuthorizingRealm{

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        Set<String> set = new HashSet<String>();
        set.add("user:item");
        set.add("user:add");
        set.add("user:delete");
        set.add("user:edit");
        simpleAuthorizationInfo.addStringPermissions(set);
        return simpleAuthorizationInfo;
    }

    /**
     * 身份验证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        if("admin".equals(token.getUsername()) && "admin".equals(new String(token.getPassword()))) {
            return new SimpleAuthenticationInfo(token.getUsername(),token.getPassword(),getName());
        }
        return null;
    }
}
