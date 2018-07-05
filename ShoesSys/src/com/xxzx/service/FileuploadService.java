package com.xxzx.service;

import java.util.List;

import com.xxzx.entity.Fileinfo;

public interface FileuploadService {

	void saveFileinfo(Fileinfo fileinfo);

	List<Fileinfo> findFileinfoByCid(Integer cid);

}
