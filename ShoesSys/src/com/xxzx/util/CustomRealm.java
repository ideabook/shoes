package com.xxzx.util;

import org.apache.log4j.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.opensymphony.xwork2.ActionContext;
import com.xxzx.entity.Role;
import com.xxzx.entity.Userinfo;
import com.xxzx.service.BaseService;
import com.xxzx.service.UserInfoService;

/**
 * 自定义Realm
 * @author CatScan
 * @param <T>
 */
//public class CustomRealm extends AuthorizingRealm {
//	private BaseService<Object> baseService;
//	private static Logger logger = Logger.getLogger(CustomRealm.class);
//	public BaseService<Object> getBaseService() {
//		return baseService;
//	}
//
//	public void setBaseService(BaseService<Object> baseService) {
//		this.baseService = baseService;
//	}
//
//	final String realmName = "customRealm";
//
//	// 设置realmName
//	@Override
//	public void setName(String name) {
//		super.setName(realmName);
//	}
//
//	// 用于登陆认证
//	@Override
//	protected AuthenticationInfo doGetAuthenticationInfo(
//			AuthenticationToken authcToken) throws AuthenticationException {
//		  logger.info("-------认证-------------");
//		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
//		System.out.println("输出："+token.getUsername());
//		Userinfo user = getByUserName(token.getUsername());
//        if(user != null ) {
//            return new SimpleAuthenticationInfo(user.getUloginname(), user.getUpassword(), getName());
//        } else {
//            return null;
//        }
//	}
//
//	// 用于权限认证
//	@Override
//	protected AuthorizationInfo doGetAuthorizationInfo(
//			PrincipalCollection principals) {
//		 //获取登录时输入的用户名  
//        String username = (String) principals.fromRealm(getName()).iterator().next();  
//        logger.info("-------username-------------"+username);
//        Userinfo user = getByUserName(username);
//        System.out.println("user:"+user.getUloginname());
//		if(user != null ) {
//            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//            for(Role role : user.getRoles() ) {
//                info.addRole(role.getValue());
////                System.out.println(role.getUsers());
//                System.out.println("角色值："+role.getValue());
//            }
//            System.out.println("permission:"+info.getStringPermissions());
//            return info;
//        } else {
//            return null;
//        }
//		
//	}

/**
 * 自定义Realm
 * 
 * @author CatScan
 * @param <T>
 */
public class CustomRealm extends AuthorizingRealm {
	private BaseService<Object> baseService;
	private static Logger logger = Logger.getLogger(CustomRealm.class);

	public BaseService<Object> getBaseService() {
		return baseService;
	}

	public void setBaseService(BaseService<Object> baseService) {
		this.baseService = baseService;
	}

	final String realmName = "customRealm";

	// 设置realmName
	@Override
	public void setName(String name) {
		super.setName(realmName);
	}

	// 用于登陆认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authcToken) throws AuthenticationException {
		logger.info("-------登陆认证-------------");
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		Userinfo user = getByUserName(token.getUsername());
		if (user != null) {
			logger.info("-------登陆认证-------not null------");
			System.out.println("角色个数："+user.getRoles().size());
			return new SimpleAuthenticationInfo(user.getUloginname(),
					user.getUpassword(), getName());
		} else {
			return null;
		}
	}

	// // 用于权限认证
	// @Override
	// protected AuthorizationInfo doGetAuthorizationInfo(
	// PrincipalCollection principals) {
	// //获取登录时输入的用户名
	// String username = (String)
	// principals.fromRealm(getName()).iterator().next();
	//
	// User user = getByUserName(username);
	// if(user != null ) {
	// SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
	// for(Role role : user.getRoles() ) {
	// info.addRole(role.getValue());
	// }
	// return info;
	// } else {
	// return null;
	// }
	// }
	//
	// 用于权限认证
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		
		//获取登录时输入的用户名  
      String username = (String) principals.fromRealm(getName()).iterator().next();  
      logger.info("-------权限认证-------------");
      Userinfo user = getByUserName(username);
      logger.info("-------权限认证--------username-----"+user.getUloginname());
		if(user != null ) {
          SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
          for(Role role : user.getRoles() ) {
              info.addRole(role.getValue());
              System.out.println("权限认证角色："+role.getValue());
             
          }
          return info;
      } else 
      {
          return null;
      }
		
		
		// 获取登录时输入的用户名
//		logger.info("-------权限认证-------------");
//		String username = (String) principals.fromRealm(getName()).iterator()
//				.next();
//		logger.info("-------username-------------" + username);
//		Userinfo user = getByUserName(username);
//		System.out.println("权限认证user:" + user.getUloginname());
//		if (user != null) {
//			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//			for (Role role : user.getRoles()) {
//				info.addRole(role.getValue());
//				// System.out.println(role.getUsers());
//				System.out.println("角色值：" + role.getValue());
//			}
//			System.out.println("permission:" + info.getStringPermissions());
//			return info;
//		} else {
//			return null;
//		}

	}

	/**
	 * 通过用户名获取用户
	 * 
	 * @param username
	 * @return
	 */
	private Userinfo getByUserName(String username) {
		logger.info("-------getusername-------------");
		Userinfo userinfo;
		userinfo = (Userinfo) ((UserInfoService) MyApplicationContextUtil
				.getContext().getBean("userInfoService"))
				.findbyloginname(username);

		//
		System.out.println("useinfo:" + userinfo.getUloginname());
		System.out.println("password:" + userinfo.getUpassword());

		return userinfo;
	}
}