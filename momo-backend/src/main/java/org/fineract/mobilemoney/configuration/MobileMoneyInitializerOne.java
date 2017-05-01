package org.fineract.mobilemoney.configuration;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

public class MobileMoneyInitializerOne extends SpringBootServletInitializer {
	
	public MobileMoneyInitializerOne(){
		super();
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
		return application.sources(MobileMoneyConfiguration.class);
	}

}
