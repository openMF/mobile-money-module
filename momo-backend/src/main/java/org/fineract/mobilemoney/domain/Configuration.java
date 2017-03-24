package org.fineract.mobilemoney.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by daniel on 2/22/17.
 */
@Entity
@Table(name="configurations")
public class Configuration {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String displayName;

    @Column
    private String referenceId;

    @Column
    private Date dateCreated;

    @Column
    private String[] extraParams;

    @Column
    private String author;

    @Column
    private String originCountry;

    @Column
    private String networkName;

    @Column
    private String paymentUrl;

    @Column
    private String depositUrl;

    @Column(nullable = false)
    private Boolean active;

    public Configuration(String displayName, String referenceId, Date dateCreated, String[] extraParams, String author, String originCountry, String networkName, String paymentUrl, String depositUrl, Boolean active) {
        this.displayName = displayName;
        this.referenceId = referenceId;
        this.dateCreated = dateCreated;
        this.extraParams = extraParams;
        this.author = author;
        this.originCountry = originCountry;
        this.networkName = networkName;
        this.paymentUrl = paymentUrl;
        this.depositUrl = depositUrl;
        this.active = active;
    }

    // why?
    public Configuration() {}

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getPaymentUrl() {
        return paymentUrl;
    }

    public void setPaymentUrl(String paymentUrl) {
        this.paymentUrl = paymentUrl;
    }

    public String getDepositUrl() {
        return depositUrl;
    }

    public void setDepositUrl(String depositUrl) {
        this.depositUrl = depositUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String[] getExtraParams() {
        return extraParams;
    }

    public void setExtraParams(String[] extraParams) {
        this.extraParams = extraParams;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
    }

    public String getNetworkName() {
        return networkName;
    }

    public void setNetworkName(String networkName) {
        this.networkName = networkName;
    }
}
