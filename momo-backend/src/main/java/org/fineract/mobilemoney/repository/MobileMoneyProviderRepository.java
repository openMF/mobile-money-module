package org.fineract.mobilemoney.repository;

import org.fineract.mobilemoney.domain.MobileMoneyProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MobileMoneyProviderRepository extends JpaRepository<MobileMoneyProvider, Long> {

}
