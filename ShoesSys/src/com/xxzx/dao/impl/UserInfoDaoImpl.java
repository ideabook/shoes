package com.xxzx.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xxzx.dao.UserInfoDao;
import com.xxzx.entity.Contractinfo;
import com.xxzx.entity.LoginLog;
import com.xxzx.entity.Userinfo;

public class UserInfoDaoImpl extends HibernateDaoSupport implements UserInfoDao {

	

	@Override
	public Userinfo login(Userinfo userinfo) {
		String hql="from Userinfo where uloginname=? and upassword= ? ";
		System.out.println("loginname:"+userinfo.getUloginname());
		System.out.println("password:"+userinfo.getUpassword());
		List<Userinfo> list=this.getHibernateTemplate().find(hql,userinfo.getUloginname(),userinfo.getUpassword());
		if (list.size()>0) {
			
			return list.get(0);
			
		}
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Userinfo userinfo) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(userinfo);
	}

	@Override
	public Userinfo findById(Integer uid) {
		// TODO Auto-generated method stub
		
		return this.getHibernateTemplate().get(Userinfo.class, uid);
	}

	@Override
	public void savelog(LoginLog lg) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(lg);
	}

	@Override
	public Userinfo findbyloginname(String username) {
		// TODO Auto-generated method stub
		String hql="from Userinfo where uloginname=?";
		
		List<Userinfo> list=this.getHibernateTemplate().find(hql,username);
		if (list.size()>0) {
			
			return list.get(0);
			
		}
		return null;
	}

}
