package team.kc.experiment.study.spring.quartz;

import java.util.Date;

import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class QuartzDemoJob extends QuartzJobBean {

	protected void executeInternal(JobExecutionContext jobContext) 
			throws JobExecutionException {
		System.out.printf( "QuartzJobDemoBean executing at %tc \n", new Date() );
		
		//获取配置参数，对应配置jobDataAsMap（名字有差异，通过setJobDataAsMap处理）
		JobDataMap dataMap = jobContext.getJobDetail().getJobDataMap();
		System.out.print( "Data Map as below \n" );
		for (String key : dataMap.keySet()) {
			System.out.printf( "%s : %s \n", key, dataMap.get(key) );
		}
	}

}
