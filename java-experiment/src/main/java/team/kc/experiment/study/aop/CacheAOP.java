package team.kc.experiment.study.aop;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component//如果不加Component注解，拦截不会生效
public class CacheAOP {
	Map<String, Object> cache = new HashMap<String, Object>();
	
	@Before("execution(* team.kc.experiment.study.aop.QueryService.*(..))")
	public void before(JoinPoint jp) {
		System.out.println("----------aop before tip----------");
	}

	@After("execution(* team.kc.experiment.study.aop.QueryService.*(..))")
	public void after(JoinPoint jp) {
		System.out.println("----------aop after tip----------");
	}
	
	@Around("execution(* team.kc.experiment.study.aop.QueryService.*(..))")
	public Object around (ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("around point cut start");
		//pjp.proceed();
		System.out.println("around point cut end");
		return "point cut";
	}
	
	@Around("@annotation(team.kc.experiment.study.aop.CacheMethod)")
	public Object queryFromCache (ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("annotation(CacheMethod) point cut start");
		pjp.proceed();
		System.out.println("annotation(CacheMethod) point cut end");
		return "point cut";
	}
	
}
