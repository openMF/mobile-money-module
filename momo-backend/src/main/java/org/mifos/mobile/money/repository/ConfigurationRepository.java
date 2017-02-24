package org.mifos.mobile.money.repository;

import org.mifos.mobile.money.domain.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by daniel on 2/22/17.
 */
@Repository
public interface ConfigurationRepository extends JpaRepository<Configuration, Long> {

    Configuration findByActive(@Param(value="active") Boolean active);
}
