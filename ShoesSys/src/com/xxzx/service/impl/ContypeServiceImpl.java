package com.xxzx.service.impl;

import java.util.List;

import com.xxzx.dao.ContypeDao;
import com.xxzx.entity.Confrom;
import com.xxzx.entity.Contype;
import com.xxzx.entity.Fundtype;
import com.xxzx.entity.PageBean;
import com.xxzx.entity.Payinfo;
import com.xxzx.entity.Paymode;
import com.xxzx.service.ContypeService;

public class ContypeServiceImpl implements ContypeService{
	
	private ContypeDao contypeDao;
	
	public ContypeDao getContypeDao() {
		return contypeDao;
	}

	public void setContypeDao(ContypeDao contypeDao) {
		this.contypeDao = contypeDao;
	}

	@Override
	public void save(Contype contype) {
		// TODO Auto-generated method stub
		contypeDao.save(contype);
	}

	@Override
	public void saveconfrom(Confrom confrom) {
		contypeDao.saveconfrom(confrom);
		
	}

	@Override
	public void savePayinfo(Payinfo payinfo) {
		contypeDao.savePayinfo(payinfo);
	}

	@Override
	public PageBean<Payinfo> findPayinfo() {
		PageBean<Payinfo> bean =new PageBean<Payinfo>(); 
		List<Payinfo> list=contypeDao.findPayinfo();
		bean.setList(list);
		// TODO Auto-generated method stub
		return bean;
	}

	@Override
	public List<Confrom> findcontype() {
		List<Confrom> list=contypeDao.findcontype();
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public PageBean<Contype> findByPage(Integer currPage) {
		List<Contype> list=contypeDao.findall();
		PageBean<Contype> pageBean=new PageBean<Contype>();
		pageBean.setList(list);
		// TODO Auto-generated method stub
		return pageBean;
	}

	@Override
	public Contype findContyeById(Integer ctid) {
		
		// TODO Auto-generated method stub
		return contypeDao.findContypeById(ctid);
	}

	@Override
	public void delete(Contype contype) {
		// TODO Auto-generated method stub
		contypeDao.delete(contype);
	}

	@Override
	public void update(Contype contype) {
		// TODO Auto-generated method stub
		contypeDao.update(contype);
		
	}

	@Override
	public PageBean<Confrom> findallconfrom() {
		PageBean<Confrom> pageBean=new PageBean<Confrom>();
		List<Confrom> list=contypeDao.findallconfrom();
		pageBean.setList(list);
		// TODO Auto-generated method stub
		return pageBean;
	}

	@Override
	public void updateconfrom(Confrom confrom) {
		// TODO Auto-generated method stub
		contypeDao.updateconfrom(confrom);
	}

	@Override
	public Confrom findConfromById(Integer cfid) {
		// TODO Auto-generated method stub
		return contypeDao.findConfromById(cfid);
	}

	@Override
	public void deleteconfrom(Confrom confrom) {
		// TODO Auto-generated method stub
		contypeDao.deleteconfrom(confrom);
		
	}

	@Override
	public PageBean<Fundtype> findallfundtype() {
		PageBean<Fundtype> pageBean=new PageBean<Fundtype>();
		List<Fundtype> list=contypeDao.findallfundtype();
		pageBean.setList(list);
		// TODO Auto-generated method stub
		return pageBean;
	}

	@Override
	public void updatefundtype(Fundtype fundtype) {
		// TODO Auto-generated method stub
		contypeDao.updatefundtype(fundtype);
	}

	@Override
	public Fundtype findFundtypeById(Integer fid) {
		// TODO Auto-generated method stub
		
		return contypeDao.findFundtypeById(fid);
	}

	@Override
	public void deletefundtype(Fundtype fundtype) {
		// TODO Auto-generated method stub
		contypeDao.deletefundtype(fundtype);
	}

	@Override
	public void savefundtype(Fundtype fundtype) {
		// TODO Auto-generated method stub
		contypeDao.savefundtype(fundtype);
		
	}

	@Override
	public List<Confrom> findalllistconfrom() {
		// TODO Auto-generated method stub
		return contypeDao.findallconfrom();
	}

	@Override
	public List<Contype> findalllistContype() {
		// TODO Auto-generated method stub
		return contypeDao.findall();
	}

	@Override
	public List<Fundtype> findfundlist() {
		// TODO Auto-generated method stub
		return contypeDao.findallfundtype();
	}

	@Override
	public Payinfo findPayById(Integer pid) {
		// TODO Auto-generated method stub
		return contypeDao.findPayById(pid);
	}

	@Override
	public void deletepay(Payinfo payinfo) {
		// TODO Auto-generated method stub
		contypeDao.deletepay(payinfo);
	}

	@Override
	public List<Payinfo> findPayByCid(String str, Integer cno) {
		// TODO Auto-generated method stub
		return contypeDao.findPayByStr(str,cno);
	}

	@Override
	public PageBean<Paymode> findPayode() {
		// TODO Auto-generated method stub
		return contypeDao.findPaymode();
	}

	@Override
	public void savePaymode(Paymode paymode) {
		// TODO Auto-generated method stub
		contypeDao.findpaymode(paymode);
		
	}

	@Override
	public Paymode findPaymodeById(Integer pmid) {
		// TODO Auto-generated method stub
		return contypeDao.findPaymodeById(pmid);
	}

	@Override
	public void deletepaymode(Paymode paymode) {
		// TODO Auto-generated method stub
		contypeDao.deletepaymode(paymode);
	}

	@Override
	public List<Paymode> findPayModeByCid(Integer cid) {
		// TODO Auto-generated method stub
		return contypeDao.findPaymodeBycid(cid);
	}

}
