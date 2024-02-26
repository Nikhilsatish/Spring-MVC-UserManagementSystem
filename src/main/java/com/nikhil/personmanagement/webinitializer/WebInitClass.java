package com.nikhil.personmanagement.webinitializer;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.nikhil.personmanagement.configuration.ConfigClass;

public class WebInitClass extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { ConfigClass.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

}
