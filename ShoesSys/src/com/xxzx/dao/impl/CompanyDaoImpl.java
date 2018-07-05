package com.xxzx.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xxzx.dao.CompanyDao;
import com.xxzx.entity.Companyinfo;
import com.xxzx.entity.Contractinfo;
import com.xxzx.entity.PageBean;

public class CompanyDaoImpl extends HibernateDaoSupport implements CompanyDao{

	@Override
	public void save(Companyinfo companyinfo) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(companyinfo);
	}

	@Override
	public List<Companyinfo> findAll() {
		// TODO Auto-generated method stub
		DetachedCriteria criteria = DetachedCriteria
				.forClass(Companyinfo.class);
		List<Companyinfo> list=this.getHibernateTemplate().findByCriteria(criteria);
		return list;
	}

	@Override
	public Companyinfo findById(int comid) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(Companyinfo.class,comid);
		
	}

	@Override
	public void delete(Companyinfo companyinfo) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(companyinfo);
	}

	@Override
	public void update(Companyinfo companyinfo) {
		// TODO Auto-generated method stub
	this.getHibernateTemplate().update(companyinfo);	
	}

}
