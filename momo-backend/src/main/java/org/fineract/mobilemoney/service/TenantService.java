package org.fineract.mobilemoney.service;

import org.fineract.mobilemoney.domain.Tenant;
import org.fineract.mobilemoney.repository.TenantRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TenantService {

	@Autowired
	private TenantRepository tenantRepository;

	@Autowired
	private SecurityService securityService;
	
	public String createTenant(final Tenant tenant) {
		tenant.setAppKey(this.securityService.generateApiKey(tenant.getTenantName()));
		this.tenantRepository.save(tenant);
		return tenant.getAppKey();
	}

	public Tenant findTenantByTenantNameAndAppKey(final String tenantName, final String appKey) {
		Tenant tenant = this.tenantRepository.findByTenantNameAndAppKey(tenantName, appKey);
		if (tenant == null) {
			System.out.println("Tenant not found");
		}
		return tenant;
	}

	public Tenant findTenantByTenantName(final String tenantName) {
		Tenant tenant = this.tenantRepository.findByTenantName(tenantName);
		//if (tenant == null) {
			//System.out.println("Tenant Not Found");
		//}
		return tenant;
	}
}
