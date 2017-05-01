package org.fineract.mobilemoney.service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.UUID;

import org.fineract.mobilemoney.domain.Tenant;
import org.fineract.mobilemoney.repository.TenantRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author awasum
 *
 */
@Service
public class SecurityService {

	private static final Logger logger = LoggerFactory.getLogger(SecurityService.class);

	@Autowired
	private TenantService tenantService;

	public Tenant authenticate(final String tenantName, final String appKey) {
		Tenant tenant = this.tenantService.findTenantByTenantNameAndAppKey(tenantName, appKey);
		return tenant;
	}

	public String generateApiKey(final String tenantName) {
		Tenant tenant = this.tenantService.findTenantByTenantName(tenantName);
		if (tenant != null) {

			System.out.println("Tenant Already Exists Exception");
		}

		final String randomKey = UUID.randomUUID().toString();
		String restApiKey = null;
		try {
			restApiKey = URLEncoder.encode(randomKey, "UTF-8");
		} catch (final UnsupportedEncodingException e) {
			logger.error("API Key generation error..., reason,", e);
		}
		return restApiKey;
	}
}