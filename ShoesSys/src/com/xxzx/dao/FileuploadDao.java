package com.xxzx.dao;

import java.util.List;

import com.xxzx.entity.Fileinfo;

public interface FileuploadDao {

	void saveFileinfo(Fileinfo fileinfo);

	List<Fileinfo> findFileinfoByCid(Integer cid);

}
