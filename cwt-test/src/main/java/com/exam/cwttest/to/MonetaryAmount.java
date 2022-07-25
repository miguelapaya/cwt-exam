package com.exam.cwttest.to;

import java.beans.ConstructorProperties;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(
        name = "monetaryAmount"
)
@XmlAccessorType(XmlAccessType.FIELD)
public class MonetaryAmount implements Serializable {
    private static final long serialVersionUID = 6498027380354019510L;
    private String formattedValue;
    private String currencyCode;
    private Long value;
    private Integer numberOfDecimals;

    public static MonetaryAmount.MonetaryAmountBuilder builder() {
        return new MonetaryAmount.MonetaryAmountBuilder();
    }

    @ConstructorProperties({"formattedValue", "currencyCode", "value", "numberOfDecimals"})
    public MonetaryAmount(String formattedValue, String currencyCode, Long value, Integer numberOfDecimals) {
        this.formattedValue = formattedValue;
        this.currencyCode = currencyCode;
        this.value = value;
        this.numberOfDecimals = numberOfDecimals;
    }

    public MonetaryAmount() {
    }

    public String getFormattedValue() {
        return this.formattedValue;
    }

    public String getCurrencyCode() {
        return this.currencyCode;
    }

    public Long getValue() {
        return this.value;
    }

    public Integer getNumberOfDecimals() {
        return this.numberOfDecimals;
    }

    public void setFormattedValue(String formattedValue) {
        this.formattedValue = formattedValue;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public void setNumberOfDecimals(Integer numberOfDecimals) {
        this.numberOfDecimals = numberOfDecimals;
    }

    public static class MonetaryAmountBuilder {
        private String formattedValue;
        private String currencyCode;
        private Long value;
        private Integer numberOfDecimals;

        MonetaryAmountBuilder() {
        }

        public MonetaryAmount.MonetaryAmountBuilder formattedValue(String formattedValue) {
            this.formattedValue = formattedValue;
            return this;
        }

        public MonetaryAmount.MonetaryAmountBuilder currencyCode(String currencyCode) {
            this.currencyCode = currencyCode;
            return this;
        }

        public MonetaryAmount.MonetaryAmountBuilder value(Long value) {
            this.value = value;
            return this;
        }

        public MonetaryAmount.MonetaryAmountBuilder numberOfDecimals(Integer numberOfDecimals) {
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
}
