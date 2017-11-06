package team.kc.experiment.study.spring.quartz;

import org.springframework.stereotype.Component;

@Component("methodInvokingJobDemo")
public class MethodInvokingJob {

	public void run () {
		System.out.println("Method invoking job running...");
	}
	
}
