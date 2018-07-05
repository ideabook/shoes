package com.xxzx.dao;

import java.util.List;

import com.xxzx.entity.Confrom;
import com.xxzx.entity.Contype;
import com.xxzx.entity.Fundtype;
import com.xxzx.entity.PageBean;
import com.xxzx.entity.Payinfo;
import com.xxzx.entity.Paymode;

public interface ContypeDao {

	void save(Contype contype);

	void saveconfrom(Confrom confrom);

	void savePayinfo(Payinfo payinfo);

	List<Payinfo> findPayinfo();

	List<Confrom> findcontype();

	List<Contype> findall();

	void delete(Contype contype);

	Contype findContypeById(Integer ctid);

	void update(Contype contype);

	void deleteconfrom(Confrom confrom);

	Confrom findConfromById(Integer cfid);

	void updateconfrom(Confrom confrom);

	List<Confrom> findallconfrom();

	void savefundtype(Fundtype fundtype);

	void deletefundtype(Fundtype fundtype);
	
	void updatefundtype(Fundtype fundtype);

	Fundtype findFundtypeById(Integer fid);

	List<Fundtype> findallfundtype();

	Payinfo findPayById(Integer pid);

	void deletepay(Payinfo payinfo);

	List<Payinfo> findPayByStr(String str, Integer cno);

	PageBean<Paymode> findPaymode();

	void findpaymode(Paymode paymode);

	Paymode findPaymodeById(Integer pmid);

	void deletepaymode(Paymode paymode);

	List<Paymode> findPaymodeBycid(Integer cid);


}
