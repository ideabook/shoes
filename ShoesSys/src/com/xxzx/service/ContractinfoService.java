package com.xxzx.service;

import java.util.List;

import com.xxzx.entity.Contractinfo;
import com.xxzx.entity.Fileinfo;
import com.xxzx.entity.PageBean;
import com.xxzx.entity.Userinfo;
import com.xxzx.util.Barbean;

public interface ContractinfoService {

	void save(Contractinfo contractinfo);

	PageBean<Contractinfo> findByPage(Integer currPage);

	List<Contractinfo> findAllList();

	Contractinfo findById(Integer cid);

	void delete(Contractinfo contractinfo);

	void update(Contractinfo contractinfo);

	int findtotal();

	double findsum(String string);

	List<Contractinfo> findByYear(String year);

	List<Contractinfo> findmodel(Contractinfo contractinfo);

	Contractinfo findmaxCno();

	List<Barbean> findcountByYear();

	List<Contractinfo> findall(Userinfo userinfo);


	

}
