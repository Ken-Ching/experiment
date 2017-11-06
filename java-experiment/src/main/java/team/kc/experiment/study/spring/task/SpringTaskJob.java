package team.kc.experiment.study.spring.task;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component("springTaskJob")
public class SpringTaskJob {

	@Scheduled(cron="0/10 * * * * ?")//每隔10秒触发任务
	public void run () {
		System.out.printf( "Job run at %tc. \n", new Date() );
	}
}
