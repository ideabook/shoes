package com.xxzx.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import antlr.PythonCharFormatter;

import com.xxzx.dao.ContypeDao;
import com.xxzx.entity.Confrom;
import com.xxzx.entity.Contype;
import com.xxzx.entity.Fundtype;
import com.xxzx.entity.PageBean;
import com.xxzx.entity.Payinfo;
import com.xxzx.entity.Paymode;

public  class ContypeDaoImpl extends HibernateDaoSupport implements ContypeDao  {

	@Override
	public void save(Contype contype) {
		this.getHibernateTemplate().save(contype);
		
	}

	@Override
	public void saveconfrom(Confrom confrom) {
		this.getHibernateTemplate().save(confrom);
		
	}

	@Override
	public void savePayinfo(Payinfo payinfo) {
		this.getHibernateTemplate().save(payinfo);
//		Userinfo userinfo=new Userinfo();
//		userinfo.setUname(payinfo.getPoperator());
//		this.getHibernateTemplate().save(userinfo);
//		String hql = "select count(*) from Userinfo ";
//		List<Long> list = this.getHibernateTemplate().find(hql);
//		int count=0;
//		if (list.size() > 0) {
//			count=list.get(0).intValue();
//		}
//		System.out.println("count="+count);
	}

	@Override
	public List<Payinfo> findPayinfo() {
		
		DetachedCriteria criteria = DetachedCriteria
				.forClass(Payinfo.class);
		List<Payinfo> list=this.getHibernateTemplate().findByCriteria(criteria);
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public List<Confrom> findcontype() {
		
		DetachedCriteria criteria = DetachedCriteria
				.forClass(Confrom.class);
		List<Confrom> list=this.getHibernateTemplate().findByCriteria(criteria);
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public List<Contype> findall() {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(Contype.class);
		List<Contype> list=this.getHibernateTemplate().findByCriteria(criteria);
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public void delete(Contype contype) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(contype);
	}

	@Override
	public Contype findContypeById(Integer ctid) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(Contype.class,ctid);
	}

	@Override
	public void update(Contype contype) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(contype);
	}

	@Override
	public void deleteconfrom(Confrom confrom) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(confrom);
	}

	@Override
	public Confrom findConfromById(Integer cfid) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(Confrom.class, cfid);
	}

	@Override
	public void updateconfrom(Confrom confrom) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(confrom);
	}

	@Override
	public List<Confrom> findallconfrom() {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(Confrom.class);
		List<Confrom> list=this.getHibernateTemplate().findByCriteria(criteria);
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public void savefundtype(Fundtype fundtype) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(fundtype);
	}

	@Override
	public void deletefundtype(Fundtype fundtype) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(fundtype);
	}

	@Override
	public void updatefundtype(Fundtype fundtype) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(fundtype);
	}

	@Override
	public Fundtype findFundtypeById(Integer fid) {
		Fundtype fundtype=this.getHibernateTemplate().get(Fundtype.class,fid);
		// TODO Auto-generated method stub
		return fundtype;
	}

	@Override
	public List<Fundtype> findallfundtype() {
		
		DetachedCriteria detachedCriteria=DetachedCriteria.forClass(Fundtype.class);
		List<Fundtype> list=this.getHibernateTemplate().findByCriteria(detachedCriteria);
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public Payinfo findPayById(Integer pid) {
		// TODO Auto-generated method stub
		Payinfo payinfo=this.getHibernateTemplate().get(Payinfo.class, pid);
		return payinfo;
	}

	@Override
	public void deletepay(Payinfo payinfo) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(payinfo);
	}

	@Override
	public List<Payinfo> findPayByStr(String str, Integer cno) {
		// TODO Auto-generated method stub
		String hql = "from Payinfo where 1=1";
		 
		hql = hql + " and "+ str +"='"+cno+"'" ;
	 
		List<Payinfo> list=this.getHibernateTemplate().find(hql);
		return list;
	}

	@Override
	public PageBean<Paymode> findPaymode() {
		PageBean<Paymode> pageBean=new PageBean<Paymode>();
		DetachedCriteria detachedCriteria=DetachedCriteria.forClass(Paymode.class);
		List<Paymode> list=this.getHibernateTemplate().findByCriteria(detachedCriteria);
		pageBean.setList(list);
		// TODO Auto-generated method stub
		return pageBean;
	}

	@Override
	public void findpaymode(Paymode paymode) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(paymode);
	}

	@Override
	public Paymode findPaymodeById(Integer pmid) {
		// TODO Auto-generated method stub
		Paymode paymode=this.getHibernateTemplate().get(Paymode.class, pmid);
		return paymode;
	}

	@Override
	public void deletepaymode(Paymode paymode) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(paymode);
	}

	@Override
	public List<Paymode> findPaymodeBycid(Integer cid) {
		// TODO Auto-generated method stub
		String hql = "from Paymode where 1=1";
		 
		hql = hql + " and cid" +"='"+cid+"'" ;
		List<Paymode> list=this.getHibernateTemplate().find(hql);
		return list;
	}

	
}
