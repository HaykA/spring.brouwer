package be.brouwers.web;

import javax.servlet.Filter;

import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import be.brouwers.dao.CreateDAOBeans;
import be.brouwers.datasource.CreateDataSourceBean;
import be.brouwers.restclients.CreateRestClientBeans;
import be.brouwers.restservices.CreateRestControllerBeans;
import be.brouwers.services.CreateServiceBeans;

public class Initializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] { CreateDataSourceBean.class,
			CreateDAOBeans.class, CreateServiceBeans.class,
			CreateRestClientBeans.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { CreateControllerBeans.class,
			CreateRestControllerBeans.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}
	
	@Override
	protected Filter[] getServletFilters() {
		return new Filter[] { new CharacterEncodingFilter("UTF-8"),
				new OpenEntityManagerInViewFilter() };
	}

}