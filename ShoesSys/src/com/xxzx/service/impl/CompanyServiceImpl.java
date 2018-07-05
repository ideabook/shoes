package com.xxzx.service.impl;

import java.util.List;

import com.xxzx.dao.CompanyDao;
import com.xxzx.entity.Companyinfo;
import com.xxzx.entity.PageBean;
import com.xxzx.service.CompanyService;

public class CompanyServiceImpl  implements CompanyService{

	private CompanyDao companyDao;
	
	public void setCompanyDao(CompanyDao companyDao) {
		this.companyDao = companyDao;
	}

	@Override
	public void save(Companyinfo companyinfo) {
		// TODO Auto-generated method stub
		companyDao.save(companyinfo);
	}

	@Override
	public PageBean<Companyinfo> findAll() {
		List<Companyinfo> list=companyDao.findAll();
		PageBean<Companyinfo> pageBean=new PageBean<Companyinfo>();
		pageBean.setList(list);
		// TODO Auto-generated method stub
		return pageBean;
	}

	@Override
	public List<Companyinfo> findalllist() {
		// TODO Auto-generated method stub
		return companyDao.findAll();
	}

	@Override
	public Companyinfo findById(int comid) {
		// TODO Auto-generated method stub
		return companyDao.findById(comid);
	}

	@Override
	public void update(Companyinfo companyinfo) {
		// TODO Auto-generated method stub
		companyDao.update(companyinfo);
	}

	@Override
	public void delete(Companyinfo companyinfo) {
		// TODO Auto-generated method stub
		companyDao.delete(companyinfo);
	}

}
