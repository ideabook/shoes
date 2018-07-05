package com.xxzx.dao.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.sun.corba.se.spi.servicecontext.UEInfoServiceContext;
import com.xxzx.dao.ContractinfoDao;
import com.xxzx.entity.Contractinfo;
import com.xxzx.entity.Role;
import com.xxzx.entity.Userinfo;
import com.xxzx.util.Barbean;

public class ContractinfoDaoImpl extends HibernateDaoSupport implements
		ContractinfoDao {

	@Override
	public void save(Contractinfo contractinfo) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(contractinfo);
	}

	@Override
	public int findCount() {
		String str = "";
		String hql = null;
		if (str.equals("ccount")) {
			hql = "select sum(ccount) from Contractinfo";
		} else if (str.equals("cpaid")) {
			hql = "select sum(cpaid) from Contractinfo";

		} else if (str.equals("total")) {
			hql = "select count(*) from Contractinfo";

		} else {
			hql = "select count(*) from Contractinfo";
		}
		List<Long> list = this.getHibernateTemplate().find(hql);
		if (list.size() > 0) {
			System.out.println("count---" + list.get(0).intValue());
			return list.get(0).intValue();

		}
		// TODO Auto-generated method stub
		return 0;

	}

	@Override
	public List<Contractinfo> findByPage(int begin, int pageSize) {

		DetachedCriteria criteria = DetachedCriteria
				.forClass(Contractinfo.class);
		List<Contractinfo> list = this.getHibernateTemplate().findByCriteria(
				criteria);

		// TODO Auto-generated method stub
		return list;
		// TODO Auto-generated method stub
	}

	@Override
	public List<Contractinfo> finalAllList() {
		
		String hql = "from Contractinfo where 1=1";
		List<Contractinfo> list = this.getHibernateTemplate().find(hql);
		
//		DetachedCriteria criteria = DetachedCriteria
//				.forClass(Contractinfo.class);
//		List<Contractinfo> list = this.getHibernateTemplate().findByCriteria(
//				criteria);
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public Contractinfo findById(Integer cid) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(Contractinfo.class, cid);
	}

	@Override
	public void delete(Contractinfo contractinfo) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(contractinfo);
	}

	@Override
	public void update(Contractinfo contractinfo) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(contractinfo);
	}

	@Override
	public double findsum(String str) {

		String hql = null;
		if (str.equals("ccount")) {
			hql = "select sum(ccount) from Contractinfo";
			List<Long> list = this.getHibernateTemplate().find(hql);
			if (list.size() > 0) {
				Number number = list.get(0);
				if (number != null)
					return number.doubleValue();

			}
		} else if (str.equals("cpaid")) {
			hql = "select sum(cpaid) from Contractinfo";
			List<Long> list = this.getHibernateTemplate().find(hql);
			if (list.size() > 0) {

				Number number = list.get(0);
				if (number != null) {
					System.out.println("cpaid---" + number.toString());
					return number.doubleValue();
				} else {
					return 0;
				}
			}

		} else if (str.equals("total")) {
			hql = "select count(*) from Contractinfo";
			List<Long> list = this.getHibernateTemplate().find(hql);
			if (list.size() > 0) {
				System.out.println("count---" + list.get(0).intValue());
				return list.get(0).intValue();
			}
		} else {
			hql = "select count(*) from Contractinfo";
		}
		List<Long> list = this.getHibernateTemplate().find(hql);
		if (list.size() > 0) {
			System.out.println("count---" + list.get(0).intValue());
			return list.get(0).intValue();
		}
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Contractinfo> findbyYear(String year) {
		String yearstart = year + "-01-01 00:00:00";
		String yearend = year + "-12-31 23:59:59";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d2 = new Date();
		Date d1 = new Date();
		try {
			d1 = sdf.parse(yearstart);
			d2 = sdf.parse(yearend);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		System.out.println("start==" + yearstart);
//		System.out.println("end===" + yearend);
		String hql = "from Contractinfo where ctime between ? and ?";
		List<Contractinfo> list = this.getHibernateTemplate().find(hql, d1, d2);
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public List<Contractinfo> findmodel(Contractinfo contractinfo) {
		String hql = "from Contractinfo where 1=1";

		if (contractinfo.getCno() != null && !contractinfo.getCno().equals("")) {
			hql = hql + " and cno like '%" + contractinfo.getCno() + "%'";
		}
		if (contractinfo.getCname() != null
				&& !contractinfo.getCname().equals("")) {
			hql = hql + "and cname like '%" + contractinfo.getCname() + "%'";
		}
		if (contractinfo.getFundtype().getFid()!= null) {
			hql = hql + "and cpayfrom = " + contractinfo.getFundtype().getFid();
		}
		// TODO Auto-generated method stub
		System.out.println("hql====" + hql);
		List<Contractinfo> list = this.getHibernateTemplate().find(hql);
		return list;
	}

	@Override
	public Contractinfo findmaxCno() {
		String hql = "from Contractinfo order by cno";
		List<Contractinfo> list = this.getHibernateTemplate().find(hql);
		if (list.size() > 0)
			return list.get(list.size() - 1);
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Barbean> findcountByYear() {
		List<Barbean> barbeans = new ArrayList<Barbean>();
		
		String hql = "select year(ctime),sum(ccount),count(*) from Contractinfo group by year(ctime)";
		List<Object[]> list = this.getHibernateTemplate().find(hql);
		System.out.println("===" + list.size());
		for (int i = 0	; i < list.size(); i++) {
			Barbean barbean=new Barbean();
			if (list.get(i)[0] != null) {
			Integer year=(Integer)list.get(i)[0];
				barbean.setYear(String.valueOf(year));
			} else {
				barbean.setYear("");
			}
			if (list.get(i)[1] != null) {
				barbean.setSumcount((Double)list.get(i)[1]);
			} else {
				barbean.setSumcount(0.0);
			}
			if (list.get(i)[2] != null) {
				Number number = (Number) list.get(i)[2];
				barbean.setCount(number.intValue());
			} else {
				barbean.setCount(0);
			}
			barbeans.add(barbean);
		}
		// TODO Auto-generated method stub
		return barbeans;
	}

	@Override
	public List<Contractinfo> findall(Userinfo userinfo) {
		
		String rolevalue="";
		int count=1;
		for (Role role : userinfo.getRoles()) {
			System.out.println("角色" + role.getValue());
			if(role.getValue().equals("admin"))
			{
				rolevalue="admin";
				count+=100;
			}else if(role.getValue().equals("manage")){
				count+=10;
			}else if(role.getValue().equals("custom")){
				count+=1;
			}
		}
		String hql="";
		
		if(count>100)
		{
			hql="from Contractinfo where 1=1";
		}else if(count>10)
		{
			hql="from Contractinfo where crealuser in (select uid from Userinfo where departmentid="+userinfo.getDepartment().getDid()+")";
		}else {
			hql="from Contractinfo where crealuser="+userinfo.getUid()+"";
		}
		List<Contractinfo> list = this.getHibernateTemplate().find(hql);
		// TODO Auto-generated method stub
		return list;
	}

}
