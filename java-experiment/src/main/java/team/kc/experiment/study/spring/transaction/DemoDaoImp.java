package team.kc.experiment.study.spring.transaction;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component("demoDao")
public class DemoDaoImp {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Map<?,?> getData () {
		String sql = "select * from um_t_user u where u.userCode = 'admin4500'";
		return jdbcTemplate.queryForMap(sql);
	}
	
	public int addData(Map<?,?> data) {
		String sql = "insert ...";
		return jdbcTemplate.update(sql);
	}
	
	public int updateData(Map<?,?> data) {
		String sql = "update ...";
		return jdbcTemplate.update(sql);
	}
}
