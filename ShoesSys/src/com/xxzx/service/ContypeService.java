package com.xxzx.service;

import java.util.List;

import com.xxzx.entity.Confrom;
import com.xxzx.entity.Contype;
import com.xxzx.entity.Fundtype;
import com.xxzx.entity.PageBean;
import com.xxzx.entity.Payinfo;
import com.xxzx.entity.Paymode;

public interface ContypeService {

	void save(Contype contype);

	void saveconfrom(Confrom confrom);

	void savePayinfo(Payinfo payinfo);

	PageBean<Payinfo> findPayinfo();

	List<Confrom> findcontype();

	PageBean<Contype> findByPage(Integer currPage);

	Contype findContyeById(Integer ctid);

	void delete(Contype contype);

	void update(Contype contype);

	PageBean<Confrom> findallconfrom();

	void updateconfrom(Confrom confrom);

	Confrom findConfromById(Integer cfid);

	void deleteconfrom(Confrom confrom);

	PageBean<Fundtype> findallfundtype();

	void updatefundtype(Fundtype fundtype);

	Fundtype findFundtypeById(Integer fid);

	void deletefundtype(Fundtype fundtype);

	void savefundtype(Fundtype fundtype);

	List<Confrom> findalllistconfrom();

	List<Contype> findalllistContype();

	List<Fundtype> findfundlist();

	Payinfo findPayById(Integer pid);

	void deletepay(Payinfo payinfo);

	List<Payinfo> findPayByCid(String str, Integer integer);

	PageBean<Paymode> findPayode();

	void savePaymode(Paymode paymode);

	Paymode findPaymodeById(Integer pmid);

	void deletepaymode(Paymode paymode);

	List<Paymode> findPayModeByCid(Integer cid);

}
