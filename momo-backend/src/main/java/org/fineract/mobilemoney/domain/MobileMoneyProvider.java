package org.fineract.mobilemoney.domain;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "mobile_money_operator")
public class MobileMoneyProvider extends CustomAbstractPersistable<Long> {
	
	private static final long serialVersionUID = 4L;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "country", nullable = false)
	private String country;
	
	@Column(name = "country_code", nullable = false)
	private Integer countryCode;
	
	@Column(name = "description", nullable = true)
	private String description;
	
	@Column(name = "created_on", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn;
	
	@Column(name = "last_modified_on", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastModifiedOn;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "tenant_mobile_money_operator",
		joinColumns = @JoinColumn(name = "tenant_id", referencedColumnName = "id"),
		inverseJoinColumns = @JoinColumn(name = "mobile_money_operator_id", referencedColumnName = "id")
			)
	private Collection<Tenant> tenants;
	
	@OneToMany(mappedBy = "mobileMoneyProvider", orphanRemoval = true, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Collection<MobileMoneyProviderConfig> mobileMoneyProviderConfig;

	public MobileMoneyProvider() {
		super();
	}

	public MobileMoneyProvider(String name, String country, Integer countryCode, String description, Date createdOn,
			Date lastModifiedOn) {
		super();
		this.name = name;
		this.country = country;
		this.countryCode = countryCode;
		this.description = description;
		this.createdOn = createdOn;
		this.lastModifiedOn = lastModifiedOn;
	}

	public MobileMoneyProvider(String name, String country, Integer countryCode, Date createdOn) {
		super();
		this.name = name;
		this.country = country;
		this.countryCode = countryCode;
		this.createdOn = createdOn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Integer getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(Integer countryCode) {
		this.countryCode = countryCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getLastModifiedOn() {
		return lastModifiedOn;
	}

	public void setLastModifiedOn(Date lastModifiedOn) {
		this.lastModifiedOn = lastModifiedOn;
	}
	
	

}
