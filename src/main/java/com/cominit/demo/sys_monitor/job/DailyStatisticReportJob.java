package com.cominit.demo.sys_monitor.job;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.cominit.demo.sys_monitor.job.task.DailyStatisticReportTask;

public class DailyStatisticReportJob extends QuartzJobBean {
	private static final Logger LOGGER = Logger.getLogger(DailyStatisticReportJob.class);

	private DailyStatisticReportTask dailyStatisticReportTask;


	@Override
	protected void executeInternal(JobExecutionContext arg0)
			throws JobExecutionException {
		LOGGER.info("QUARTZ JOB DAILY STATISTIC REPORT STARTED...");
		dailyStatisticReportTask.run();
		LOGGER.info("QUARTZ JOB DAILY STATISTIC REPORT FINISHED...");
	}

	public void setDailyStatisticReportTask(DailyStatisticReportTask dailyStatisticReportTask) {
		this.dailyStatisticReportTask = dailyStatisticReportTask;
	}

}
