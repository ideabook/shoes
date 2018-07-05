package com.xxzx.action;

import com.opensymphony.xwork2.ActionSupport;
import com.xxzx.entity.Contractinfo;
import com.xxzx.service.MsgService;

public class MsgAction extends ActionSupport {
	private Contractinfo contractinfo;
	private MsgService msgService;
	public Contractinfo getContractinfo() {
		return contractinfo;
	}
	public void setContractinfo(Contractinfo contractinfo) {
		this.contractinfo = contractinfo;
	}
	public MsgService getMsgService() {
		return msgService;
	}
	public void setMsgService(MsgService msgService) {
		this.msgService = msgService;
	}
	
}
