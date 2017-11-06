package team.kc.experiment.study.spring.ioc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIOCDemo {
	
	public static void main (String[] args) {
		ClassPathXmlApplicationContext context = 
			new ClassPathXmlApplicationContext(
				"classpath:team/kc/experiment/study/spring/ioc/applicationContext.xml");
		
		//根据bean name获取bean
		ServiceBean aService = (ServiceBean) context.getBean("aService");
		aService.doOtherthing();
		
		//根据class获取bean
		ServiceBean bService = (ServiceBean) context.getBean(ServiceBean.class);
		bService.doOtherthing();
		
		//new不会初始化@Autowired注解的对象,aBean不会被初始化
		ServiceBean cService = new ServiceBean();
		cService.doOtherthing();
		
		context.close();
	}
}
