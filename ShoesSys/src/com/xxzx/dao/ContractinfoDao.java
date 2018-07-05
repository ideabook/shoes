package com.xxzx.dao;

import java.util.List;

import com.xxzx.entity.Contractinfo;
import com.xxzx.entity.Userinfo;
import com.xxzx.util.Barbean;

public interface ContractinfoDao {

	void save(Contractinfo contractinfo);

	int findCount();

	List<Contractinfo> findByPage(int begin, int pageSize);

	List<Contractinfo> finalAllList();

	Contractinfo findById(Integer cid);

	void delete(Contractinfo contractinfo);

	void update(Contractinfo contractinfo);

	double findsum(String string);

	List<Contractinfo> findbyYear(String year);

	List<Contractinfo> findmodel(Contractinfo contractinfo);

	Contractinfo findmaxCno();

	List<Barbean> findcountByYear();

	List<Contractinfo> findall(Userinfo userinfo);



}
