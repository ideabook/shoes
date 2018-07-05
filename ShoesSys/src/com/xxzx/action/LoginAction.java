package com.xxzx.action;

import java.util.Date;
import java.util.Map;

import javax.jms.Session;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.struts2.ServletActionContext;
import org.ly.uap.client.authentication.AttributePrincipal;
import org.ly.uap.client.validation.Assertion;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.xxzx.entity.LoginLog;
import com.xxzx.entity.Userinfo;
import com.xxzx.service.UserInfoService;
import com.xxzx.util.MyApplicationContextUtil;

public class LoginAction extends BaseAction implements ModelDriven<Userinfo> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(LoginAction.class);
	private String verifycode = "";
	private Userinfo userinfo = new Userinfo();
	private UserInfoService userInfoService;

	public void setUserInfoService(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}

	@Override
	public Userinfo getModel() {
		// TODO Auto-generated method stub
		return userinfo;
	}

	public String getVerifycode() {
		return verifycode;
	}

	public void setVerifycode(String verifycode) {
		this.verifycode = verifycode;
	}

	public String execute() {
		logger.info("-------execute-------------");
		ActionContext.getContext().put("url", "/index.jsp");
		return "url";
	}

	// 登陆
	// public String login() {
	// System.out.println("LOGIN执行了。。。");
	// Employee existEmployee = employeeService.login(employee);
	// if (existEmployee == null) {
	// // 登陆失败
	// this.addActionError("密码错误");
	// System.out.println();
	// return INPUT;
	// } else {
	// // 登陆成功
	// ActionContext.getContext().getSession()
	// .put("existEmployee", existEmployee);
	//
	// }
	// 单点登录方法
	public String login() {
		AttributePrincipal principal = (AttributePrincipal) ServletActionContext
				.getRequest().getUserPrincipal();
		String username = "";
		if (principal != null && principal.getName() != null) {
			username = principal.getName();
			if (!username.equals("") && username != null) {
				Userinfo userinfo = new Userinfo();
				userinfo.setUjobid(username);
				ActionContext.getContext().getSession().put("user", userinfo);

				return SUCCESS;
			} else
				return INPUT;
		} else {
			return INPUT;
		}

	}

	public String login3() throws Exception {
		logger.info("-------login3-------------");
		org.apache.shiro.subject.Subject subject = SecurityUtils.getSubject();
		if (subject.isAuthenticated()) {// 授权成功，直接去成功页面
			System.out.println("name00333:" + userinfo.getUname());
			return "success";
		} else if (userinfo != null) {
			UsernamePasswordToken token = new UsernamePasswordToken(
					userinfo.getUloginname(), userinfo.getUpassword());
			System.out.println("name00:" + userinfo.getUloginname());

			String error = null;
			try {
				logger.info("-------realm start-------------");
				subject.login(token);
				logger.info("-------realm  end-------------");
				Userinfo userinfo1 = getUserByUserName(token.getUsername());
				System.out.println("token:" + token.getUsername());
				ActionContext.getContext().getSession().put("user", userinfo1);
				System.out.println("name1:" + userinfo1.getUloginname());
				System.out.println("department"
						+ userinfo1.getDepartment().getDname());
				return "success";
			} catch (UnknownAccountException e) { // 用户名
				error = "用户认证失败：用户名错误";
			} catch (IncorrectCredentialsException e) { // 密码
				error = "用户认证失败：密码错误";
			} catch (LockedAccountException e) { // 密码
				error = "用户认证失败：账号被锁定";
			} catch (AuthenticationException e) {
				// 其他错误，比如锁定，如果想单独处理请单独catch处理
				error = "用户认证失败：其他错误" + e.getMessage();
			}
			ActionContext.getContext().put("msg", error);
		}
		ActionContext.getContext().put("url", "/index.jsp");
		return "success";

	}

	// 用户名、密码登录
	public String login2() {
		logger.info("-------login2-------------");
		Userinfo existUserinfo = userInfoService.login(userinfo);
		// -----注销验证码
		// String vcode = ActionContext.getContext().getSession()
		// .get("verifyCode").toString();
		//
		// //判断验证码
		// if (!verifycode.toLowerCase().equals(vcode)) {
		// this.addActionError("验证码错误");
		// return INPUT;
		// } else if (existUserinfo == null) {
		// this.addActionError("用户名密码错误");
		// return INPUT;
		// } else {
		// ActionContext.getContext().getSession().put("user", existUserinfo);
		// //记录IP地址
		// String lip= ServletActionContext.getRequest().getRemoteAddr();
		// LoginLog lg=new LoginLog();
		// lg.setUid(existUserinfo.getUid());
		// lg.setLip(lip);
		// lg.setLdate(new Date());
		// userInfoService.savelog(lg);
		// return SUCCESS;
		// }

		// ---------方便测试
		if (existUserinfo != null) {
			ActionContext.getContext().getSession().put("user", existUserinfo);
			// 记录IP地址
			String lip = ServletActionContext.getRequest().getRemoteAddr();
			LoginLog lg = new LoginLog();
			lg.setUid(existUserinfo.getUid());
			lg.setLip(lip);
			lg.setLdate(new Date());
			userInfoService.savelog(lg);
			System.out.println("登录成功");
			return SUCCESS;
		} else {
			this.addActionError("用户名密码错误");
			return INPUT;
		}
		// --------------end

	}

	/**
	 * 通过用户名获取用户
	 * 
	 * @param username
	 * @return
	 */
	// private Userinfo getUserByUserName(String username){
	//
	// String hql = "From Userinfo where uloginname = binary('" + username +
	// "')";
	//
	// return (Userinfo) baseService.findFirst(hql);
	// }
	private Userinfo getUserByUserName(String username) {
		logger.info("-------getusername-------------");
		System.out.println();
		Userinfo userinfo;
		userinfo = (Userinfo) ((UserInfoService) MyApplicationContextUtil
				.getContext().getBean("userInfoService"))
				.findbyloginname(username);

		//
		// System.out.println("login3 useinfo:" + userinfo.getUloginname());
		// System.out.println("login3 password:" + userinfo.getUpassword());

		return userinfo;
	}

	/**
	 * 后台首页
	 * 
	 * @return
	 */
	public String unauthor() {
		logger.info("-------unauthor-------------");
		ActionContext.getContext().put("url", "error/unauthor.jsp");
		return "url";
	}

	public String update() {
		userInfoService.update(userinfo);
		Map session = ActionContext.getContext().getSession();
		session.remove("user");
		return "input";
	}

	public String edit() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		userinfo = (Userinfo) session.get("user");
		return "edit";
	}

	public String find() {

		Userinfo userinfo = (Userinfo) ActionContext.getContext().getSession().get("user");
		System.out.println("name1:" + userinfo.getUname());
		System.out
				.println("department1:" + userinfo.getDepartment().getDname());
		ActionContext.getContext().put("users", userinfo);
		// System.out.println("name="+userinfo.getUname());
		return "find";
	}

	public String logout() throws Exception {

		logger.info("-------logout-------------");
		ActionContext.getContext().getSession().remove("user");
		ActionContext.getContext().getSession().clear();

		SecurityUtils.getSubject().logout();
		ActionContext.getContext().put("url", "/ssologin.jsp");
		ActionContext.getContext().put("msg", "安全退出！");
		return "input";
	}

}
