package com.xxzx.util;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.xxzx.entity.Userinfo;

public class PermissionInterceptor implements Interceptor{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("----拦截结束----------------");
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		System.out.println("拦截开始----------------");
	}

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		// TODO Auto-generated method stub
		String user="";
		Userinfo userinfo=(Userinfo) ActionContext.getContext().getSession().get("user");
		 
		if(userinfo==null)
		{
			System.out.println("非法---------");
			return "loginIndex";
		}

		return arg0.invoke();
	}



}
