package team.kc.experiment.study.spring.task;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTaskDemo {
	public static void main (String[] args) {
		ClassPathXmlApplicationContext context = 
			new ClassPathXmlApplicationContext(
				"classpath:team/kc/experiment/study/spring/task/applicationContext.xml");
			
		try {
			Thread.sleep(60000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		context.close();
	}
}
