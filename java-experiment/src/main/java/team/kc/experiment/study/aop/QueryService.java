package team.kc.experiment.study.aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service("queryService")
public class QueryService {

	@CacheMethod
	public String query (String param) {
		System.out.println("querying");
		return "Query result for " + param;
	}
	
	public static void main (String[] args) {
		ClassPathXmlApplicationContext context = null;
		try {
			context = new ClassPathXmlApplicationContext("classpath:team/kc/experiment/study/aop/applicationContext-aop.xml");
			QueryService queryService = (QueryService) context.getBean("queryService");
			System.out.println( queryService.query("param1") );
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			context.close();
		}
	}
	
}
