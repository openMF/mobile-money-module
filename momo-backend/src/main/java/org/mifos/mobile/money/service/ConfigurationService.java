package org.mifos.mobile.money.service;

import org.mifos.mobile.money.domain.Configuration;

import java.util.Collection;

/**
 * Created by daniel on 2/22/17.
 */
public interface ConfigurationService {

    Collection<Configuration> findAll();

    Configuration findOne(Long id);

    Configuration create(Configuration configuration);

    Configuration update(Configuration configuration);
}
