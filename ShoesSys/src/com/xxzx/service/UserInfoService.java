package com.xxzx.service;

import com.xxzx.entity.LoginLog;
import com.xxzx.entity.Userinfo;

public interface UserInfoService {

	Userinfo login(Userinfo userinfo);

	void update(Userinfo userinfo);

	Userinfo findById(Integer uid);

	void savelog(LoginLog lg);

	Userinfo findbyloginname(String username);

}
