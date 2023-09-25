package com.ask.spring;


import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
@Configuration
public class SpringApplicationContext implements ApplicationContextAware{
	private static ApplicationContext CONTEXT ;
	
	@Override
	public void setApplicationContext(org.springframework.context.ApplicationContext context)
			throws BeansException {
		CONTEXT = context ;
		
	}
	
	public static Object getBean(String beanName) {
		return CONTEXT.getBean(beanName);
	}

	

	
}