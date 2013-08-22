package br.com.controle.mes.util;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class SchedulerJob implements Job {

	@Override
	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		System.out.println("JSF 2 + Quartz 2 example");

	}

}
