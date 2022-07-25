package com.exam.cwttest.builder;

import com.exam.cwttest.to.MonetaryAmount;

public class MonetaryAmountBuilder {
    private String formattedValue;
    private String currencyCode;
    private Long value;
    private Integer numberOfDecimals;

    MonetaryAmountBuilder() {
    }

    public MonetaryAmountBuilder formattedValue(String formattedValue) {
        this.formattedValue = formattedValue;
        return this;
    }

    public MonetaryAmountBuilder currencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
        return this;
    }

    public MonetaryAmountBuilder value(Long value) {
        this.value = value;
        return this;
    }

    public MonetaryAmountBuilder numberOfDecimals(Integer numberOfDecimals) {
        this.numberOfDecimals = numberOfDecimals;
        return this;
    }

    public MonetaryAmount build() {
        return new MonetaryAmount(this.formattedValue, this.currencyCode, this.value, this.numberOfDecimals);
    }

    public String toString() {
        return "MonetaryAmount.MonetaryAmountBuilder(formattedValue=" + this.formattedValue + ", currencyCode=" + this.currencyCode + ", value=" + this.value + ", numberOfDecimals=" + this.numberOfDecimals + ")";
    }
}
