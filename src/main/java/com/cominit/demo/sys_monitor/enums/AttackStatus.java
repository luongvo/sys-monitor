package com.cominit.demo.sys_monitor.enums;

public enum AttackStatus {
	BLOCKED("BLOCKED"),NOT_BLOCKED("NOT_BLOCKED"); 
	
	AttackStatus(String type) {
		this.type = type;
	}
	
	private String type;
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
