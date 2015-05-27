package com.cominit.demo.sys_monitor.job.task;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.cominit.demo.sys_monitor.dto.Email;
import com.cominit.demo.sys_monitor.service.interfaces.IEmailService;

public class DailyStatisticReportTask {
	private static final Logger LOGGER = Logger.getLogger(DailyStatisticReportTask.class);

	@Autowired
	private IEmailService emailService;

	public void run() {
		try {

			Email email = emailService.generateDailyStatisticEmail(new Date().getTime());

			if (emailService.sendEmail(email)) {
				LOGGER.info("DAILY STATISTIC EMAIL SENT");
			} else {
				LOGGER.warn("ERROR OCCURRED WHEN SENDING THE DAILY STATISTIC EMAIL!!!");
			}
		} catch(Exception e) {
			LOGGER.error("DAILY STATISTIC TASK ERROR", e);
		}
	}
}
