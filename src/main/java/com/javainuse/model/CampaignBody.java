package com.javainuse.model;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashMap;

public class CampaignBody implements Serializable {
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private BenefitType benefitType;
    @NotNull
    private Double benefitAmount;
    @NotNull
    private PaymentMethod paymentMethod;
    @NotNull
    private CampaignFilter campaignFilter;
    private Double limit;
    private HashMap<String, Object> parameters = new HashMap<>();

    public CampaignBody() {
    }

    public CampaignBody(Long id, String name, Double benefitAmount, PaymentMethod paymentMethod, CampaignFilter campaignFilter, Double limit) {
        this.id = id;
        this.name = name;
        this.benefitAmount = benefitAmount;
        this.paymentMethod = paymentMethod;
        this.campaignFilter = campaignFilter;
        this.limit = limit;
    }

    public CampaignBody(Long id, String name, Double benefitAmount, PaymentMethod paymentMethod, CampaignFilter campaignFilter, Double limit, HashMap<String, Object> parameters) {
        this.id = id;
        this.name = name;
        this.benefitAmount = benefitAmount;
        this.paymentMethod = paymentMethod;
        this.campaignFilter = campaignFilter;
        this.limit = limit;
        this.parameters = parameters;
    }

    public CampaignBody(Long id, String name, BenefitType benefitType, Double benefitAmount, PaymentMethod paymentMethod, CampaignFilter campaignFilter, Double limit, HashMap<String, Object> parameters) {
        this.id = id;
        this.name = name;
        this.benefitType = benefitType;
        this.benefitAmount = benefitAmount;
        this.paymentMethod = paymentMethod;
        this.campaignFilter = campaignFilter;
        this.limit = limit;
        this.parameters = parameters;
    }

    public BenefitType getBenefitType() {
        return benefitType;
    }

    public void setBenefitType(BenefitType benefitType) {
        this.benefitType = benefitType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBenefitAmount() {
        return benefitAmount;
    }

    public void setBenefitAmount(Double benefitAmount) {
        this.benefitAmount = benefitAmount;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public CampaignFilter getCampaignFilter() {
        return campaignFilter;
    }

    public void setCampaignFilter(CampaignFilter campaignFilter) {
        this.campaignFilter = campaignFilter;
    }

    public Double getLimit() {
        return limit;
    }

    public void setLimit(Double limit) {
        this.limit = limit;
    }

    public HashMap<String, Object> getParameters() {
        return parameters;
    }

    public void setParameters(HashMap<String, Object> parameters) {
        this.parameters = parameters;
    }

    @Override
    public String toString() {
        return "CampaignBody{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", benefitType=" + benefitType +
                ", benefitAmount=" + benefitAmount +
                ", paymentMethod=" + paymentMethod +
                ", campaignFilter=" + campaignFilter +
                ", limit=" + limit +
                ", parameters=" + parameters +
                '}';
    }
}