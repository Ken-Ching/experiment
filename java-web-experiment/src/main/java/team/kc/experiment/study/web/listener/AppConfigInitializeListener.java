package team.kc.experiment.study.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class AppConfigInitializeListener implements ServletContextListener {

	//应用启动的时候被执行的方法
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("Application Configuration Initializing...");
		AppConfig.init();
	}

	//应用停止前销毁资源执行的方法
	public void contextDestroyed(ServletContextEvent sce) {
		//可以做一些关闭资源操作，例如关闭数据库连接等等
		System.out.println("Application Configuration Destroyed.");
	}

}
