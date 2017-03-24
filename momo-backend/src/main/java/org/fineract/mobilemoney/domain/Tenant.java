package org.fineract.mobilemoney.domain;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tenant")
public class Tenant extends CustomAbstractPersistable<Long>{
	
	private static final long serialVersionUID = 3L;

	@Column(name = "name", nullable = false)
	private String tenantName;
	
	@Column(name = "mobile_money_number", nullable = false)
	private String mobileMoneyNumber;
	
	@Column(name = "app_key", nullable = false)
	private String appKey;
	
	@Column(name = "description", nullable = true)
	private String description;
	
	@ManyToMany(mappedBy = "tenants", fetch = FetchType.EAGER)
	private Collection<MobileMoneyProvider> mobileMoneyProvider;
	
	@OneToMany(mappedBy = "tenant", orphanRemoval = true, cascade = CascadeType.ALL)
	private Collection<TenantTransaction> tenantTransactions;
	
	protected Tenant() {
		
	}
	
	public Tenant(final String name, final String mobileNumber, final String appKey, final String description){
		this.tenantName = name;
		this.mobileMoneyNumber = mobileNumber;
		this.appKey = appKey;
		this.description = description;
	}

	public String getTenantName() {
		return tenantName;
	}

	public void setTenantName(String tenantName) {
		this.tenantName = tenantName;
	}

	public String getMobileMoneyNumber() {
		return mobileMoneyNumber;
	}

	public void setMobileMoneyNumber(String mobileMoneyNumber) {
		this.mobileMoneyNumber = mobileMoneyNumber;
	}

	public String getAppKey() {
		return appKey;
	}

	public void setAppKey(String appkey) {
		this.appKey = appkey;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Collection<MobileMoneyProvider> getMobileMoneyProvider() {
		return mobileMoneyProvider;
	}

	public void setMobileMoneyProvider(Collection<MobileMoneyProvider> mobileMoneyProvider) {
		this.mobileMoneyProvider = mobileMoneyProvider;
	}

	public Collection<TenantTransaction> getTenantTransactions() {
		return tenantTransactions;
	}

	public void setTenantTransactions(Collection<TenantTransaction> tenantTransactions) {
		this.tenantTransactions = tenantTransactions;
	}
}
