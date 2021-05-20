package com.woniu.config;

import com.woniu.domain.Perms;
import com.woniu.service.managerService.ManagerService;
import com.woniu.service.managerService.PermsService;
import com.woniu.utils.JwtTokenUtil;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class JwtRealm extends AuthorizingRealm {

    @Autowired
    private ManagerService managerService;

    @Autowired
    private PermsService permsService;

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {


        System.out.println(authenticationToken.getPrincipal());
        String token = authenticationToken.getPrincipal().toString();
        System.out.println(token);

        try {
            JwtTokenUtil.checkSign(token);
        }catch(Exception ex){
            System.out.println("jwt 解密失败。jwt 已过期，或被篡改。");
            throw new IncorrectCredentialsException(ex);
        }

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(token,token,this.getName());
        return info;
    }


    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        String token = principalCollection.getPrimaryPrincipal().toString();
        String username = JwtTokenUtil.getUserId(token);
        List<String> permsList = permsService.findPermsByUsername(username);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermissions(permsList);
        return info;
    }


}
