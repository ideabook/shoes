package com.xxzx.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xxzx.dao.FileuploadDao;
import com.xxzx.entity.Fileinfo;

public class FileuploadDaoImpl extends HibernateDaoSupport implements FileuploadDao {

	@Override
	public void saveFileinfo(Fileinfo fileinfo) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(fileinfo);
	}

	@Override
	public List<Fileinfo> findFileinfoByCid(Integer cid) {
		
		String hql="from Fileinfo where 1=1";
				hql+=" and "+"cid='"+cid+"'" ;
		List<Fileinfo> list=this.getHibernateTemplate().find(hql);
		// TODO Auto-generated method stub
		return list;
	}

	
	
}
