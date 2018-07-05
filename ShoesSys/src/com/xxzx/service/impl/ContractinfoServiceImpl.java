package com.xxzx.service.impl;

import java.util.List;

import com.xxzx.dao.ContractinfoDao;
import com.xxzx.entity.Contractinfo;
import com.xxzx.entity.Fileinfo;
import com.xxzx.entity.PageBean;
import com.xxzx.entity.Userinfo;
import com.xxzx.service.ContractinfoService;
import com.xxzx.util.Barbean;

public class ContractinfoServiceImpl implements ContractinfoService {

	private ContractinfoDao contractinfoDao;

	public void setContractinfoDao(ContractinfoDao contractinfoDao) {
		this.contractinfoDao = contractinfoDao;
	}

	@Override
	public void save(Contractinfo contractinfo) {
		// TODO Auto-generated method stub
		contractinfoDao.save(contractinfo);
	}

	@Override
	public PageBean<Contractinfo> findByPage(Integer currPage) {

		PageBean<Contractinfo> pageBean = new PageBean<Contractinfo>();
		pageBean.setCurrPage(currPage);
		int pageSize = 100;
		pageBean.setPageSize(pageSize);
		int totalCount = contractinfoDao.findCount();
		pageBean.setTotalCount(totalCount);
		// 封装总页数
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());
		// 封装每页数据
		int begin = (currPage - 1) * pageSize;
		List<Contractinfo> list = contractinfoDao.findByPage(begin, pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public List<Contractinfo> findAllList() {
		
		List<Contractinfo> list=contractinfoDao.finalAllList();
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public Contractinfo findById(Integer cid) {
		Contractinfo contractinfo=contractinfoDao.findById(cid);
		return contractinfo;
	}

	@Override
	public void delete(Contractinfo contractinfo) {
		// TODO Auto-generated method stub
		contractinfoDao.delete(contractinfo);
	}

	@Override
	public void update(Contractinfo contractinfo) {
		// TODO Auto-generated method stub
		contractinfoDao.update(contractinfo);
	}

	@Override
	public int findtotal() {
		
		// TODO Auto-generated method stub
		return contractinfoDao.findCount();
	}

	@Override
	public double findsum(String string) {
		// TODO Auto-generated method stub
		return contractinfoDao.findsum(string);
	}

	@Override
	public List<Contractinfo> findByYear(String year) {
		// TODO Auto-generated method stub
		return contractinfoDao.findbyYear(year);
	}

	@Override
	public List<Contractinfo> findmodel(Contractinfo contractinfo) {
		// TODO Auto-generated method stub
		return contractinfoDao.findmodel(contractinfo);
	}

	@Override
	public Contractinfo findmaxCno() {
		// TODO Auto-generated method stub
		return contractinfoDao.findmaxCno();
	}

	@Override
	public List<Barbean> findcountByYear() {
		// TODO Auto-generated method stub
		return contractinfoDao.findcountByYear();
	}

	@Override
	public List<Contractinfo> findall(Userinfo userinfo) {
		// TODO Auto-generated method stub
		return contractinfoDao.findall(userinfo);
	}





}
