package team.kc.experiment.study.spring.ioc;

import org.springframework.stereotype.Component;

@Component("aBean")
public class ComponentBean {
	public void doSomething () {
		System.out.println("Component doing...!");
	}
}
