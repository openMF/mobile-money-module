package org.fineract.mobilemoney.service;

import java.util.Collection;

import org.fineract.mobilemoney.domain.Configuration;

/**
 * Created by daniel on 2/22/17.
 */
public interface ConfigurationService {

    Collection<Configuration> findAll();

    Configuration findOne(Long id);

    Configuration create(Configuration configuration);

    Configuration update(Configuration configuration);
}
