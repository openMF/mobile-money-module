package org.fineract.mobilemoney.repository;

import org.fineract.mobilemoney.domain.MobileMoneyProviderConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MobileMoneyProviderConfigRepository extends JpaRepository<MobileMoneyProviderConfig, Long> {

}
