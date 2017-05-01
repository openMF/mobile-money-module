package org.fineract.mobilemoney.repository;

import org.fineract.mobilemoney.domain.TenantTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TenantTransactionRepository extends JpaRepository<TenantTransaction, Long> {

}
