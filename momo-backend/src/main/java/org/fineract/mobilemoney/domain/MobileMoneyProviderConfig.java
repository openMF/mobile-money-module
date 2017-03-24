package org.fineract.mobilemoney.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "operator_configuration")
public class MobileMoneyProviderConfig extends CustomAbstractPersistable<Long> {

	private static final long serialVersionUID = 2L;
	
	@Column(name = "config_name", nullable = false)
	private String configName;
	
	@Column(name = "config_value", nullable = false)
	private String configValue;
	
	@ManyToOne
	@JoinColumn(name = "mobile_money_operator_id", nullable = false)
	private MobileMoneyProvider mobileMoneyProvider;
	
	protected MobileMoneyProviderConfig(){
		
	}
	
	public MobileMoneyProviderConfig(String configName, String configValue, MobileMoneyProvider mobileMoneyProvider){
		this.configName = configName;
		this.configValue = configValue;
		this.mobileMoneyProvider = mobileMoneyProvider;
	}

	public String getConfigName() {
		return configName;
	}

	public void setConfigName(String configName) {
		this.configName = configName;
	}

	public String getConfigValue() {
		return configValue;
	}

	public void setConfigValue(String configValue) {
		this.configValue = configValue;
	}

	public MobileMoneyProvider getMobileMoneyProvider() {
		return mobileMoneyProvider;
	}

	public void setMobileMoneyProvider(MobileMoneyProvider mobileMoneyProvider) {
		this.mobileMoneyProvider = mobileMoneyProvider;
	}
	
}
