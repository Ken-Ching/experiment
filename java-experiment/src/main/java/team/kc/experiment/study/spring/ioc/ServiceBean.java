package team.kc.experiment.study.spring.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("aService")
public class ServiceBean {
	
	//根据配置获取bean，或通过context.getBean("aBean")
	//或通过context.getBean(ComponentBean.class)
	@Autowired
	private ComponentBean aBean;
	
	public void doOtherthing () {
		System.out.println("Service doing...!");
		aBean.doSomething();
	}
	
}
