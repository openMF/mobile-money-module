package org.fineract.mobilemoney.configuration;

import org.fineract.mobilemoney.domain.CustomAbstractPersistable;
import org.fineract.mobilemoney.domain.MobileMoneyProvider;
import org.fineract.mobilemoney.domain.MobileMoneyProviderConfig;
import org.fineract.mobilemoney.domain.Tenant;
import org.fineract.mobilemoney.domain.TenantTransaction;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SuppressWarnings("deprecation")
@Configuration
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = {
        "org.fineract.mobilemoney.repository",		
})
@EntityScan(basePackageClasses = {
		CustomAbstractPersistable.class,
        MobileMoneyProvider.class,
        MobileMoneyProviderConfig.class,
        TenantTransaction.class,
        Tenant.class
})
@ComponentScan(basePackages = {
        "org.fineract.mobilemoney.*"
})
public class MobileMoneyConfiguration {

    public MobileMoneyConfiguration() {
        super();
    }

    @Bean
    public SimpleApplicationEventMulticaster applicationEventMulticaster() {
        final SimpleApplicationEventMulticaster multicaster = new SimpleApplicationEventMulticaster();
        multicaster.setTaskExecutor(new SimpleAsyncTaskExecutor());
        return multicaster;
    }
}