package org.fineract.mobilemoney.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tenant_transaction")
public class TenantTransaction extends CustomAbstractPersistable<Long> {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "account_type", nullable = false)
	private String accountType;
	
	@Column(name = "transaction_type", nullable = false)
	private String transactionType;
	
	@Column(name = "amount", nullable = false)
	private BigDecimal amount;
	
	@Column(name = "fineract_transaction_id", nullable = false)
	private String fineractTransactionId;
	
	@Column(name = "fineract_account_id", nullable = false)
	private String fineractAccountId;
	
	@Column(name = "fineract_client_id", nullable = false)
	private String fineractClientId;
	
	@Column(name = "description", nullable = true)
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "tenant_id", referencedColumnName = "id", nullable = false)
	private Tenant tenant;
	
	protected TenantTransaction(){
		
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getFineractTransactionId() {
		return fineractTransactionId;
	}

	public void setFineractTransactionId(String fineractTransactionId) {
		this.fineractTransactionId = fineractTransactionId;
	}

	public String getFineractAccountId() {
		return fineractAccountId;
	}

	public void setFineractAccountId(String fineractAccountId) {
		this.fineractAccountId = fineractAccountId;
	}

	public String getFineractClientId() {
		return fineractClientId;
	}

	public void setFineractClientId(String fineractClientId) {
		this.fineractClientId = fineractClientId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Tenant getTenant() {
		return tenant;
	}

	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
	}
}
