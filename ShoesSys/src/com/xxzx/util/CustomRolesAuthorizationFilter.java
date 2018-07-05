package com.xxzx.util;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;
  
/**
 * AuthorizationFilter抽象类事项了javax.servlet.Filter接口，它是个过滤器。  
 * @类名	CustomRolesAuthorizationFilter.java
 * @作者	cola
 * @Emial	xyn.java@foxmail.com
 * @QQ	939313737
 * @日期 2016-9-9
 * @版本 V 1.0
 */
public class CustomRolesAuthorizationFilter extends AuthorizationFilter {  
  
    @Override  
    protected boolean isAccessAllowed(ServletRequest req, ServletResponse resp, Object mappedValue) throws Exception {  
        Subject subject = getSubject(req, resp);  
        String[] rolesArray = (String[]) mappedValue;  
  
        if (rolesArray == null || rolesArray.length == 0) { //没有角色限制，有权限访问  
            return true;  
        }  
        for (int i = 0; i < rolesArray.length; i++) { 
        	System.out.println("role:"+rolesArray[i]);
        	System.out.println("subject:"+subject.getPrincipal());
            if (subject.hasRole(rolesArray[i])) { //若当前用户是rolesArray中的任何一个，则有权限访问  
                return true;  
            }  
        }  
        return false;  
    }  
}