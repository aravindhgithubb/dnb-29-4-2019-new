package com.dnb;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
@SpringBootApplication
@EnableAutoConfiguration

public class ServletInitializer extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	return application.sources(DnbServicesApplication.class);
	}
	/*
	     * JBoss EAP 6.2.0 and 6.3.0 mapping.
	     */
	    @Override
	    public void onStartup(ServletContext container) throws ServletException {
	        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
	        context.setConfigLocation(DnbServicesApplication.class.getName());
	        container.setInitParameter("dispatchOptionsRequest", "true");
	        Dynamic registration = container.addServlet("dispatcher", new DispatcherServlet(context));
	        registration.setLoadOnStartup(1);
	        registration.addMapping("/*"); // required JBoss EAP 6.2.0, 6.3.0
	        super.onStartup(container);
	    }
}
