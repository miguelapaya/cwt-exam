package com.exam.cwttest.to;

import com.exam.cwttest.model.from.AccountingLineXYZ;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

//@XmlRootElement(name = "accountingLine")
//@XmlAccessorType(XmlAccessType.FIELD)
//Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
//@Getter
//@Setter
@Data
@Entity
public class AccountingLine implements Serializable
{
    private static final long serialVersionUID = 8768848284389900534L;

    @Id
    @NotNull(message = "ID cannot be blank!")
    private String accountingLineID;

    @NotNull(message = "AccountingLineStatus cannot be blank!")
    private AccountingLineStatus accountingLineStatus;

    @NotNull(message = "VendorCode cannot be null or blank!")
    private String accountingVendorCode;

    //@NotNull(message = "AirLineCode cannot be null or blank!")
    private String airlineCode;

    @NotNull(message = "ChargeCategoryCode cannot be null or blank!")
    private String chargeCategoryCode;

    private String formattedReceiptNumber;

    @NotNull(message = "InvoiceNumber cannot be null or blank!")
    private String invoiceNumber;

  //  @NotNull(message = "LinkCode cannot be null or blank!")
    private String linkCode;

 //   @NotNull(message = "NumberOfConjuctedDocuments cannot be null or blank!")
    private String numberOfConjunctedDocuments;

  //  @NotNull(message = "OriginalTicketNumber cannot be null or blank!")
    private String originalTicketNumber;

  //  @NotNull(message = "ReceiptNumber cannot be null or blank!")
    private String receiptNumber;

    @ElementCollection
    private List<String> segmentRefIDList = new ArrayList<>();

    private String travelerName;

    @ElementCollection
    private List<String> travelerRefIDList = new ArrayList<>();

  //  @NotNull(message = "typeIndicator cannot be null or blank!")
    private String typeIndicator;

  //  @NotNull(message = "ElementNumber cannot be null or blank!")
    private String elementNumber;

 //   @NotNull(message = "fareApplication cannot be null or blank!")
    private String fareApplication;

    private MonetaryAmount baseFare;

    private MonetaryAmount taxAmount;

    private MonetaryAmount totalTaxAmount;

    private MonetaryAmount totalTaxSurcharge;

    private MonetaryAmount gstAmount;

    private String gstCode;

    private MonetaryAmount qstAmount;

    private String qstCode;

    private MonetaryPercentage commission;

    private String freeFormText;

    /*public AccountingLine(AccountingLineXYZ accountingLineXYZ){
        this.accountingLineID = accountingLineXYZ.getId();
        this.accountingLineStatus = AccountingLineStatus.ACTIVE;
        this.accountingVendorCode = accountingLineXYZ.getAccountingVendorCode();
        this.chargeCategoryCode = accountingLineXYZ.getChargeCategoryCoded();
        this.invoiceNumber = accountingLineXYZ.getOriginalInvoice();
        this.linkCode = accountingLineXYZ.getLinkCode();
        this.numberOfConjunctedDocuments = accountingLineXYZ.getNumberOfConjunctedDocuments();
        this.originalTicketNumber = accountingLineXYZ.getOriginalTicketNumber();
        this.receiptNumber = accountingLineXYZ.getDocumentNumber();
        this.segmentRefIDList.add(accountingLineXYZ.getSegmentNumber());
        this.travelerName = accountingLineXYZ.getPassengerName();
        this.travelerRefIDList.add("1");
        this.typeIndicator = accountingLineXYZ.getTypeIndicator();
        this.elementNumber = String.valueOf(accountingLineXYZ.getIndex());
        this.fareApplication = accountingLineXYZ.getFareApplication();

        //Monetary Amount Details
        MonetaryAmount monetaryAmount = new MonetaryAmount();
        monetaryAmount.setValue((long)Double.parseDouble(accountingLineXYZ.getBaseFare()));
        monetaryAmount.setFormattedValue(accountingLineXYZ.getBaseFare());
        monetaryAmount.setCurrencyCode(accountingLineXYZ.getCurrencyCode());
        monetaryAmount.setNumberOfDecimals(accountingLineXYZ
                .getBaseFare().length() - accountingLineXYZ.getBaseFare()
                .lastIndexOf('.'));


        this.baseFare = monetaryAmount;
        this.taxAmount = new MonetaryAmount(accountingLineXYZ.getTaxAmount(),
                accountingLineXYZ.getCurrencyCode(),
                ((long)Double.parseDouble(accountingLineXYZ.getTaxAmount())),
        accountingLineXYZ.getTaxAmount().length() -accountingLineXYZ.getTaxAmount()
                .lastIndexOf('.') - 1);

        this.gstAmount = new MonetaryAmount(accountingLineXYZ.getGstAmount(),
                accountingLineXYZ.getCurrencyCode(),
                Long.valueOf(accountingLineXYZ.getGstAmount()),
                accountingLineXYZ.getGstAmount().length() - accountingLineXYZ.getGstAmount()
                        .lastIndexOf('.') - 1);
        this.gstCode = accountingLineXYZ.getGstCode();
        this.qstAmount = new MonetaryAmount(accountingLineXYZ.getQstAmount(),
                accountingLineXYZ.getCurrencyCode(),
                Long.valueOf(accountingLineXYZ.getQstAmount()),
                accountingLineXYZ.getQstAmount().length() - accountingLineXYZ.getQstAmount()
                        .lastIndexOf('.') -1);
        this.qstCode = accountingLineXYZ.getQstCode();

        //Monetary Percentage Details
        MonetaryPercentage monetaryPercentage = new MonetaryPercentage();

        monetaryPercentage.setPercentage(BigDecimal.valueOf(Double.parseDouble(accountingLineXYZ.getCommissionPercentage())));
        monetaryPercentage.setAmount(new MonetaryAmount(accountingLineXYZ.getCommissionAmount(),
                accountingLineXYZ.getCurrencyCode(),
                ((long)Double.parseDouble(accountingLineXYZ.getCommissionAmount())),
                accountingLineXYZ.getCommissionAmount().length() - accountingLineXYZ.getCommissionAmount()
                        .lastIndexOf('.')-1));
        this.commission = monetaryPercentage;

        this.freeFormText = getFreeFormText();

        //Monetary Amount for TaxSurCharge
        MonetaryAmount newTotalTaxSurcharge = new MonetaryAmount();
        newTotalTaxSurcharge.setFormattedValue(String.valueOf(Long.valueOf(accountingLineXYZ.getGstAmount() + Long.valueOf(accountingLineXYZ.getQstAmount()))));
        newTotalTaxSurcharge.setValue((long)(Double.parseDouble(accountingLineXYZ.getGstAmount()) + Double.parseDouble(accountingLineXYZ.getQstAmount())));
        newTotalTaxSurcharge.setNumberOfDecimals(accountingLineXYZ.getTaxAmount().length() - accountingLineXYZ.getTaxAmount().lastIndexOf('.')-1);
        newTotalTaxSurcharge.setCurrencyCode(accountingLineXYZ.getCurrencyCode());
        this.totalTaxSurcharge = newTotalTaxSurcharge;

        this.totalTaxAmount = new MonetaryAmount(String.valueOf(this.taxAmount.getValue() + this.totalTaxSurcharge.getValue()),
                accountingLineXYZ.getCurrencyCode(),
                (this.taxAmount.getValue() + this.totalTaxSurcharge.getValue()),
                accountingLineXYZ.getTaxAmount().length() - accountingLineXYZ.getTaxAmount().lastIndexOf('.')-1);

    }*/

    /*public AccountingLineXYZ build(){
        AccountingLineXYZ accountingLineXYZ = new AccountingLineXYZ();

        accountingLineXYZ.setId(accountingLineID);
        this.accountingLineStatus = AccountingLineStatus.ACTIVE;
        accountingLineXYZ.setAccountingVendorCode(accountingVendorCode);
        accountingLineXYZ.setChargeCategoryCoded(chargeCategoryCode);
        accountingLineXYZ.setOriginalInvoice(invoiceNumber);
        accountingLineXYZ.setLinkCode(linkCode);
        accountingLineXYZ.setNumberOfConjunctedDocuments(numberOfConjunctedDocuments);
        accountingLineXYZ.setOriginalTicketNumber(originalTicketNumber);
        accountingLineXYZ.setDocumentNumber(receiptNumber);
        this.segmentRefIDList.add(accountingLineXYZ.getSegmentNumber());
        accountingLineXYZ.setPassengerName(travelerName);
        this.travelerRefIDList.add("1");
        accountingLineXYZ.setTypeIndicator(typeIndicator);
        this.elementNumber = String.valueOf(accountingLineXYZ.getIndex());
        accountingLineXYZ.setFareApplication(fareApplication);

        //Monetary Amount Details
        MonetaryAmount monetaryAmount = new MonetaryAmount();
        monetaryAmount.setValue((long)Double.parseDouble(accountingLineXYZ.getBaseFare()));
        monetaryAmount.setFormattedValue(accountingLineXYZ.getBaseFare());
        monetaryAmount.setCurrencyCode(accountingLineXYZ.getCurrencyCode());
        monetaryAmount.setNumberOfDecimals(accountingLineXYZ
                .getBaseFare().length() - accountingLineXYZ.getBaseFare()
                .lastIndexOf('.'));

        this.setBaseFare(monetaryAmount);
        this.taxAmount = new MonetaryAmount(accountingLineXYZ.getTaxAmount(),
                accountingLineXYZ.getCurrencyCode(),
                ((long)Double.parseDouble(accountingLineXYZ.getTaxAmount())),
                accountingLineXYZ.getTaxAmount().length() -accountingLineXYZ.getTaxAmount()
                        .lastIndexOf('.') - 1);

        this.gstAmount = new MonetaryAmount(accountingLineXYZ.getGstAmount(),
                accountingLineXYZ.getCurrencyCode(),
                Long.valueOf(accountingLineXYZ.getGstAmount()),
                accountingLineXYZ.getGstAmount().length() - accountingLineXYZ.getGstAmount()
                        .lastIndexOf('.') - 1);
        accountingLineXYZ.setGstCode(gstCode);
        this.qstAmount = new MonetaryAmount(accountingLineXYZ.getQstAmount(),
                accountingLineXYZ.getCurrencyCode(),
                Long.valueOf(accountingLineXYZ.getQstAmount()),
                accountingLineXYZ.getQstAmount().length() - accountingLineXYZ.getQstAmount()
                        .lastIndexOf('.') -1);
        this.qstCode = accountingLineXYZ.getQstCode();

        //Monetary Percentage Details
        MonetaryPercentage monetaryPercentage = new MonetaryPercentage();

        monetaryPercentage.setPercentage(BigDecimal.valueOf(Double.parseDouble(accountingLineXYZ.getCommissionPercentage())));
        monetaryPercentage.setAmount(new MonetaryAmount(accountingLineXYZ.getCommissionAmount(),
                accountingLineXYZ.getCurrencyCode(),
                ((long)Double.parseDouble(accountingLineXYZ.getCommissionAmount())),
                accountingLineXYZ.getCommissionAmount().length() - accountingLineXYZ.getCommissionAmount()
                        .lastIndexOf('.')-1));
        this.commission = monetaryPercentage;

        accountingLineXYZ.setFreeFormText(freeFormText);

        //Monetary Amount for TaxSurCharge
        MonetaryAmount newTotalTaxSurcharge = new MonetaryAmount();
        newTotalTaxSurcharge.setFormattedValue(String.valueOf(Long.valueOf(accountingLineXYZ.getGstAmount() + Long.valueOf(accountingLineXYZ.getQstAmount()))));
        newTotalTaxSurcharge.setValue((long)(Double.parseDouble(accountingLineXYZ.getGstAmount()) + Double.parseDouble(accountingLineXYZ.getQstAmount())));
        newTotalTaxSurcharge.setNumberOfDecimals(accountingLineXYZ.getTaxAmount().length() - accountingLineXYZ.getTaxAmount().lastIndexOf('.')-1);
        newTotalTaxSurcharge.setCurrencyCode(accountingLineXYZ.getCurrencyCode());
        this.totalTaxSurcharge = newTotalTaxSurcharge;

        this.totalTaxAmount = new MonetaryAmount(String.valueOf(this.taxAmount.getValue() + this.totalTaxSurcharge.getValue()),
                accountingLineXYZ.getCurrencyCode(),
                (this.taxAmount.getValue() + this.totalTaxSurcharge.getValue()),
                accountingLineXYZ.getTaxAmount().length() - accountingLineXYZ.getTaxAmount().lastIndexOf('.')-1);


        return accountingLineXYZ;
    }

    public static class Builder{

    }*/

}
