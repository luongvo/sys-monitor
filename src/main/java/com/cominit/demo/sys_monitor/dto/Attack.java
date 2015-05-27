package com.cominit.demo.sys_monitor.dto;

import com.cominit.demo.sys_monitor.enums.AttackStatus;

public class Attack {
	private String ip;
	private AttackStatus status;
	
	public Attack(String ip, AttackStatus status) {
		super();
		this.ip = ip;
		this.status = status;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public AttackStatus getStatus() {
		return status;
	}
	public void setStatus(AttackStatus status) {
		this.status = status;
	}

}
