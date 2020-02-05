package org.mad.madapp;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;


@WebServlet(urlPatterns="/servlet",loadOnStartup=688 ,
initParams = 
{
		@WebInitParam(name="jingalala",value="ullala"),
		@WebInitParam(name="age",value="ullala")
})
public class LifeCycleServlet extends GenericServlet{
	
	public LifeCycleServlet() {
		System.out.println("Servlet object is created");
	}

	
	@Override
	public void init(ServletConfig config) throws ServletException{
		System.out.println("initializing the resources of LifeCycleServlet");
	}
	
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {     
	
		ServletConfig cong = getServletConfig();
		String name =cong.getInitParameter("jingalala");
		String age =cong.getInitParameter("age");
		
		System.out.println("service method is excuted");
		String appName = req.getParameter("appName");
		String appSize = req.getParameter("appSize");
		String appVersion = req.getParameter("version");

		ServletOutputStream outputStream = res.getOutputStream();
		outputStream.print("tq for visiting " +name + "  "+age);
		
	}
	
	
	@Override
	public void destroy() {
		System.out.println("close only the costly resourses");
	}
}