package team.kc.experiment.study.web.listener;

import org.apache.commons.dbcp.BasicDataSource;

public class AppConfig {

	private static BasicDataSource dataSource;
	
	public static BasicDataSource getDataSource () {
		return dataSource;
	}
	
	public static synchronized void init () {
		initDataSource();
		
		//还可以有其他初始化
	}
	
	/** 初始化数据源，简单例子Hard Code，也可能是从配置文件获取  */
	private static void initDataSource () {
		dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.jdbc.Driver");   
        dataSource.setUrl("jdbc:mysqlocalhost:3306/");   
        dataSource.setUsername("root");     
        dataSource.setPassword("root");     
        dataSource.setMaxActive(10);//最大连接数     
        dataSource.setMaxIdle(5);//最大管理数
	}
	
}
