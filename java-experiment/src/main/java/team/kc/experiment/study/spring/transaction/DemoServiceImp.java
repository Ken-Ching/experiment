package team.kc.experiment.study.spring.transaction;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("demoService")
public class DemoServiceImp {
	@Autowired
	private DemoDaoImp demoDao;
	
	//get*方法，只读事务
	public Map<?,?> getData () {
		return demoDao.getData();
	}
	
	//update*方法，支持一般事务
	public void updateData () {
		Map<String, Object> param = new HashMap<String, Object>();
		demoDao.addData(param);
		demoDao.updateData(param);//若此方法抛异常，前面的addData也会回滚
	}
}
