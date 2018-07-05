package com.xxzx.service.impl;

import com.xxzx.dao.UserInfoDao;
import com.xxzx.entity.LoginLog;
import com.xxzx.entity.Userinfo;
import com.xxzx.service.UserInfoService;

public class UserInfoServiceImpl implements UserInfoService {

	private UserInfoDao userInfoDao;
	
	public UserInfoDao getUserInfoDao() {
		return userInfoDao;
	}

	public void setUserInfoDao(UserInfoDao userInfoDao) {
		this.userInfoDao = userInfoDao;
	}

	@Override
	public Userinfo login(Userinfo userinfo) {
		
		Userinfo exitusUserinfo=userInfoDao.login(userinfo);
		// TODO Auto-generated method stub
		return exitusUserinfo;
	}

	@Override
	public void update(Userinfo userinfo) {
		// TODO Auto-generated method stub
		userInfoDao.update(userinfo);
	}

	@Override
	public Userinfo findById(Integer uid) {
		// TODO Auto-generated method stub
		return userInfoDao.findById(uid);
	}

	@Override
	public void savelog(LoginLog lg) {
		// TODO Auto-generated method stub
		userInfoDao.savelog(lg);
	}

	@Override
	public Userinfo findbyloginname(String username) {
		// TODO Auto-generated method stub
		return userInfoDao.findbyloginname(username);
	}

}
