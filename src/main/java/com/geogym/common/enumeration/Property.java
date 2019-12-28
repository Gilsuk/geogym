package com.geogym.common.enumeration;

import java.io.IOException;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;

public enum Property {
	
	SENDGRID_API_KEY("sendgrid.api_key");
	
	private String value;

	Property(String key) {
		ConfigurableApplicationContext ctx = new GenericXmlApplicationContext();
		ConfigurableEnvironment env = ctx.getEnvironment(); 
		MutablePropertySources propertySources = env.getPropertySources();
		try {
			propertySources.addLast(new ResourcePropertySource("classpath:geogym.properties"));
			this.value = env.getProperty(key);
		} catch (IOException e) {
			this.value = "NONE";
		} finally {
			if (ctx != null) ctx.close();
		}
	}
	
	@Override
	public String toString() {
		return this.value;
	}
	public String getValue() {
		return this.value;
	}

}
