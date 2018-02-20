package com.nttdata.fhir.config;

import javax.servlet.Filter;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;



public class AppConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
	 
    @Override
    protected Class<?>[] getRootConfigClasses() {
        
    	return new Class[] { ServiceConfig.class, WebSecurityIISConfig.class };
    }
  
    @Override
	protected Class<?>[] getServletConfigClasses() {
		
		return new Class<?>[]{WebMvcConfig.class};
		
	}
  
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
    
    @Override
    protected Filter[] getServletFilters() {
    	Filter [] singleton = { new CORSFilter() };
    	return singleton;
	}
 
}