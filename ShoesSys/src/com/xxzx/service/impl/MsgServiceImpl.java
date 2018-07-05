package com.xxzx.service.impl;

import com.xxzx.dao.MsgDao;
import com.xxzx.service.MsgService;

public class MsgServiceImpl implements MsgService {
	private MsgDao msgDao;

	public MsgDao getMsgDao() {
		return msgDao;
	}

	public void setMsgDao(MsgDao msgDao) {
		this.msgDao = msgDao;
	}
}
