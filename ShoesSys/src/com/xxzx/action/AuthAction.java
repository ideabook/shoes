package com.xxzx.action;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.xxzx.entity.Userinfo;

/**
 * 后台管理
 * @类名	AuthAction.java
 * @作者	cola
 * @Emial	xyn.java@foxmail.com
 * @QQ	939313737
 * @日期 2016-9-9
 * @版本 V 1.0
 */
public class AuthAction extends BaseAction{
	private static Logger logger = Logger.getLogger(AuthAction.class);
	private static final long serialVersionUID = 7888987779606060946L;
	private Userinfo user;
	
	/**
	 *用户退出
	 * @return
	 */
	public String logout(){
		logger.info("-------logout-------------");
		session.clear();
		SecurityUtils.getSubject().logout();
		ActionContext.getContext().put("url", "web/login.jsp");
		ActionContext.getContext().put("msg", "安全退出！");
		return "url";
	}
	
	/**
	 *用户详情
	 * @return
	 */
	public String info(){
		logger.info("-------info-------------");
		ActionContext.getContext().put("url","web/auth/info.jsp");
		return "url";
	}
	
	/**
	 * 去修改密码页面
	 * @return
	 */
	public String toPsw(){
		logger.info("-------toPsw-------------");
		ActionContext.getContext().put("url","web/auth/psw.jsp");
		return "url";
	}
	
	/**
	 * 修改密码
	 * @return
	 */
//	public String updatePsw(){
//		logger.info("-------updatePsw-------------");
//		Userinfo aUser = (Userinfo) session.get("user");
//		//DwzRender dwz = null;
//		if (aUser.getPassword().equals(user.getOld())){
//			// 旧密码对了，可以更新
//			aUser.setPassword(user.getPassword());
//			baseService.update(aUser);
//			dwz = DwzRender.success();
//			dwz.setCallbackType("closeCurrent");
//		} else {
//			// 旧密码错误，不能更新
//			dwz = DwzRender.error("旧密码错误");
//		}
//		ActionContext.getContext().put("msg",new Gson().toJson(dwz));
//		ActionContext.getContext().put("url","web/common/json.jsp");
//		return "url";
//	}
	// get set -----------------------TODO--------------------------------
	public Userinfo getUser() {
		return user;
	}
	public void setUser(Userinfo user) {
		this.user = user;
	}
}