package team.kc.experiment.study.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.kc.experiment.study.web.listener.AppConfig;

//所有Servlet必须从HttpServlet派生
public class DemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//doGet()是这个Servlet的核心，真正处理请求的地方
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		//获取请求参数
		String name = (String) req.getParameter("name");
		
		//设置相应的类型为text/html
		resp.setContentType("text/html");

		//向客户端打印HTML文本
		PrintWriter pw = resp.getWriter();
		pw.println("<!DOCTYPE html>");
		pw.println("<head>");
		pw.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">");
		pw.println("<!-- The Servlet expression tags interpolate script variables into the HTML -->");
		pw.println("<title>Hello, world!</title>");
		pw.println("</head>");
		pw.println("<body bgcolor=#cc99dd>");
		pw.printf("<h1>Hello, world! I am %s !</h1>", name);
		pw.printf("<h1>Data source url: %s .</h1>", AppConfig.getDataSource().getUrl());
		pw.println("</body>");

		//关闭HttpServletResponse，使Web服务器知道相应结束
		pw.close();

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		super.doPost(req, resp);
	}

}
