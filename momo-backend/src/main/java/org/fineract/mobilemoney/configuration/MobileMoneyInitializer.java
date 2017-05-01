package org.fineract.mobilemoney.configuration;

import org.fineract.mobilemoney.MobileMoneyBridge;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

public class MobileMoneyInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(MobileMoneyBridge.class);
	}

}
