/**
 *
 */
package com.cominit.demo.sys_monitor.service.interfaces;

import com.cominit.demo.sys_monitor.dto.Email;

public interface IEmailService {
	public boolean sendEmail(Email email);
	
	public Email generateDailyStatisticEmail(long timestamp);
}
