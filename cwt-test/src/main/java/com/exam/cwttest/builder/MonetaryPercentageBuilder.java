package com.exam.cwttest.builder;

import com.exam.cwttest.to.MonetaryAmount;
import com.exam.cwttest.to.MonetaryPercentage;

import java.math.BigDecimal;

public class MonetaryPercentageBuilder {
    private String code;
    private MonetaryAmount amount;
    private BigDecimal percentage;

    MonetaryPercentageBuilder() {
    }

    public MonetaryPercentageBuilder code(String code) {
        this.code = code;
        return this;
    }

    public MonetaryPercentageBuilder amount(MonetaryAmount amount) {
        this.amount = amount;
        return this;
    }

    public MonetaryPercentageBuilder percentage(BigDecimal percentage) {
        this.percentage = percentage;
        return this;
    }

    public MonetaryPercentage build() {
        return new MonetaryPercentage(this.code, this.amount, this.percentage);
    }

    public String toString() {
        return "MonetaryPercentage.MonetaryPercentageBuilder(code=" + this.code + ", amount=" + this.amount + ", percentage=" + this.percentage + ")";
    }
}
