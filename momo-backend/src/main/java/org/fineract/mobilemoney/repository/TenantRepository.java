package org.fineract.mobilemoney.repository;

import org.fineract.mobilemoney.domain.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TenantRepository extends JpaRepository<Tenant, Long> {

	Tenant findByTenantNameAndAppKey(String tenantName, String appKey);

	Tenant findByTenantName(String tenantName);

}
