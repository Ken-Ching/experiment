package team.kc.experiment.study.spring.transaction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TransactionDemo {

	public static void main (String[] args) {
		ClassPathXmlApplicationContext context = 
			new ClassPathXmlApplicationContext(
				"classpath:team/kc/experiment/study/spring/transaction/applicationContext.xml");
		
		DemoServiceImp demoService = (DemoServiceImp) context.getBean("demoService");
		System.out.println( demoService.getData() );
		
		context.close();
	}
	
}
